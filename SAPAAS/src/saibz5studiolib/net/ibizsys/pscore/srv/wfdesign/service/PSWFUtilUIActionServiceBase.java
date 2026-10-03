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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.wfdesign.service;

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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFUtilUIActionDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFUtilUIActionDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSetting;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSettingBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFUtilUIActionServiceBase
extends PSCoreSysServiceBase<PSWFUtilUIAction> {
    private static final Log log = LogFactory.getLog(PSWFUtilUIActionServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWFUtilUIActionDEModel pSWFUtilUIActionDEModel;
    private PSWFUtilUIActionDAO pSWFUtilUIActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService";
    }

    public PSWFUtilUIActionDEModel getPSWFUtilUIActionDEModel() {
        if (this.pSWFUtilUIActionDEModel == null) {
            try {
                this.pSWFUtilUIActionDEModel = (PSWFUtilUIActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFUtilUIActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFUtilUIActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFUtilUIActionDEModel();
    }

    public PSWFUtilUIActionDAO getPSWFUtilUIActionDAO() {
        if (this.pSWFUtilUIActionDAO == null) {
            try {
                this.pSWFUtilUIActionDAO = (PSWFUtilUIActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFUtilUIActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFUtilUIActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFUtilUIActionDAO();
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

    protected void onFillParentInfo(PSWFUtilUIAction pSWFUtilUIAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFUTILUIACTION_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSWFUtilUIAction, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService", (SessionFactory)this.getSessionFactory());
            PSSysWFSetting pSSysWFSetting = (PSSysWFSetting)iService.getDEModel().createEntity();
            pSSysWFSetting.set("PSSYSWFSETTINGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysWFSetting);
            } else {
                iService.get(pSSysWFSetting);
            }
            this.onFillParentInfo_PSSysWFSetting(pSWFUtilUIAction, pSSysWFSetting);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFUTILUIACTION_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFVersion);
            } else {
                iService.get(pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSWFUtilUIAction, pSWFVersion);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFUTILUIACTION_PSWORKFLOW_PSWORKFLOWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkflow);
            } else {
                iService.get(pSWorkflow);
            }
            this.onFillParentInfo_PSWorkflow(pSWFUtilUIAction, pSWorkflow);
            return;
        }
        super.onFillParentInfo(pSWFUtilUIAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEUIAction(PSWFUtilUIAction pSWFUtilUIAction, PSDEUIAction pSDEUIAction) throws Exception {
        pSWFUtilUIAction.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSWFUtilUIAction.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSSysWFSetting(PSWFUtilUIAction pSWFUtilUIAction, PSSysWFSetting pSSysWFSetting) throws Exception {
        pSWFUtilUIAction.setPSSysWFSettingId(pSSysWFSetting.getPSSysWFSettingId());
        pSWFUtilUIAction.setPSSysWFSettingName(pSSysWFSetting.getPSSysWFSettingName());
    }

    protected void onFillParentInfo_PSWFVersion(PSWFUtilUIAction pSWFUtilUIAction, PSWFVersion pSWFVersion) throws Exception {
        pSWFUtilUIAction.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSWFUtilUIAction.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillParentInfo_PSWorkflow(PSWFUtilUIAction pSWFUtilUIAction, PSWorkflow pSWorkflow) throws Exception {
        pSWFUtilUIAction.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
        pSWFUtilUIAction.setPSWorkflowName(pSWorkflow.getPSWorkflowName());
    }

    protected boolean onFillEntityKeyValue(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSWFUtilUIAction.get("PSSYSWFSETTINGID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSWFUtilUIAction.get("UTILTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSWFUtilUIAction.get("PSWORKFLOWID");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        stringBuilderEx.append("||");
        Object object4 = pSWFUtilUIAction.get("PSWFVERSIONID");
        if (object4 == null) {
            object4 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object4);
        String string = stringBuilderEx.toString();
        pSWFUtilUIAction.set(this.getPSWFUtilUIActionDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
        if (bl && pSWFUtilUIAction.getValidFlag() == null) {
            pSWFUtilUIAction.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSWFUtilUIAction, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSWFUtilUIAction, bl);
        this.onFillEntityFullInfo_PSSysWFSetting(pSWFUtilUIAction, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSWFUtilUIAction, bl);
        this.onFillEntityFullInfo_PSWorkflow(pSWFUtilUIAction, bl);
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysWFSetting(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
        if (pSWFUtilUIAction.isPSSysWFSettingIdDirty()) {
            if (pSWFUtilUIAction.getPSSysWFSettingId() != null) {
                if (pSWFUtilUIAction.getPSSysWFSettingId() == null || pSWFUtilUIAction.getPSSysWFSettingName() == null) {
                    PSSysWFSetting pSSysWFSetting = pSWFUtilUIAction.getPSSysWFSetting();
                    pSWFUtilUIAction.setPSSysWFSettingName(pSSysWFSetting.getPSSysWFSettingName());
                }
            } else {
                pSWFUtilUIAction.setPSSysWFSettingName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWorkflow(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFUtilUIAction, bl);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFUtilUIAction> selectByPSSysWFSetting(PSSysWFSettingBase pSSysWFSettingBase) throws Exception {
        return this.selectByPSSysWFSetting(pSSysWFSettingBase, "", -1);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSSysWFSetting(PSSysWFSettingBase pSSysWFSettingBase, String string) throws Exception {
        return this.selectByPSSysWFSetting(pSSysWFSettingBase, string, -1);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSSysWFSetting(PSSysWFSettingBase pSSysWFSettingBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSWFSETTINGID", (Object)pSSysWFSettingBase.getPSSysWFSettingId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysWFSettingCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysWFSettingCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFUtilUIAction> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFVersionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFUtilUIAction> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWorkflow(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWorkflow(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFUtilUIAction> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWORKFLOWID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWorkflowCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWorkflowCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFUTILUIACTION_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSWFUTILUIACTION", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSWFUtilUIAction pSWFUtilUIAction : arrayList) {
            PSWFUtilUIAction pSWFUtilUIAction2 = (PSWFUtilUIAction)this.getDEModel().createEntity();
            pSWFUtilUIAction2.setPSWFUtilUIActionId(pSWFUtilUIAction.getPSWFUtilUIActionId());
            pSWFUtilUIAction2.setPSDEUIActionId(null);
            this.update(pSWFUtilUIAction2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFUtilUIActionServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSWFUtilUIActionServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSWFUtilUIActionServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSWFUtilUIAction pSWFUtilUIAction : arrayList) {
            this.remove(pSWFUtilUIAction);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSWFUtilUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSWFUtilUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysWFSetting(PSSysWFSetting pSSysWFSetting) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSSysWFSetting(pSSysWFSetting, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSWFSETTING");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysWFSetting);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", "", iDataEntityModel.getName(), "PSWFUTILUIACTION", iDataEntityModel.getDataInfo(pSSysWFSetting), arrayList.get(0)));
        }
    }

    public void resetPSSysWFSetting(PSSysWFSetting pSSysWFSetting) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSSysWFSetting(pSSysWFSetting);
        for (PSWFUtilUIAction pSWFUtilUIAction : arrayList) {
            PSWFUtilUIAction pSWFUtilUIAction2 = (PSWFUtilUIAction)this.getDEModel().createEntity();
            pSWFUtilUIAction2.setPSWFUtilUIActionId(pSWFUtilUIAction.getPSWFUtilUIActionId());
            pSWFUtilUIAction2.setPSSysWFSettingId(null);
            this.update(pSWFUtilUIAction2);
        }
    }

    public void removeByPSSysWFSetting(PSSysWFSetting pSSysWFSetting) throws Exception {
        final PSSysWFSetting pSSysWFSetting2 = pSSysWFSetting;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFUtilUIActionServiceBase.this.onBeforeRemoveByPSSysWFSetting(pSSysWFSetting2);
                PSWFUtilUIActionServiceBase.this.internalRemoveByPSSysWFSetting(pSSysWFSetting2);
                PSWFUtilUIActionServiceBase.this.onAfterRemoveByPSSysWFSetting(pSSysWFSetting2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysWFSetting(PSSysWFSetting pSSysWFSetting) throws Exception {
    }

    protected void internalRemoveByPSSysWFSetting(PSSysWFSetting pSSysWFSetting) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSSysWFSetting(pSSysWFSetting);
        this.onBeforeRemoveByPSSysWFSetting(pSSysWFSetting, arrayList);
        for (PSWFUtilUIAction pSWFUtilUIAction : arrayList) {
            this.remove(pSWFUtilUIAction);
        }
        this.onAfterRemoveByPSSysWFSetting(pSSysWFSetting, arrayList);
    }

    protected void onAfterRemoveByPSSysWFSetting(PSSysWFSetting pSSysWFSetting) throws Exception {
    }

    protected void onBeforeRemoveByPSSysWFSetting(PSSysWFSetting pSSysWFSetting, ArrayList<PSWFUtilUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysWFSetting(PSSysWFSetting pSSysWFSetting, ArrayList<PSWFUtilUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSWFVersion(pSWFVersion, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFVERSION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFVersion);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFUTILUIACTION_PSWFVERSION_PSWFVERSIONID", "", iDataEntityModel.getName(), "PSWFUTILUIACTION", iDataEntityModel.getDataInfo(pSWFVersion), arrayList.get(0)));
        }
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSWFUtilUIAction pSWFUtilUIAction : arrayList) {
            PSWFUtilUIAction pSWFUtilUIAction2 = (PSWFUtilUIAction)this.getDEModel().createEntity();
            pSWFUtilUIAction2.setPSWFUtilUIActionId(pSWFUtilUIAction.getPSWFUtilUIActionId());
            pSWFUtilUIAction2.setPSWFVersionId(null);
            this.update(pSWFUtilUIAction2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFUtilUIActionServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSWFUtilUIActionServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSWFUtilUIActionServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFUtilUIAction pSWFUtilUIAction : arrayList) {
            this.remove(pSWFUtilUIAction);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFUtilUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFUtilUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSWorkflow(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFUTILUIACTION_PSWORKFLOW_PSWORKFLOWID", "", iDataEntityModel.getName(), "PSWFUTILUIACTION", iDataEntityModel.getDataInfo(pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSWorkflow(pSWorkflow);
        for (PSWFUtilUIAction pSWFUtilUIAction : arrayList) {
            PSWFUtilUIAction pSWFUtilUIAction2 = (PSWFUtilUIAction)this.getDEModel().createEntity();
            pSWFUtilUIAction2.setPSWFUtilUIActionId(pSWFUtilUIAction.getPSWFUtilUIActionId());
            pSWFUtilUIAction2.setPSWorkflowId(null);
            this.update(pSWFUtilUIAction2);
        }
    }

    public void removeByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFUtilUIActionServiceBase.this.onBeforeRemoveByPSWorkflow(pSWorkflow2);
                PSWFUtilUIActionServiceBase.this.internalRemoveByPSWorkflow(pSWorkflow2);
                PSWFUtilUIActionServiceBase.this.onAfterRemoveByPSWorkflow(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFUtilUIAction> arrayList = this.selectByPSWorkflow(pSWorkflow);
        this.onBeforeRemoveByPSWorkflow(pSWorkflow, arrayList);
        for (PSWFUtilUIAction pSWFUtilUIAction : arrayList) {
            this.remove(pSWFUtilUIAction);
        }
        this.onAfterRemoveByPSWorkflow(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkflow(PSWorkflow pSWorkflow, ArrayList<PSWFUtilUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkflow(PSWorkflow pSWorkflow, ArrayList<PSWFUtilUIAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFUtilUIAction pSWFUtilUIAction) throws Exception {
        super.onBeforeRemove(pSWFUtilUIAction);
    }

    protected void replaceParentInfo(PSWFUtilUIAction pSWFUtilUIAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWFUtilUIAction, cloneSession);
        if (pSWFUtilUIAction.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSWFUtilUIAction.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSWFUtilUIAction, (PSDEUIAction)iEntity);
        }
        if (pSWFUtilUIAction.getPSSysWFSettingId() != null && (iEntity = cloneSession.getEntity("PSSYSWFSETTING", (Object)pSWFUtilUIAction.getPSSysWFSettingId())) != null) {
            this.onFillParentInfo_PSSysWFSetting(pSWFUtilUIAction, (PSSysWFSetting)iEntity);
        }
        if (pSWFUtilUIAction.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFUtilUIAction.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSWFUtilUIAction, (PSWFVersion)iEntity);
        }
        if (pSWFUtilUIAction.getPSWorkflowId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFUtilUIAction.getPSWorkflowId())) != null) {
            this.onFillParentInfo_PSWorkflow(pSWFUtilUIAction, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFUtilUIAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFUtilUIAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysWFSettingId(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysWFSettingName(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFUtilUIActionId(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFUtilUIActionName(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkflowId(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilType(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSWFUtilUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFUtilUIAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isDynaModelFlagDirty() : !pSWFUtilUIAction.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFUtilUIAction.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSWFUtilUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isMemoDirty() : !pSWFUtilUIAction.isMemoDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFUtilUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isPSDEUIActionIdDirty() && !bl2 : !pSWFUtilUIAction.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getPSDEUIActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSWFUtilUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isPSDynaInstIdDirty() : !pSWFUtilUIAction.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSWFUtilUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysWFSettingId(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isPSSysWFSettingIdDirty() && !bl2 : !pSWFUtilUIAction.isPSSysWFSettingIdDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getPSSysWFSettingId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFSETTINGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysWFSettingId_Default(pSWFUtilUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFSETTINGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysWFSettingName(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isPSSysWFSettingNameDirty() && !bl2 : !pSWFUtilUIAction.isPSSysWFSettingNameDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getPSSysWFSettingName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFSETTINGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysWFSettingName_Default(pSWFUtilUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFSETTINGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFUtilUIActionId(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isPSWFUtilUIActionIdDirty() && !bl2 : !pSWFUtilUIAction.isPSWFUtilUIActionIdDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getPSWFUtilUIActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFUTILUIACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFUtilUIActionId_Default(pSWFUtilUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFUTILUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFUtilUIActionName(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isPSWFUtilUIActionNameDirty() && !bl2 : !pSWFUtilUIAction.isPSWFUtilUIActionNameDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getPSWFUtilUIActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFUTILUIACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFUtilUIActionName_Default(pSWFUtilUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFUTILUIACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isPSWFVersionIdDirty() : !pSWFUtilUIAction.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default(pSWFUtilUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkflowId(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isPSWorkflowIdDirty() : !pSWFUtilUIAction.isPSWorkflowIdDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getPSWorkflowId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkflowId_Default(pSWFUtilUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKFLOWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilType(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isUtilTypeDirty() && !bl2 : !pSWFUtilUIAction.isUtilTypeDirty()) {
            return null;
        }
        String string = pSWFUtilUIAction.getUtilType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilType_Default(pSWFUtilUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSWFUtilUIAction pSWFUtilUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFUtilUIAction.isValidFlagDirty() && !bl2 : !pSWFUtilUIAction.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSWFUtilUIAction.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSWFUtilUIAction, bl2, bl3);
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

    protected void onSyncEntity(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
        super.onSyncEntity(pSWFUtilUIAction, bl);
    }

    protected void onSyncIndexEntities(PSWFUtilUIAction pSWFUtilUIAction, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFUtilUIAction, bl);
    }

    public Object getDataContextValue(PSWFUtilUIAction pSWFUtilUIAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWFUtilUIAction, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWFUtilUIAction pSWFUtilUIAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWFUtilUIAction, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFSETTINGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFSettingId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFSETTINGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFSettingName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFUTILUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFUtilUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFUTILUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFUtilUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkflowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkflowName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSysWFSettingId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFSETTINGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysWFSettingName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFSETTINGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFUtilUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFUTILUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFUtilUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFUTILUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkflowId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKFLOWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkflowName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKFLOWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UtilType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSWFUtilUIAction pSWFUtilUIAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWFUtilUIAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFUtilUIAction pSWFUtilUIAction) throws Exception {
        super.onUpdateParent(pSWFUtilUIAction);
    }

    @Override
    protected void exportCurXmlModel(PSWFUtilUIAction pSWFUtilUIAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFUTILUIACTION");
        if (!bl) {
            pSWFUtilUIAction.setCreateDate(null);
            pSWFUtilUIAction.setCreateMan(null);
            pSWFUtilUIAction.setPSWFUtilUIActionId(null);
            pSWFUtilUIAction.setUpdateDate(null);
            pSWFUtilUIAction.setUpdateMan(null);
            super.exportCurXmlModel(pSWFUtilUIAction, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSWFUtilUIAction pSWFUtilUIAction, PSSystem pSSystem) throws Exception {
        PSWFUtilUIAction pSWFUtilUIAction2 = new PSWFUtilUIAction();
        pSWFUtilUIAction2.setPSSysWFSettingId(pSWFUtilUIAction.getPSSysWFSettingId());
        pSWFUtilUIAction2.setUtilType(pSWFUtilUIAction.getUtilType());
        pSWFUtilUIAction2.setPSWorkflowId(pSWFUtilUIAction.getPSWorkflowId());
        pSWFUtilUIAction2.setPSWFVersionId(pSWFUtilUIAction.getPSWFVersionId());
        if (this.selectOne(pSWFUtilUIAction2, true)) {
            return pSWFUtilUIAction2.getPSWFUtilUIActionId();
        }
        return super.getEntityFolderKeyValue(pSWFUtilUIAction, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFUtilUIAction pSWFUtilUIAction, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFUtilUIAction, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFVERSION#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWORKFLOWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSWFSETTINGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSWFSETTING#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFUTILUIACTION_PSWFVERSION_PSWFVERSIONID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWORKFLOWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFUTILUIACTION_PSWORKFLOW_PSWORKFLOWID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSWFSETTINGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWORKFLOWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWORKFLOWNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSWFSETTINGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSWFSETTINGNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWFVERSION", (boolean)true) == 0) {
            iEntity.set("PSWFVERSIONID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOW", (boolean)true) == 0) {
            iEntity.set("PSWORKFLOWID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFSETTING", (boolean)true) == 0) {
            iEntity.set("PSSYSWFSETTINGID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWFVERSIONID", "PSWORKFLOWID", "PSSYSWFSETTINGID"};
    }

    @Override
    public String getModelV2Tag(PSWFUtilUIAction pSWFUtilUIAction) {
        if (!StringHelper.isNullOrEmpty((String)pSWFUtilUIAction.getUtilType())) {
            return pSWFUtilUIAction.getUtilType();
        }
        return super.getModelV2Tag(pSWFUtilUIAction);
    }

    @Override
    public boolean setModelV2Tag(PSWFUtilUIAction pSWFUtilUIAction, String string) {
        pSWFUtilUIAction.setUtilType(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("UTILTYPE", "");
        map.put("PSWFVERSIONID", "");
        map.put("PSWORKFLOWID", "");
        map.put("PSSYSWFSETTINGID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFUtilUIAction pSWFUtilUIAction, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFUtilUIAction.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFUtilUIAction, true);
        pSWFUtilUIAction.set("UTILTYPE", string);
        if (this.select(pSWFUtilUIAction, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFUtilUIAction, true);
        return super.getModelV2Entity(pSWFUtilUIAction, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFUtilUIAction pSWFUtilUIAction, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSWFUtilUIAction, objectNode, string, string2, n);
    }
}

