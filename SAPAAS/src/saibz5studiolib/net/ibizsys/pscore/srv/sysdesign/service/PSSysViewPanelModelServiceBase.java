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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelModelDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelModelDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewPanelModelServiceBase
extends PSCoreSysServiceBase<PSSysViewPanelModel> {
    private static final Log log = LogFactory.getLog(PSSysViewPanelModelServiceBase.class);
    public static final String DATASET_CURPANEL = "CurPanel";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysViewPanelModelDEModel pSSysViewPanelModelDEModel;
    private PSSysViewPanelModelDAO pSSysViewPanelModelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService";
    }

    public PSSysViewPanelModelDEModel getPSSysViewPanelModelDEModel() {
        if (this.pSSysViewPanelModelDEModel == null) {
            try {
                this.pSSysViewPanelModelDEModel = (PSSysViewPanelModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelModelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysViewPanelModelDEModel();
    }

    public PSSysViewPanelModelDAO getPSSysViewPanelModelDAO() {
        if (this.pSSysViewPanelModelDAO == null) {
            try {
                this.pSSysViewPanelModelDAO = (PSSysViewPanelModelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelModelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelModelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysViewPanelModelDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPANEL, (boolean)true) == 0) {
            return this.fetchCurPanel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPANEL, (boolean)true) == 0) {
            return this.fetchTempCurPanel(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANEL, true);
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

    protected void onFillParentInfo(PSSysViewPanelModel pSSysViewPanelModel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELMODEL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysViewPanelModel, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanelItem);
            } else {
                iService.get(pSSysViewPanelItem);
            }
            this.onFillParentInfo_PSSysViewPanelItem(pSSysViewPanelModel, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSSysViewPanelModel, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSSysViewPanelModel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysViewPanelModel pSSysViewPanelModel, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysViewPanelModel.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysViewPanelModel.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysViewPanelItem(PSSysViewPanelModel pSSysViewPanelModel, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelModel.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSSysViewPanelModel.setPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSSysViewPanelModel pSSysViewPanelModel, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysViewPanelModel.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysViewPanelModel.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSSysViewPanelModel pSSysViewPanelModel, boolean bl) throws Exception {
        if (bl && pSSysViewPanelModel.getCustomMode() == null) {
            pSSysViewPanelModel.setCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSSysViewPanelModel, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysViewPanelModel, bl);
        this.onFillEntityFullInfo_PSSysViewPanelItem(pSSysViewPanelModel, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSSysViewPanelModel, bl);
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysViewPanelModel pSSysViewPanelModel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanelItem(PSSysViewPanelModel pSSysViewPanelModel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSSysViewPanelModel pSSysViewPanelModel, boolean bl) throws Exception {
        if (pSSysViewPanelModel.isPSSysViewPanelIdDirty()) {
            if (pSSysViewPanelModel.getPSSysViewPanelId() != null) {
                if (pSSysViewPanelModel.getPSSysViewPanelId() == null || pSSysViewPanelModel.getPSSysViewPanelName() == null) {
                    PSSysViewPanel pSSysViewPanel = pSSysViewPanelModel.getPSSysViewPanel();
                    pSSysViewPanelModel.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                }
            } else {
                pSSysViewPanelModel.setPSSysViewPanelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysViewPanelModel pSSysViewPanelModel, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysViewPanelModel, bl);
    }

    public ArrayList<PSSysViewPanelModel> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysViewPanelModel> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysViewPanelModel> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelModel> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByPSSysViewPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSSysViewPanelModel> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByPSSysViewPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSSysViewPanelModel> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelModel> selectTempByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByPSSysViewPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSSysViewPanelModel> selectTempByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelModel> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysViewPanelModel> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysViewPanelModel> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelModel> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSSysViewPanelModel> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELMODEL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELMODEL", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            PSSysViewPanelModel pSSysViewPanelModel2 = (PSSysViewPanelModel)this.getDEModel().createEntity();
            pSSysViewPanelModel2.setPSSysViewPanelModelId(pSSysViewPanelModel.getPSSysViewPanelModelId());
            pSSysViewPanelModel2.setPSSysDynaModelId(null);
            this.update(pSSysViewPanelModel2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelModelServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysViewPanelModelServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysViewPanelModelServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            this.remove(pSSysViewPanelModel);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanelItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELMODEL", iDataEntityModel.getDataInfo(pSSysViewPanelItem), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            PSSysViewPanelModel pSSysViewPanelModel2 = (PSSysViewPanelModel)this.getDEModel().createEntity();
            pSSysViewPanelModel2.setPSSysViewPanelModelId(pSSysViewPanelModel.getPSSysViewPanelModelId());
            pSSysViewPanelModel2.setPSSysViewPanelItemId(null);
            this.update(pSSysViewPanelModel2);
        }
    }

    public void resetTempPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            PSSysViewPanelModel pSSysViewPanelModel2 = (PSSysViewPanelModel)this.getDEModel().createEntity();
            pSSysViewPanelModel2.setPSSysViewPanelModelId(pSSysViewPanelModel.getPSSysViewPanelModelId());
            pSSysViewPanelModel2.setPSSysViewPanelItemId(null);
            this.updateTemp(pSSysViewPanelModel2);
        }
    }

    public void removeByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelModelServiceBase.this.onBeforeRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelModelServiceBase.this.internalRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelModelServiceBase.this.onAfterRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            this.remove(pSSysViewPanelModel);
        }
        this.onAfterRemoveByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            PSSysViewPanelModel pSSysViewPanelModel2 = (PSSysViewPanelModel)this.getDEModel().createEntity();
            pSSysViewPanelModel2.setPSSysViewPanelModelId(pSSysViewPanelModel.getPSSysViewPanelModelId());
            pSSysViewPanelModel2.setPSSysViewPanelId(null);
            this.update(pSSysViewPanelModel2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            PSSysViewPanelModel pSSysViewPanelModel2 = (PSSysViewPanelModel)this.getDEModel().createEntity();
            pSSysViewPanelModel2.setPSSysViewPanelModelId(pSSysViewPanelModel.getPSSysViewPanelModelId());
            pSSysViewPanelModel2.setPSSysViewPanelId(null);
            this.updateTemp(pSSysViewPanelModel2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelModelServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelModelServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelModelServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            this.remove(pSSysViewPanelModel);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).testRemoveByDstPSPanelModel(pSSysViewPanelModel);
        pSCoreSysServiceBase = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelModel(pSSysViewPanelModel);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelModel(pSSysViewPanelModel);
        super.onBeforeRemove(pSSysViewPanelModel);
    }

    protected void onBeforeRemoveTemp(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).resetTempPSSysViewPanelModel(pSSysViewPanelModel);
        pSCoreSysServiceBase = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicParamServiceBase)pSCoreSysServiceBase).resetTempPSSysViewPanelModel(pSSysViewPanelModel);
        pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).resetTempDstPSPanelModel(pSSysViewPanelModel);
        super.onBeforeRemoveTemp(pSSysViewPanelModel);
    }

    public void removeTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelModelServiceBase.this.onBeforeRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelModelServiceBase.this.internalRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelModelServiceBase.this.onAfterRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            this.removeTemp(pSSysViewPanelModel);
        }
        this.onAfterRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelModelServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelModelServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelModelServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelModel> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            this.removeTemp(pSSysViewPanelModel);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        super.getRelatedDataTempMajor(pSSysViewPanelModel);
    }

    protected void updateRelatedDataTempMajor(PSSysViewPanelModel pSSysViewPanelModel, PSSysViewPanelModel pSSysViewPanelModel2) throws Exception {
        super.updateRelatedDataTempMajor(pSSysViewPanelModel, pSSysViewPanelModel2);
    }

    protected void replaceParentInfo(PSSysViewPanelModel pSSysViewPanelModel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysViewPanelModel, cloneSession);
        if (pSSysViewPanelModel.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysViewPanelModel.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysViewPanelModel, (PSSysDynaModel)iEntity);
        }
        if (pSSysViewPanelModel.getPSSysViewPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSSysViewPanelModel.getPSSysViewPanelItemId())) != null) {
            this.onFillParentInfo_PSSysViewPanelItem(pSSysViewPanelModel, (PSSysViewPanelItem)iEntity);
        }
        if (pSSysViewPanelModel.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysViewPanelModel.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSSysViewPanelModel, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysViewPanelModel pSSysViewPanelModel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysViewPanelModel, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysViewPanelModel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlModelName(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataType(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelTag(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelTag2(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelType(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelItemId(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelModelId(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelModelName(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelName(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefFieldName(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefModelName(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewModelName(bl, pSSysViewPanelModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysViewPanelModel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isCodeNameDirty() && !bl2 : !pSSysViewPanelModel.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysViewPanelModel, bl2, bl3);
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
                string3 = "PSSYSVIEWPANELID";
                String string4 = this.checkFieldDupRule(this.getPSSysViewPanelModelDEModel(), "CODENAME", string3, pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlModelName(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isCtrlModelNameDirty() : !pSSysViewPanelModel.isCtrlModelNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getCtrlModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlModelName_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isCustomCodeDirty() : !pSSysViewPanelModel.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isCustomModeDirty() : !pSSysViewPanelModel.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelModel.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataType(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isDataTypeDirty() && !bl2 : !pSSysViewPanelModel.isDataTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getDataType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATATYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataType_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isMemoDirty() : !pSSysViewPanelModel.isMemoDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelTag(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isModelTagDirty() : !pSSysViewPanelModel.isModelTagDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getModelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelTag_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelTag2(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isModelTag2Dirty() : !pSSysViewPanelModel.isModelTag2Dirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getModelTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelTag2_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelType(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isModelTypeDirty() && !bl2 : !pSSysViewPanelModel.isModelTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getModelType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelType_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)25, (Object)string, (Object)"CONTEXTMODEL") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"PANELMODEL") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"VIEWMODEL") == 0L;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSVIEWPANELID";
                String string4 = this.checkFieldDupRule(this.getPSSysViewPanelModelDEModel(), "MODELTYPE", string3, pSSysViewPanelModel, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MODELTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isPSSysDynaModelIdDirty() : !pSSysViewPanelModel.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isPSSysViewPanelIdDirty() : !pSSysViewPanelModel.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelItemId(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isPSSysViewPanelItemIdDirty() : !pSSysViewPanelModel.isPSSysViewPanelItemIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getPSSysViewPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelItemId_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelModelId(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isPSSysViewPanelModelIdDirty() && !bl2 : !pSSysViewPanelModel.isPSSysViewPanelModelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getPSSysViewPanelModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelModelId_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelModelName(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isPSSysViewPanelModelNameDirty() && !bl2 : !pSSysViewPanelModel.isPSSysViewPanelModelNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getPSSysViewPanelModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelModelName_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELMODELNAME");
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
                string3 = "PSSYSVIEWPANELID";
                String string4 = this.checkFieldDupRule(this.getPSSysViewPanelModelDEModel(), "PSSYSVIEWPANELMODELNAME", string3, pSSysViewPanelModel, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSVIEWPANELMODELNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelName(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isPSSysViewPanelNameDirty() : !pSSysViewPanelModel.isPSSysViewPanelNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getPSSysViewPanelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelName_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefFieldName(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isRefFieldNameDirty() : !pSSysViewPanelModel.isRefFieldNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getRefFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefFieldName_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefModelName(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isRefModelNameDirty() : !pSSysViewPanelModel.isRefModelNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getRefModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefModelName_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isUserCatDirty() : !pSSysViewPanelModel.isUserCatDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isUserTagDirty() : !pSSysViewPanelModel.isUserTagDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isUserTag2Dirty() : !pSSysViewPanelModel.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isUserTag3Dirty() : !pSSysViewPanelModel.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isUserTag4Dirty() : !pSSysViewPanelModel.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysViewPanelModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewModelName(boolean bl, PSSysViewPanelModel pSSysViewPanelModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelModel.isViewModelNameDirty() : !pSSysViewPanelModel.isViewModelNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelModel.getViewModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewModelName_Default(pSSysViewPanelModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysViewPanelModel pSSysViewPanelModel, boolean bl) throws Exception {
        super.onSyncEntity(pSSysViewPanelModel, bl);
    }

    protected void onSyncIndexEntities(PSSysViewPanelModel pSSysViewPanelModel, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysViewPanelModel, bl);
    }

    public Object getDataContextValue(PSSysViewPanelModel pSSysViewPanelModel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysViewPanelModel, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysViewPanel pSSysViewPanel = pSSysViewPanelModel.getPSSysViewPanel();
        if (pSSysViewPanel != null && pSSysViewPanel.contains(string)) {
            return pSSysViewPanel.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysViewPanelModel, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefModelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewModelName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_CtrlModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLMODELNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_DataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATATYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSSysViewPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_RefFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFFIELDNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODELNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_ViewModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWMODELNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysViewPanelModel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        super.onUpdateParent(pSSysViewPanelModel);
    }

    @Override
    protected void exportCurXmlModel(PSSysViewPanelModel pSSysViewPanelModel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSVIEWPANELMODEL");
        if (!bl) {
            pSSysViewPanelModel.setCreateDate(null);
            pSSysViewPanelModel.setCreateMan(null);
            pSSysViewPanelModel.setPSSysViewPanelModelId(null);
            pSSysViewPanelModel.setUpdateDate(null);
            pSSysViewPanelModel.setUpdateMan(null);
            pSSysViewPanelModel.setPSSysViewPanelItemId(null);
            pSSysViewPanelModel.setPSSysViewPanelId(null);
            pSSysViewPanelModel.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSSysViewPanelModel, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysViewPanelModel pSSysViewPanelModel, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSSysViewPanelModel, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysViewPanelModel pSSysViewPanelModel, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSSysViewPanelModel, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysViewPanelModel pSSysViewPanelModel, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysViewPanelModel, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANEL_PSSYSVIEWPANELID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            iEntity.set("PSSYSVIEWPANELID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSVIEWPANELID"};
    }

    @Override
    public String getModelV2Tag(PSSysViewPanelModel pSSysViewPanelModel) {
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanelModel.getCodeName())) {
            return pSSysViewPanelModel.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanelModel.getPSSysViewPanelModelName())) {
            return pSSysViewPanelModel.getPSSysViewPanelModelName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanelModel.getCodeName())) {
            return pSSysViewPanelModel.getCodeName();
        }
        return super.getModelV2Tag(pSSysViewPanelModel);
    }

    @Override
    public boolean setModelV2Tag(PSSysViewPanelModel pSSysViewPanelModel, String string) {
        return super.setModelV2Tag(pSSysViewPanelModel, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSVIEWPANELMODELNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSVIEWPANELID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysViewPanelModel pSSysViewPanelModel, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysViewPanelModel.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysViewPanelModel, true);
        pSSysViewPanelModel.set("CODENAME", string);
        if (this.select(pSSysViewPanelModel, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysViewPanelModel, true);
        return super.getModelV2Entity(pSSysViewPanelModel, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysViewPanelModel pSSysViewPanelModel, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysViewPanelModel, objectNode, string, string2, n);
    }
}

