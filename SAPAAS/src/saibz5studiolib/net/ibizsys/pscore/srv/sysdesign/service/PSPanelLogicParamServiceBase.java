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
import net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLogicParamDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLogicParamDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModelBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLogicParamServiceBase
extends PSCoreSysServiceBase<PSPanelLogicParam> {
    private static final Log log = LogFactory.getLog(PSPanelLogicParamServiceBase.class);
    public static final String DATASET_CURLOGIC = "CurLogic";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPanelLogicParamDEModel pSPanelLogicParamDEModel;
    private PSPanelLogicParamDAO pSPanelLogicParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService";
    }

    public PSPanelLogicParamDEModel getPSPanelLogicParamDEModel() {
        if (this.pSPanelLogicParamDEModel == null) {
            try {
                this.pSPanelLogicParamDEModel = (PSPanelLogicParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLogicParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLogicParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPanelLogicParamDEModel();
    }

    public PSPanelLogicParamDAO getPSPanelLogicParamDAO() {
        if (this.pSPanelLogicParamDAO == null) {
            try {
                this.pSPanelLogicParamDAO = (PSPanelLogicParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLogicParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLogicParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPanelLogicParamDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURLOGIC, (boolean)true) == 0) {
            return this.fetchCurLogic(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURLOGIC, (boolean)true) == 0) {
            return this.fetchTempCurLogic(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurLogic(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURLOGIC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurLogic(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURLOGIC, true);
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

    protected void onFillParentInfo(PSPanelLogicParam pSPanelLogicParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)iService.getDEModel().createEntity();
            pSSysViewPanelLogic.set("PSSYSVIEWPANELLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanelLogic);
            } else {
                iService.get(pSSysViewPanelLogic);
            }
            this.onFillParentInfo_PSSysViewPanelLogic(pSPanelLogicParam, pSSysViewPanelLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELMODEL_PSSYSVIEWPANELMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelModel pSSysViewPanelModel = (PSSysViewPanelModel)iService.getDEModel().createEntity();
            pSSysViewPanelModel.set("PSSYSVIEWPANELMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanelModel);
            } else {
                iService.get(pSSysViewPanelModel);
            }
            this.onFillParentInfo_PSSysViewPanelModel(pSPanelLogicParam, pSSysViewPanelModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicParam, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSPanelLogicParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysViewPanelLogic(PSPanelLogicParam pSPanelLogicParam, PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSPanelLogicParam.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSPanelLogicParam.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
        if (pSSysViewPanelLogic.getPSSysViewPanel() != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicParam, pSSysViewPanelLogic.getPSSysViewPanel());
        }
    }

    protected void onFillParentInfo_PSSysViewPanelModel(PSPanelLogicParam pSPanelLogicParam, PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        pSPanelLogicParam.setPSSysViewPanelModelId(pSSysViewPanelModel.getPSSysViewPanelModelId());
        pSPanelLogicParam.setPSSysViewPanelModelName(pSSysViewPanelModel.getPSSysViewPanelModelName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSPanelLogicParam pSPanelLogicParam, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSPanelLogicParam.setPSSystemId(pSSysViewPanel.getPSSystemId());
        pSPanelLogicParam.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSPanelLogicParam.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSPanelLogicParam pSPanelLogicParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPanelLogicParam, bl);
        this.onFillEntityFullInfo_PSSysViewPanelLogic(pSPanelLogicParam, bl);
        this.onFillEntityFullInfo_PSSysViewPanelModel(pSPanelLogicParam, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLogicParam, bl);
    }

    protected void onFillEntityFullInfo_PSSysViewPanelLogic(PSPanelLogicParam pSPanelLogicParam, boolean bl) throws Exception {
        if (pSPanelLogicParam.isPSSysViewPanelLogicIdDirty()) {
            if (pSPanelLogicParam.getPSSysViewPanelLogicId() != null) {
                PSSysViewPanelLogic pSSysViewPanelLogic;
                if (pSPanelLogicParam.getPSSysViewPanelLogicId() == null || pSPanelLogicParam.getPSSysViewPanelLogicName() == null) {
                    pSSysViewPanelLogic = pSPanelLogicParam.getPSSysViewPanelLogic();
                    pSPanelLogicParam.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSSysViewPanelLogic = pSPanelLogicParam.getPSSysViewPanelLogic()).getPSSysViewPanelId(), (Object)pSPanelLogicParam.getPSSysViewPanelId()) != 0L) {
                    pSPanelLogicParam.setPSSysViewPanelId(pSSysViewPanelLogic.getPSSysViewPanelId());
                    this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLogicParam, bl);
                }
            } else {
                pSPanelLogicParam.setPSSysViewPanelLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysViewPanelModel(PSPanelLogicParam pSPanelLogicParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSPanelLogicParam pSPanelLogicParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPanelLogicParam pSPanelLogicParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSPanelLogicParam, bl);
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectByPSSysViewPanelLogic(pSSysViewPanelLogicBase, "", -1);
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        return this.selectByPSSysViewPanelLogic(pSSysViewPanelLogicBase, string, -1);
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicParam> selectTempByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogicBase, "");
    }

    public ArrayList<PSPanelLogicParam> selectTempByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase) throws Exception {
        return this.selectByPSSysViewPanelModel(pSSysViewPanelModelBase, "", -1);
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string) throws Exception {
        return this.selectByPSSysViewPanelModel(pSSysViewPanelModelBase, string, -1);
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELMODELID", (Object)pSSysViewPanelModelBase.getPSSysViewPanelModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicParam> selectTempByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase) throws Exception {
        return this.selectTempByPSSysViewPanelModel(pSSysViewPanelModelBase, "");
    }

    public ArrayList<PSPanelLogicParam> selectTempByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELMODELID", (Object)pSSysViewPanelModelBase.getPSSysViewPanelModelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelModelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSPanelLogicParam> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLogicParam> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSPanelLogicParam> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    public void resetPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            PSPanelLogicParam pSPanelLogicParam2 = (PSPanelLogicParam)this.getDEModel().createEntity();
            pSPanelLogicParam2.setPSPanelLogicParamId(pSPanelLogicParam.getPSPanelLogicParamId());
            pSPanelLogicParam2.setPSSysViewPanelLogicId(null);
            this.update(pSPanelLogicParam2);
        }
    }

    public void resetTempPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            PSPanelLogicParam pSPanelLogicParam2 = (PSPanelLogicParam)this.getDEModel().createEntity();
            pSPanelLogicParam2.setPSPanelLogicParamId(pSPanelLogicParam.getPSPanelLogicParamId());
            pSPanelLogicParam2.setPSSysViewPanelLogicId(null);
            this.updateTemp(pSPanelLogicParam2);
        }
    }

    public void removeByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicParamServiceBase.this.onBeforeRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicParamServiceBase.this.internalRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicParamServiceBase.this.onAfterRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            this.remove(pSPanelLogicParam);
        }
        this.onAfterRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectByPSSysViewPanelModel(pSSysViewPanelModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanelModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELMODEL_PSSYSVIEWPANELMODELID", "", iDataEntityModel.getName(), "PSPANELLOGICPARAM", iDataEntityModel.getDataInfo(pSSysViewPanelModel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectByPSSysViewPanelModel(pSSysViewPanelModel);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            PSPanelLogicParam pSPanelLogicParam2 = (PSPanelLogicParam)this.getDEModel().createEntity();
            pSPanelLogicParam2.setPSPanelLogicParamId(pSPanelLogicParam.getPSPanelLogicParamId());
            pSPanelLogicParam2.setPSSysViewPanelModelId(null);
            this.update(pSPanelLogicParam2);
        }
    }

    public void resetTempPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectTempByPSSysViewPanelModel(pSSysViewPanelModel);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            PSPanelLogicParam pSPanelLogicParam2 = (PSPanelLogicParam)this.getDEModel().createEntity();
            pSPanelLogicParam2.setPSPanelLogicParamId(pSPanelLogicParam.getPSPanelLogicParamId());
            pSPanelLogicParam2.setPSSysViewPanelModelId(null);
            this.updateTemp(pSPanelLogicParam2);
        }
    }

    public void removeByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        final PSSysViewPanelModel pSSysViewPanelModel2 = pSSysViewPanelModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicParamServiceBase.this.onBeforeRemoveByPSSysViewPanelModel(pSSysViewPanelModel2);
                PSPanelLogicParamServiceBase.this.internalRemoveByPSSysViewPanelModel(pSSysViewPanelModel2);
                PSPanelLogicParamServiceBase.this.onAfterRemoveByPSSysViewPanelModel(pSSysViewPanelModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectByPSSysViewPanelModel(pSSysViewPanelModel);
        this.onBeforeRemoveByPSSysViewPanelModel(pSSysViewPanelModel, arrayList);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            this.remove(pSPanelLogicParam);
        }
        this.onAfterRemoveByPSSysViewPanelModel(pSSysViewPanelModel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            PSPanelLogicParam pSPanelLogicParam2 = (PSPanelLogicParam)this.getDEModel().createEntity();
            pSPanelLogicParam2.setPSPanelLogicParamId(pSPanelLogicParam.getPSPanelLogicParamId());
            pSPanelLogicParam2.setPSSysViewPanelId(null);
            this.update(pSPanelLogicParam2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            PSPanelLogicParam pSPanelLogicParam2 = (PSPanelLogicParam)this.getDEModel().createEntity();
            pSPanelLogicParam2.setPSPanelLogicParamId(pSPanelLogicParam.getPSPanelLogicParamId());
            pSPanelLogicParam2.setPSSysViewPanelId(null);
            this.updateTemp(pSPanelLogicParam2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicParamServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicParamServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicParamServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            this.remove(pSPanelLogicParam);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLLCondServiceBase)pSCoreSysServiceBase).testRemoveByDstPSPanelLP(pSPanelLogicParam);
        pSCoreSysServiceBase = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).testRemoveByDstPSPanelLP(pSPanelLogicParam);
        pSCoreSysServiceBase = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSPanelLP(pSPanelLogicParam);
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSPanelLogicParam(pSPanelLogicParam);
        super.onBeforeRemove(pSPanelLogicParam);
    }

    protected void onBeforeRemoveTemp(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).resetTempPSPanelLogicParam(pSPanelLogicParam);
        pSCoreSysServiceBase = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).resetTempSrcPSPanelLP(pSPanelLogicParam);
        pSCoreSysServiceBase = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).resetTempDstPSPanelLP(pSPanelLogicParam);
        pSCoreSysServiceBase = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLLCondServiceBase)pSCoreSysServiceBase).resetTempDstPSPanelLP(pSPanelLogicParam);
        super.onBeforeRemoveTemp(pSPanelLogicParam);
    }

    public void removeTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        final PSSysViewPanelModel pSSysViewPanelModel2 = pSSysViewPanelModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicParamServiceBase.this.onBeforeRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel2);
                PSPanelLogicParamServiceBase.this.internalRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel2);
                PSPanelLogicParamServiceBase.this.onAfterRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectTempByPSSysViewPanelModel(pSSysViewPanelModel);
        this.onBeforeRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel, arrayList);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            this.removeTemp(pSPanelLogicParam);
        }
        this.onAfterRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicParamServiceBase.this.onBeforeRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicParamServiceBase.this.internalRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicParamServiceBase.this.onAfterRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            this.removeTemp(pSPanelLogicParam);
        }
        this.onAfterRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicParamServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicParamServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicParamServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicParam> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            this.removeTemp(pSPanelLogicParam);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        super.getRelatedDataTempMajor(pSPanelLogicParam);
    }

    protected void updateRelatedDataTempMajor(PSPanelLogicParam pSPanelLogicParam, PSPanelLogicParam pSPanelLogicParam2) throws Exception {
        super.updateRelatedDataTempMajor(pSPanelLogicParam, pSPanelLogicParam2);
    }

    protected void replaceParentInfo(PSPanelLogicParam pSPanelLogicParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPanelLogicParam, cloneSession);
        if (pSPanelLogicParam.getPSSysViewPanelLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELLOGIC", (Object)pSPanelLogicParam.getPSSysViewPanelLogicId())) != null) {
            this.onFillParentInfo_PSSysViewPanelLogic(pSPanelLogicParam, (PSSysViewPanelLogic)iEntity);
        }
        if (pSPanelLogicParam.getPSSysViewPanelModelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELMODEL", (Object)pSPanelLogicParam.getPSSysViewPanelModelId())) != null) {
            this.onFillParentInfo_PSSysViewPanelModel(pSPanelLogicParam, (PSSysViewPanelModel)iEntity);
        }
        if (pSPanelLogicParam.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSPanelLogicParam.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicParam, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPanelLogicParam pSPanelLogicParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPanelLogicParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArrayFlag(bl, pSPanelLogicParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataType(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicParamId(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicParamName(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelLogicId(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelLogicName(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelModelId(bl, pSPanelLogicParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPanelLogicParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArrayFlag(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isArrayFlagDirty() : !pSPanelLogicParam.isArrayFlagDirty()) {
            return null;
        }
        Integer n = pSPanelLogicParam.getArrayFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArrayFlag_Default(pSPanelLogicParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARRAYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isCodeNameDirty() : !pSPanelLogicParam.isCodeNameDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSPanelLogicParam, bl2, bl3);
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
                string3 = "PSSYSVIEWPANELLOGICID";
                String string4 = this.checkFieldDupRule(this.getPSPanelLogicParamDEModel(), "CODENAME", string3, pSPanelLogicParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataType(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isDataTypeDirty() : !pSPanelLogicParam.isDataTypeDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataType_Default(pSPanelLogicParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isLogicNameDirty() : !pSPanelLogicParam.isLogicNameDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSPanelLogicParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isMemoDirty() : !pSPanelLogicParam.isMemoDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPanelLogicParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isParamTypeDirty() : !pSPanelLogicParam.isParamTypeDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default(pSPanelLogicParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicParamId(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isPSPanelLogicParamIdDirty() && !bl2 : !pSPanelLogicParam.isPSPanelLogicParamIdDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getPSPanelLogicParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicParamId_Default(pSPanelLogicParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicParamName(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isPSPanelLogicParamNameDirty() && !bl2 : !pSPanelLogicParam.isPSPanelLogicParamNameDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getPSPanelLogicParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicParamName_Default(pSPanelLogicParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isPSSysViewPanelIdDirty() && !bl2 : !pSPanelLogicParam.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getPSSysViewPanelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSPanelLogicParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelLogicId(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isPSSysViewPanelLogicIdDirty() && !bl2 : !pSPanelLogicParam.isPSSysViewPanelLogicIdDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getPSSysViewPanelLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelLogicId_Default(pSPanelLogicParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelLogicName(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isPSSysViewPanelLogicNameDirty() : !pSPanelLogicParam.isPSSysViewPanelLogicNameDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getPSSysViewPanelLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelLogicName_Default(pSPanelLogicParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelModelId(boolean bl, PSPanelLogicParam pSPanelLogicParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicParam.isPSSysViewPanelModelIdDirty() : !pSPanelLogicParam.isPSSysViewPanelModelIdDirty()) {
            return null;
        }
        String string = pSPanelLogicParam.getPSSysViewPanelModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelModelId_Default(pSPanelLogicParam, bl2, bl3);
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

    protected void onSyncEntity(PSPanelLogicParam pSPanelLogicParam, boolean bl) throws Exception {
        super.onSyncEntity(pSPanelLogicParam, bl);
    }

    protected void onSyncIndexEntities(PSPanelLogicParam pSPanelLogicParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPanelLogicParam, bl);
    }

    public Object getDataContextValue(PSPanelLogicParam pSPanelLogicParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPanelLogicParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysViewPanelLogic pSSysViewPanelLogic = pSPanelLogicParam.getPSSysViewPanelLogic();
        if (pSSysViewPanelLogic != null && pSSysViewPanelLogic.contains(string)) {
            return pSSysViewPanelLogic.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPanelLogicParam pSPanelLogicParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPanelLogicParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ARRAYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArrayFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelLogicName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ArrayFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLogicParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLOGICPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLogicParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLOGICPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysViewPanelLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSPanelLogicParam pSPanelLogicParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPanelLogicParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        super.onUpdateParent(pSPanelLogicParam);
    }

    @Override
    protected void exportCurXmlModel(PSPanelLogicParam pSPanelLogicParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPANELLOGICPARAM");
        if (!bl) {
            pSPanelLogicParam.setCreateDate(null);
            pSPanelLogicParam.setCreateMan(null);
            pSPanelLogicParam.setPSPanelLogicParamId(null);
            pSPanelLogicParam.setUpdateDate(null);
            pSPanelLogicParam.setUpdateMan(null);
            pSPanelLogicParam.setPSSysViewPanelModelId(null);
            pSPanelLogicParam.setPSSysViewPanelLogicId(null);
            pSPanelLogicParam.setPSSysViewPanelLogicName(null);
            pSPanelLogicParam.setPSSystemId(null);
            pSPanelLogicParam.setPSSysViewPanelId(null);
            pSPanelLogicParam.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSPanelLogicParam, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSPanelLogicParam pSPanelLogicParam, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSPanelLogicParam, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSPanelLogicParam pSPanelLogicParam, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSPanelLogicParam, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSPanelLogicParam pSPanelLogicParam, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSPanelLogicParam, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSVIEWPANELLOGIC#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELLOGICNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELLOGIC", (boolean)true) == 0) {
            iEntity.set("PSSYSVIEWPANELLOGICID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSVIEWPANELLOGICID"};
    }

    @Override
    public String getModelV2Tag(PSPanelLogicParam pSPanelLogicParam) {
        if (!StringHelper.isNullOrEmpty((String)pSPanelLogicParam.getCodeName())) {
            return pSPanelLogicParam.getCodeName();
        }
        return super.getModelV2Tag(pSPanelLogicParam);
    }

    @Override
    public boolean setModelV2Tag(PSPanelLogicParam pSPanelLogicParam, String string) {
        return super.setModelV2Tag(pSPanelLogicParam, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSVIEWPANELLOGICID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSPanelLogicParam pSPanelLogicParam, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSPanelLogicParam.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSPanelLogicParam, true);
        pSPanelLogicParam.set("CODENAME", string);
        if (this.select(pSPanelLogicParam, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSPanelLogicParam, true);
        return super.getModelV2Entity(pSPanelLogicParam, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSPanelLogicParam pSPanelLogicParam, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSPanelLogicParam, objectNode, string, string2, n);
    }
}

