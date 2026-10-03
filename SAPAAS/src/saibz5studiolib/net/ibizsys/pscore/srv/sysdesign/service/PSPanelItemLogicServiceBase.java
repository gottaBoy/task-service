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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSPanelItemLogicDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelItemLogicDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModelBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelItemLogicServiceBase
extends PSCoreSysServiceBase<PSPanelItemLogic> {
    private static final Log log = LogFactory.getLog(PSPanelItemLogicServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPanelItemLogicDEModel pSPanelItemLogicDEModel;
    private PSPanelItemLogicDAO pSPanelItemLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService";
    }

    public PSPanelItemLogicDEModel getPSPanelItemLogicDEModel() {
        if (this.pSPanelItemLogicDEModel == null) {
            try {
                this.pSPanelItemLogicDEModel = (PSPanelItemLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelItemLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelItemLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPanelItemLogicDEModel();
    }

    public PSPanelItemLogicDAO getPSPanelItemLogicDAO() {
        if (this.pSPanelItemLogicDAO == null) {
            try {
                this.pSPanelItemLogicDAO = (PSPanelItemLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSPanelItemLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelItemLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPanelItemLogicDAO();
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

    protected void onFillParentInfo(PSPanelItemLogic pSPanelItemLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELITEMLOGIC_PSPANELITEMLOGIC_PPSPANELITEMLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService", (SessionFactory)this.getSessionFactory());
            PSPanelItemLogic pSPanelItemLogic2 = (PSPanelItemLogic)iService.getDEModel().createEntity();
            pSPanelItemLogic2.set("PSPANELITEMLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPanelItemLogic2);
            } else {
                iService.get(pSPanelItemLogic2);
            }
            this.onFillParentInfo_PPSPanelItemLogic(pSPanelItemLogic, pSPanelItemLogic2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanelItem);
            } else {
                iService.get(pSSysViewPanelItem);
            }
            this.onFillParentInfo_PSSysViewPanelItem(pSPanelItemLogic, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELMODEL_DSTPSPANELMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelModel pSSysViewPanelModel = (PSSysViewPanelModel)iService.getDEModel().createEntity();
            pSSysViewPanelModel.set("PSSYSVIEWPANELMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanelModel);
            } else {
                iService.get(pSSysViewPanelModel);
            }
            this.onFillParentInfo_DstPSPanelModel(pSPanelItemLogic, pSSysViewPanelModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSPanelItemLogic, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSPanelItemLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic, PSPanelItemLogic pSPanelItemLogic2) throws Exception {
        pSPanelItemLogic.setPPSPanelItemLogicId(pSPanelItemLogic2.getPSPanelItemLogicId());
        pSPanelItemLogic.setPPSPanelItemLogicName(pSPanelItemLogic2.getPSPanelItemLogicName());
    }

    protected void onFillParentInfo_PSSysViewPanelItem(PSPanelItemLogic pSPanelItemLogic, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSPanelItemLogic.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSPanelItemLogic.setPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
        if (pSSysViewPanelItem.getPSSysViewPanel() != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelItemLogic, pSSysViewPanelItem.getPSSysViewPanel());
        }
    }

    protected void onFillParentInfo_DstPSPanelModel(PSPanelItemLogic pSPanelItemLogic, PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        pSPanelItemLogic.setDstPSPanelModelId(pSSysViewPanelModel.getPSSysViewPanelModelId());
        pSPanelItemLogic.setDstPSPanelModelName(pSSysViewPanelModel.getPSSysViewPanelModelName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSPanelItemLogic pSPanelItemLogic, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSPanelItemLogic.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSPanelItemLogic.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPanelItemLogic, bl);
        this.onFillEntityFullInfo_PPSPanelItemLogic(pSPanelItemLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanelItem(pSPanelItemLogic, bl);
        this.onFillEntityFullInfo_DstPSPanelModel(pSPanelItemLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSPanelItemLogic, bl);
    }

    protected void onFillEntityFullInfo_PPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
        if (pSPanelItemLogic.isPPSPanelItemLogicIdDirty()) {
            if (pSPanelItemLogic.getPPSPanelItemLogicId() != null) {
                if (pSPanelItemLogic.getPPSPanelItemLogicId() == null || pSPanelItemLogic.getPPSPanelItemLogicName() == null) {
                    PSPanelItemLogic pSPanelItemLogic2 = pSPanelItemLogic.getPPSPanelItemLogic();
                    pSPanelItemLogic.setPPSPanelItemLogicName(pSPanelItemLogic2.getPSPanelItemLogicName());
                }
            } else {
                pSPanelItemLogic.setPPSPanelItemLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysViewPanelItem(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSPanelModel(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
        if (pSPanelItemLogic.isPSSysViewPanelIdDirty()) {
            if (pSPanelItemLogic.getPSSysViewPanelId() != null) {
                if (pSPanelItemLogic.getPSSysViewPanelId() == null || pSPanelItemLogic.getPSSysViewPanelName() == null) {
                    PSSysViewPanel pSSysViewPanel = pSPanelItemLogic.getPSSysViewPanel();
                    pSPanelItemLogic.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                }
            } else {
                pSPanelItemLogic.setPSSysViewPanelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSPanelItemLogic, bl);
    }

    public ArrayList<PSPanelItemLogic> selectByPPSPanelItemLogic(PSPanelItemLogicBase pSPanelItemLogicBase) throws Exception {
        return this.selectByPPSPanelItemLogic(pSPanelItemLogicBase, "", -1);
    }

    public ArrayList<PSPanelItemLogic> selectByPPSPanelItemLogic(PSPanelItemLogicBase pSPanelItemLogicBase, String string) throws Exception {
        return this.selectByPPSPanelItemLogic(pSPanelItemLogicBase, string, -1);
    }

    public ArrayList<PSPanelItemLogic> selectByPPSPanelItemLogic(PSPanelItemLogicBase pSPanelItemLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSPANELITEMLOGICID", (Object)pSPanelItemLogicBase.getPSPanelItemLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSPanelItemLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSPanelItemLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelItemLogic> selectTempByPPSPanelItemLogic(PSPanelItemLogicBase pSPanelItemLogicBase) throws Exception {
        return this.selectTempByPPSPanelItemLogic(pSPanelItemLogicBase, "");
    }

    public ArrayList<PSPanelItemLogic> selectTempByPPSPanelItemLogic(PSPanelItemLogicBase pSPanelItemLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSPANELITEMLOGICID", (Object)pSPanelItemLogicBase.getPSPanelItemLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSPanelItemLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSPanelItemLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelItemLogic> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByPSSysViewPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSPanelItemLogic> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByPSSysViewPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSPanelItemLogic> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelItemLogic> selectTempByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByPSSysViewPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSPanelItemLogic> selectTempByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelItemLogic> selectByDstPSPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase) throws Exception {
        return this.selectByDstPSPanelModel(pSSysViewPanelModelBase, "", -1);
    }

    public ArrayList<PSPanelItemLogic> selectByDstPSPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string) throws Exception {
        return this.selectByDstPSPanelModel(pSSysViewPanelModelBase, string, -1);
    }

    public ArrayList<PSPanelItemLogic> selectByDstPSPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSPANELMODELID", (Object)pSSysViewPanelModelBase.getPSSysViewPanelModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSPanelModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSPanelModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelItemLogic> selectTempByDstPSPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase) throws Exception {
        return this.selectTempByDstPSPanelModel(pSSysViewPanelModelBase, "");
    }

    public ArrayList<PSPanelItemLogic> selectTempByDstPSPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSPANELMODELID", (Object)pSSysViewPanelModelBase.getPSSysViewPanelModelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSPanelModelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSPanelModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelItemLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSPanelItemLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSPanelItemLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelItemLogic> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSPanelItemLogic> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
    }

    public void resetPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByPPSPanelItemLogic(pSPanelItemLogic);
        for (PSPanelItemLogic pSPanelItemLogic2 : arrayList) {
            PSPanelItemLogic pSPanelItemLogic3 = (PSPanelItemLogic)this.getDEModel().createEntity();
            pSPanelItemLogic3.setPSPanelItemLogicId(pSPanelItemLogic2.getPSPanelItemLogicId());
            pSPanelItemLogic3.setPPSPanelItemLogicId(null);
            this.update(pSPanelItemLogic3);
        }
    }

    public void resetTempPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectTempByPPSPanelItemLogic(pSPanelItemLogic);
        for (PSPanelItemLogic pSPanelItemLogic2 : arrayList) {
            PSPanelItemLogic pSPanelItemLogic3 = (PSPanelItemLogic)this.getDEModel().createEntity();
            pSPanelItemLogic3.setPSPanelItemLogicId(pSPanelItemLogic2.getPSPanelItemLogicId());
            pSPanelItemLogic3.setPPSPanelItemLogicId(null);
            this.updateTemp(pSPanelItemLogic3);
        }
    }

    public void removeByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        final PSPanelItemLogic pSPanelItemLogic2 = pSPanelItemLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicServiceBase.this.onBeforeRemoveByPPSPanelItemLogic(pSPanelItemLogic2);
                PSPanelItemLogicServiceBase.this.internalRemoveByPPSPanelItemLogic(pSPanelItemLogic2);
                PSPanelItemLogicServiceBase.this.onAfterRemoveByPPSPanelItemLogic(pSPanelItemLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
    }

    protected void internalRemoveByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByPPSPanelItemLogic(pSPanelItemLogic);
        this.onBeforeRemoveByPPSPanelItemLogic(pSPanelItemLogic, arrayList);
        for (PSPanelItemLogic pSPanelItemLogic2 : arrayList) {
            this.remove(pSPanelItemLogic2);
        }
        this.onAfterRemoveByPPSPanelItemLogic(pSPanelItemLogic, arrayList);
    }

    protected void onAfterRemoveByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
    }

    protected void onBeforeRemoveByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    public void resetPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            PSPanelItemLogic pSPanelItemLogic2 = (PSPanelItemLogic)this.getDEModel().createEntity();
            pSPanelItemLogic2.setPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
            pSPanelItemLogic2.setPSSysViewPanelItemId(null);
            this.update(pSPanelItemLogic2);
        }
    }

    public void resetTempPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            PSPanelItemLogic pSPanelItemLogic2 = (PSPanelItemLogic)this.getDEModel().createEntity();
            pSPanelItemLogic2.setPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
            pSPanelItemLogic2.setPSSysViewPanelItemId(null);
            this.updateTemp(pSPanelItemLogic2);
        }
    }

    public void removeByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicServiceBase.this.onBeforeRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSPanelItemLogicServiceBase.this.internalRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSPanelItemLogicServiceBase.this.onAfterRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            this.remove(pSPanelItemLogic);
        }
        this.onAfterRemoveByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    public void testRemoveByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByDstPSPanelModel(pSSysViewPanelModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanelModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELMODEL_DSTPSPANELMODELID", "", iDataEntityModel.getName(), "PSPANELITEMLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanelModel), arrayList.get(0)));
        }
    }

    public void resetDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByDstPSPanelModel(pSSysViewPanelModel);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            PSPanelItemLogic pSPanelItemLogic2 = (PSPanelItemLogic)this.getDEModel().createEntity();
            pSPanelItemLogic2.setPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
            pSPanelItemLogic2.setDstPSPanelModelId(null);
            this.update(pSPanelItemLogic2);
        }
    }

    public void resetTempDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectTempByDstPSPanelModel(pSSysViewPanelModel);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            PSPanelItemLogic pSPanelItemLogic2 = (PSPanelItemLogic)this.getDEModel().createEntity();
            pSPanelItemLogic2.setPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
            pSPanelItemLogic2.setDstPSPanelModelId(null);
            this.updateTemp(pSPanelItemLogic2);
        }
    }

    public void removeByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        final PSSysViewPanelModel pSSysViewPanelModel2 = pSSysViewPanelModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicServiceBase.this.onBeforeRemoveByDstPSPanelModel(pSSysViewPanelModel2);
                PSPanelItemLogicServiceBase.this.internalRemoveByDstPSPanelModel(pSSysViewPanelModel2);
                PSPanelItemLogicServiceBase.this.onAfterRemoveByDstPSPanelModel(pSSysViewPanelModel2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void internalRemoveByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByDstPSPanelModel(pSSysViewPanelModel);
        this.onBeforeRemoveByDstPSPanelModel(pSSysViewPanelModel, arrayList);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            this.remove(pSPanelItemLogic);
        }
        this.onAfterRemoveByDstPSPanelModel(pSSysViewPanelModel, arrayList);
    }

    protected void onAfterRemoveByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void onBeforeRemoveByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            PSPanelItemLogic pSPanelItemLogic2 = (PSPanelItemLogic)this.getDEModel().createEntity();
            pSPanelItemLogic2.setPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
            pSPanelItemLogic2.setPSSysViewPanelId(null);
            this.update(pSPanelItemLogic2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            PSPanelItemLogic pSPanelItemLogic2 = (PSPanelItemLogic)this.getDEModel().createEntity();
            pSPanelItemLogic2.setPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
            pSPanelItemLogic2.setPSSysViewPanelId(null);
            this.updateTemp(pSPanelItemLogic2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelItemLogicServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelItemLogicServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            this.remove(pSPanelItemLogic);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        pSPanelItemLogicService.testRemoveByPPSPanelItemLogic(pSPanelItemLogic);
        pSPanelItemLogicService.resetPPSPanelItemLogic(pSPanelItemLogic);
        super.onBeforeRemove(pSPanelItemLogic);
    }

    protected void onBeforeRemoveTemp(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        pSPanelItemLogicService.resetTempPPSPanelItemLogic(pSPanelItemLogic);
        super.onBeforeRemoveTemp(pSPanelItemLogic);
    }

    public void removeTempByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        final PSPanelItemLogic pSPanelItemLogic2 = pSPanelItemLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicServiceBase.this.onBeforeRemoveTempByPPSPanelItemLogic(pSPanelItemLogic2);
                PSPanelItemLogicServiceBase.this.internalRemoveTempByPPSPanelItemLogic(pSPanelItemLogic2);
                PSPanelItemLogicServiceBase.this.onAfterRemoveTempByPPSPanelItemLogic(pSPanelItemLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
    }

    protected void internalRemoveTempByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectTempByPPSPanelItemLogic(pSPanelItemLogic);
        this.onBeforeRemoveTempByPPSPanelItemLogic(pSPanelItemLogic, arrayList);
        for (PSPanelItemLogic pSPanelItemLogic2 : arrayList) {
            this.removeTemp(pSPanelItemLogic2);
        }
        this.onAfterRemoveTempByPPSPanelItemLogic(pSPanelItemLogic, arrayList);
    }

    protected void onAfterRemoveTempByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSPanelItemLogic(PSPanelItemLogic pSPanelItemLogic, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    public void removeTempByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        final PSSysViewPanelModel pSSysViewPanelModel2 = pSSysViewPanelModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicServiceBase.this.onBeforeRemoveTempByDstPSPanelModel(pSSysViewPanelModel2);
                PSPanelItemLogicServiceBase.this.internalRemoveTempByDstPSPanelModel(pSSysViewPanelModel2);
                PSPanelItemLogicServiceBase.this.onAfterRemoveTempByDstPSPanelModel(pSSysViewPanelModel2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void internalRemoveTempByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectTempByDstPSPanelModel(pSSysViewPanelModel);
        this.onBeforeRemoveTempByDstPSPanelModel(pSSysViewPanelModel, arrayList);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            this.removeTemp(pSPanelItemLogic);
        }
        this.onAfterRemoveTempByDstPSPanelModel(pSSysViewPanelModel, arrayList);
    }

    protected void onAfterRemoveTempByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicServiceBase.this.onBeforeRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSPanelItemLogicServiceBase.this.internalRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSPanelItemLogicServiceBase.this.onAfterRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            this.removeTemp(pSPanelItemLogic);
        }
        this.onAfterRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelItemLogicServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelItemLogicServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            this.removeTemp(pSPanelItemLogic);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        super.getRelatedDataTempMajor(pSPanelItemLogic);
    }

    protected void updateRelatedDataTempMajor(PSPanelItemLogic pSPanelItemLogic, PSPanelItemLogic pSPanelItemLogic2) throws Exception {
        super.updateRelatedDataTempMajor(pSPanelItemLogic, pSPanelItemLogic2);
    }

    protected void replaceParentInfo(PSPanelItemLogic pSPanelItemLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPanelItemLogic, cloneSession);
        if (pSPanelItemLogic.getPPSPanelItemLogicId() != null && (iEntity = cloneSession.getEntity("PSPANELITEMLOGIC", (Object)pSPanelItemLogic.getPPSPanelItemLogicId())) != null) {
            this.onFillParentInfo_PPSPanelItemLogic(pSPanelItemLogic, (PSPanelItemLogic)iEntity);
        }
        if (pSPanelItemLogic.getPSSysViewPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSPanelItemLogic.getPSSysViewPanelItemId())) != null) {
            this.onFillParentInfo_PSSysViewPanelItem(pSPanelItemLogic, (PSSysViewPanelItem)iEntity);
        }
        if (pSPanelItemLogic.getDstPSPanelModelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELMODEL", (Object)pSPanelItemLogic.getDstPSPanelModelId())) != null) {
            this.onFillParentInfo_DstPSPanelModel(pSPanelItemLogic, (PSSysViewPanelModel)iEntity);
        }
        if (pSPanelItemLogic.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSPanelItemLogic.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelItemLogic, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPanelItemLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondOp(bl, pSPanelItemLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondValue(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstFieldName(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSPanelModelId(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupNotFlag(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupOP(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicCat(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicType(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSPanelItemLogicId(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSPanelItemLogicName(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelItemLogicId(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelItemLogicName(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelItemId(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelName(bl, pSPanelItemLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPanelItemLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondOp(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isCondOpDirty() : !pSPanelItemLogic.isCondOpDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getCondOp();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondOp_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondValue(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isCondValueDirty() : !pSPanelItemLogic.isCondValueDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getCondValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValue_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isCustomCodeDirty() : !pSPanelItemLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSPanelItemLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstFieldName(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isDstFieldNameDirty() : !pSPanelItemLogic.isDstFieldNameDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getDstFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstFieldName_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSPanelModelId(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isDstPSPanelModelIdDirty() : !pSPanelItemLogic.isDstPSPanelModelIdDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getDstPSPanelModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSPanelModelId_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSPANELMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupNotFlag(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isGroupNotFlagDirty() : !pSPanelItemLogic.isGroupNotFlagDirty()) {
            return null;
        }
        Integer n = pSPanelItemLogic.getGroupNotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupNotFlag_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPNOTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupOP(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isGroupOPDirty() : !pSPanelItemLogic.isGroupOPDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getGroupOP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupOP_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicCat(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isLogicCatDirty() : !pSPanelItemLogic.isLogicCatDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getLogicCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicCat_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicType(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isLogicTypeDirty() : !pSPanelItemLogic.isLogicTypeDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getLogicType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicType_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isOrderValueDirty() : !pSPanelItemLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSPanelItemLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSPanelItemLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSPanelItemLogicId(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isPPSPanelItemLogicIdDirty() : !pSPanelItemLogic.isPPSPanelItemLogicIdDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getPPSPanelItemLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSPanelItemLogicId_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSPANELITEMLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSPanelItemLogicName(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isPPSPanelItemLogicNameDirty() : !pSPanelItemLogic.isPPSPanelItemLogicNameDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getPPSPanelItemLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSPanelItemLogicName_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSPANELITEMLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelItemLogicId(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isPSPanelItemLogicIdDirty() && !bl2 : !pSPanelItemLogic.isPSPanelItemLogicIdDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getPSPanelItemLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELITEMLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelItemLogicId_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELITEMLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelItemLogicName(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isPSPanelItemLogicNameDirty() : !pSPanelItemLogic.isPSPanelItemLogicNameDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getPSPanelItemLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelItemLogicName_Default(pSPanelItemLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELITEMLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isPSSysViewPanelIdDirty() : !pSPanelItemLogic.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSPanelItemLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelItemId(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isPSSysViewPanelItemIdDirty() && !bl2 : !pSPanelItemLogic.isPSSysViewPanelItemIdDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getPSSysViewPanelItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelItemId_Default(pSPanelItemLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelName(boolean bl, PSPanelItemLogic pSPanelItemLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelItemLogic.isPSSysViewPanelNameDirty() : !pSPanelItemLogic.isPSSysViewPanelNameDirty()) {
            return null;
        }
        String string = pSPanelItemLogic.getPSSysViewPanelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelName_Default(pSPanelItemLogic, bl2, bl3);
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

    protected void onSyncEntity(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSPanelItemLogic, bl);
    }

    protected void onSyncIndexEntities(PSPanelItemLogic pSPanelItemLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPanelItemLogic, bl);
    }

    public Object getDataContextValue(PSPanelItemLogic pSPanelItemLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPanelItemLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSPanelItemLogic pSPanelItemLogic2 = pSPanelItemLogic.getPPSPanelItemLogic();
        if (pSPanelItemLogic2 != null && pSPanelItemLogic2.contains(string)) {
            return pSPanelItemLogic2.get(string);
        }
        PSSysViewPanelItem pSSysViewPanelItem = pSPanelItemLogic.getPSSysViewPanelItem();
        if (pSSysViewPanelItem != null && pSSysViewPanelItem.contains(string)) {
            return pSSysViewPanelItem.get(string);
        }
        PSSysViewPanel pSSysViewPanel = pSPanelItemLogic.getPSSysViewPanel();
        if (pSSysViewPanel != null && pSSysViewPanel.contains(string)) {
            return pSSysViewPanel.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPanelItemLogic pSPanelItemLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPanelItemLogic, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondOp_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DSTFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSPANELMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSPanelModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSPANELMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSPanelModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPNOTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupNotFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupOP_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSPANELITEMLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSPanelItemLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSPANELITEMLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSPanelItemLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELITEMLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelItemLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELITEMLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelItemLogicName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CondOp_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDOP", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDVALUE", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_DstFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTFIELDNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSPanelModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSPANELMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSPanelModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSPANELMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupNotFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupOP_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPOP", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICCAT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSPanelItemLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSPANELITEMLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSPanelItemLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSPANELITEMLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelItemLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELITEMLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelItemLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELITEMLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPanelItemLogic pSPanelItemLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPanelItemLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        super.onUpdateParent(pSPanelItemLogic);
    }

    @Override
    protected void exportCurXmlModel(PSPanelItemLogic pSPanelItemLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPANELITEMLOGIC");
        if (!bl) {
            pSPanelItemLogic.setCreateDate(null);
            pSPanelItemLogic.setCreateMan(null);
            pSPanelItemLogic.setPSPanelItemLogicId(null);
            pSPanelItemLogic.setUpdateDate(null);
            pSPanelItemLogic.setUpdateMan(null);
            pSPanelItemLogic.setPPSPanelItemLogicId(null);
            pSPanelItemLogic.setDstPSPanelModelId(null);
            pSPanelItemLogic.setPSSysViewPanelItemId(null);
            pSPanelItemLogic.setPSSysViewPanelItemName(null);
            pSPanelItemLogic.setPSSysViewPanelId(null);
            pSPanelItemLogic.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSPanelItemLogic, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSPanelItemLogic pSPanelItemLogic, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSPanelItemLogic, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSPanelItemLogic pSPanelItemLogic, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSPanelItemLogic, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSPanelItemLogic pSPanelItemLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSPanelItemLogic, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSPANELITEMLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSPANELITEMLOGIC#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSVIEWPANELITEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSPANELITEMLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSPANELITEMLOGIC_PSPANELITEMLOGIC_PPSPANELITEMLOGICID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSPANELITEMLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSPANELITEMLOGICNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELITEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSPANELITEMLOGIC", (boolean)true) == 0) {
            iEntity.set("PPSPANELITEMLOGICID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEM", (boolean)true) == 0) {
            iEntity.set("PSSYSVIEWPANELITEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSPANELITEMLOGICID", "PSSYSVIEWPANELITEMID"};
    }

    @Override
    public String getModelV2Tag(PSPanelItemLogic pSPanelItemLogic) {
        return super.getModelV2Tag(pSPanelItemLogic);
    }

    @Override
    public boolean setModelV2Tag(PSPanelItemLogic pSPanelItemLogic, String string) {
        return super.setModelV2Tag(pSPanelItemLogic, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSPANELITEMLOGICID", "");
        map.put("PSSYSVIEWPANELITEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSPanelItemLogic pSPanelItemLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSPanelItemLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSPanelItemLogic, true);
        return super.getModelV2Entity(pSPanelItemLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSPanelItemLogic pSPanelItemLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getPPSPanelItemLogicId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getPSSysViewPanelItemId())) {
            bl = true;
        } else if (bl && !objectNode.has("pssysviewpanelitemid")) {
            objectNode.put("pssysviewpanelitemid", "<PSSYSVIEWPANELITEM>");
        }
        return super.testCompileCurModelV2(pSPanelItemLogic, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSPanelItemLogic pSPanelItemLogic, String string, Map<String, String> map) throws Exception {
        if (PSPanelItemLogicServiceBase.isSimpleImportExportMode()) {
            map.put("PPSPANELITEMLOGICID", "");
            map.put("PSSYSVIEWPANELITEMID", "");
        }
        return super.onFillModelV2(objectNode, pSPanelItemLogic, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSPANELITEMLOGIC_PSPANELITEMLOGIC_PPSPANELITEMLOGICID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSPanelItemLogic pSPanelItemLogic, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSPanelItemLogic, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSPanelItemLogic pSPanelItemLogic, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELITEMLOGIC_PSPANELITEMLOGIC_PPSPANELITEMLOGICID")) {
            PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSPANELITEMLOGIC#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELITEMLOGIC", (Object)pSPanelItemLogic.getPSPanelItemLogicId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSPANELITEMLOGIC#%1$s", (Object)pSPanelItemLogic.getPSPanelItemLogicId());
                for (PSPanelItemLogic item : pSPanelItemLogicService.selectByPPSPanelItemLogic(pSPanelItemLogic)) {
                    if (StringHelper.compare((String)scope, (String)pSPanelItemLogicService.getModelV2ResScope(item), (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSPanelItemLogicService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pspanelitemlogicname")) {
                            string = objectNode.get("pspanelitemlogicname").asText();
                        }
                        if (objectNode2.has("pspanelitemlogicname")) {
                            string2 = objectNode2.get("pspanelitemlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode itemNode : arrayList) {
                    PSPanelItemLogic item = new PSPanelItemLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, itemNode, false);
                    item.remove("ordervalue");
                    related.add((JsonNode)pSPanelItemLogicService.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSPanelItemLogic, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelItemLogic> arrayList = pSPanelItemLogicService.selectByPPSPanelItemLogic(pSPanelItemLogic);
        String string = StringHelper.format((String)"PSPANELITEMLOGIC#%1$s", (Object)pSPanelItemLogic.getPSPanelItemLogicId());
        for (PSPanelItemLogic pSPanelItemLogic2 : arrayList) {
            String string2 = pSPanelItemLogicService.getModelV2ResScope(pSPanelItemLogic2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSPanelItemLogicService.emptyModelV2(pSPanelItemLogic2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSPanelItemLogic.getPSPanelItemLogicId());
        pSPanelItemLogicService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSPanelItemLogicService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELITEMLOGIC WHERE PPSPANELITEMLOGICID = ?", sqlParamList);
        super.onEmptyModelV2(pSPanelItemLogic);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSPanelItemLogicService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSPanelItemLogic pSPanelItemLogic, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSPanelItemLogic pSPanelItemLogic2 = new PSPanelItemLogic();
        pSPanelItemLogic2.set("PPSPANELITEMLOGICID", pSPanelItemLogic.getPSPanelItemLogicId());
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSPanelItemLogicService.getModelV2Entity(pSPanelItemLogic2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSPanelItemLogic, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSPanelItemLogic pSPanelItemLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSPanelItemLogicService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSPanelItemLogic pSPanelItemLogic2 = new PSPanelItemLogic();
                pSPanelItemLogic2.setPPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
                pSPanelItemLogic2.setPPSPanelItemLogicName(pSPanelItemLogic.getPSPanelItemLogicName());
                pSPanelItemLogic2.setOrderValue(n2 += 10);
                pSPanelItemLogicService.compileModelV2(pSPanelItemLogic2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSPanelItemLogic pSPanelItemLogic3 = new PSPanelItemLogic();
                    pSPanelItemLogic3.setPPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
                    pSPanelItemLogic3.setPPSPanelItemLogicName(pSPanelItemLogic.getPSPanelItemLogicName());
                    pSPanelItemLogicService.compileModelV2(pSPanelItemLogic3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSPanelItemLogic, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSPanelItemLogic pSPanelItemLogic, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSPanelItemLogic, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSPanelItemLogic pSPanelItemLogic, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSPanelItemLogic, list);
    }

    @Override
    public Object getDataType(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        return pSPanelItemLogic.getLogicType();
    }
}

