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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLogicNodeDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLogicNodeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLNParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParamBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogicBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLogicNodeServiceBase
extends PSCoreSysServiceBase<PSPanelLogicNode> {
    private static final Log log = LogFactory.getLog(PSPanelLogicNodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_TYPE = "Type";
    private PSPanelLogicNodeDEModel pSPanelLogicNodeDEModel;
    private PSPanelLogicNodeDAO pSPanelLogicNodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService";
    }

    public PSPanelLogicNodeDEModel getPSPanelLogicNodeDEModel() {
        if (this.pSPanelLogicNodeDEModel == null) {
            try {
                this.pSPanelLogicNodeDEModel = (PSPanelLogicNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLogicNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLogicNodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPanelLogicNodeDEModel();
    }

    public PSPanelLogicNodeDAO getPSPanelLogicNodeDAO() {
        if (this.pSPanelLogicNodeDAO == null) {
            try {
                this.pSPanelLogicNodeDAO = (PSPanelLogicNodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLogicNodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLogicNodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPanelLogicNodeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_TYPE, (boolean)true) == 0) {
            return this.fetchType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_TYPE, (boolean)true) == 0) {
            return this.fetchTempType(iDEDataSetFetchContext);
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

    public DBFetchResult fetchType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_TYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_TYPE, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSPanelLogicNode pSPanelLogicNode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICNODE_PSPANELLOGICPARAM_PSPANELLOGICPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService", (SessionFactory)this.getSessionFactory());
            PSPanelLogicParam pSPanelLogicParam = (PSPanelLogicParam)iService.getDEModel().createEntity();
            pSPanelLogicParam.set("PSPANELLOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPanelLogicParam);
            } else {
                iService.get((IEntity)pSPanelLogicParam);
            }
            this.onFillParentInfo_PSPanelLogicParam(pSPanelLogicNode, pSPanelLogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelItem);
            } else {
                iService.get((IEntity)pSSysViewPanelItem);
            }
            this.onFillParentInfo_PSSysViewPanelItem(pSPanelLogicNode, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)iService.getDEModel().createEntity();
            pSSysViewPanelLogic.set("PSSYSVIEWPANELLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelLogic);
            } else {
                iService.get((IEntity)pSSysViewPanelLogic);
            }
            this.onFillParentInfo_PSSysViewPanelLogic(pSPanelLogicNode, pSSysViewPanelLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICNODE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicNode, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo((IEntity)pSPanelLogicNode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPanelLogicParam(PSPanelLogicNode pSPanelLogicNode, PSPanelLogicParam pSPanelLogicParam) throws Exception {
        pSPanelLogicNode.setPSPanelLogicParamId(pSPanelLogicParam.getPSPanelLogicParamId());
        pSPanelLogicNode.setPSPanelLogicParamName(pSPanelLogicParam.getPSPanelLogicParamName());
    }

    protected void onFillParentInfo_PSSysViewPanelItem(PSPanelLogicNode pSPanelLogicNode, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSPanelLogicNode.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSPanelLogicNode.setPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
    }

    protected void onFillParentInfo_PSSysViewPanelLogic(PSPanelLogicNode pSPanelLogicNode, PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSPanelLogicNode.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSPanelLogicNode.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
        if (pSSysViewPanelLogic.getPSSysViewPanel() != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicNode, pSSysViewPanelLogic.getPSSysViewPanel());
        }
    }

    protected void onFillParentInfo_PSSysViewPanel(PSPanelLogicNode pSPanelLogicNode, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSPanelLogicNode.setPSSystemId(pSSysViewPanel.getPSSystemId());
        pSPanelLogicNode.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSPanelLogicNode.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSPanelLogicNode, bl);
        this.onFillEntityFullInfo_PSPanelLogicParam(pSPanelLogicNode, bl);
        this.onFillEntityFullInfo_PSSysViewPanelItem(pSPanelLogicNode, bl);
        this.onFillEntityFullInfo_PSSysViewPanelLogic(pSPanelLogicNode, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLogicNode, bl);
    }

    protected void onFillEntityFullInfo_PSPanelLogicParam(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanelItem(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanelLogic(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
        if (pSPanelLogicNode.isPSSysViewPanelLogicIdDirty()) {
            if (pSPanelLogicNode.getPSSysViewPanelLogicId() != null) {
                PSSysViewPanelLogic pSSysViewPanelLogic;
                if (pSPanelLogicNode.getPSSysViewPanelLogicId() == null || pSPanelLogicNode.getPSSysViewPanelLogicName() == null) {
                    pSSysViewPanelLogic = pSPanelLogicNode.getPSSysViewPanelLogic();
                    pSPanelLogicNode.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSSysViewPanelLogic = pSPanelLogicNode.getPSSysViewPanelLogic()).getPSSysViewPanelId(), (Object)pSPanelLogicNode.getPSSysViewPanelId()) != 0L) {
                    pSPanelLogicNode.setPSSysViewPanelId(pSSysViewPanelLogic.getPSSysViewPanelId());
                    this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLogicNode, bl);
                }
            } else {
                pSPanelLogicNode.setPSSysViewPanelLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPanelLogicNode, bl);
    }

    public ArrayList<PSPanelLogicNode> selectByPSPanelLogicParam(PSPanelLogicParamBase pSPanelLogicParamBase) throws Exception {
        return this.selectByPSPanelLogicParam(pSPanelLogicParamBase, "", -1);
    }

    public ArrayList<PSPanelLogicNode> selectByPSPanelLogicParam(PSPanelLogicParamBase pSPanelLogicParamBase, String string) throws Exception {
        return this.selectByPSPanelLogicParam(pSPanelLogicParamBase, string, -1);
    }

    public ArrayList<PSPanelLogicNode> selectByPSPanelLogicParam(PSPanelLogicParamBase pSPanelLogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELLOGICPARAMID", (Object)pSPanelLogicParamBase.getPSPanelLogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPanelLogicParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPanelLogicParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicNode> selectTempByPSPanelLogicParam(PSPanelLogicParamBase pSPanelLogicParamBase) throws Exception {
        return this.selectTempByPSPanelLogicParam(pSPanelLogicParamBase, "");
    }

    public ArrayList<PSPanelLogicNode> selectTempByPSPanelLogicParam(PSPanelLogicParamBase pSPanelLogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELLOGICPARAMID", (Object)pSPanelLogicParamBase.getPSPanelLogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSPanelLogicParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSPanelLogicParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByPSSysViewPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByPSSysViewPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLogicNode> selectTempByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByPSSysViewPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSPanelLogicNode> selectTempByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectByPSSysViewPanelLogic(pSSysViewPanelLogicBase, "", -1);
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        return this.selectByPSSysViewPanelLogic(pSSysViewPanelLogicBase, string, -1);
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLogicNode> selectTempByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogicBase, "");
    }

    public ArrayList<PSPanelLogicNode> selectTempByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSPanelLogicNode> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLogicNode> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSPanelLogicNode> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSPanelLogicParam(pSPanelLogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPANELLOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPanelLogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELLOGICNODE_PSPANELLOGICPARAM_PSPANELLOGICPARAMID", "", iDataEntityModel.getName(), "PSPANELLOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSPanelLogicParam), arrayList.get(0)));
        }
    }

    public void resetPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSPanelLogicParam(pSPanelLogicParam);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            PSPanelLogicNode pSPanelLogicNode2 = (PSPanelLogicNode)this.getDEModel().createEntity();
            pSPanelLogicNode2.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            pSPanelLogicNode2.setPSPanelLogicParamId(null);
            this.update(pSPanelLogicNode2);
        }
    }

    public void resetTempPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectTempByPSPanelLogicParam(pSPanelLogicParam);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            PSPanelLogicNode pSPanelLogicNode2 = (PSPanelLogicNode)this.getDEModel().createEntity();
            pSPanelLogicNode2.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            pSPanelLogicNode2.setPSPanelLogicParamId(null);
            this.updateTemp((IEntity)pSPanelLogicNode2);
        }
    }

    public void removeByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        final PSPanelLogicParam pSPanelLogicParam2 = pSPanelLogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicNodeServiceBase.this.onBeforeRemoveByPSPanelLogicParam(pSPanelLogicParam2);
                PSPanelLogicNodeServiceBase.this.internalRemoveByPSPanelLogicParam(pSPanelLogicParam2);
                PSPanelLogicNodeServiceBase.this.onAfterRemoveByPSPanelLogicParam(pSPanelLogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void internalRemoveByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSPanelLogicParam(pSPanelLogicParam);
        this.onBeforeRemoveByPSPanelLogicParam(pSPanelLogicParam, arrayList);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            this.remove((IEntity)pSPanelLogicNode);
        }
        this.onAfterRemoveByPSPanelLogicParam(pSPanelLogicParam, arrayList);
    }

    protected void onAfterRemoveByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void onBeforeRemoveByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanelItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", "", iDataEntityModel.getName(), "PSPANELLOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanelItem), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            PSPanelLogicNode pSPanelLogicNode2 = (PSPanelLogicNode)this.getDEModel().createEntity();
            pSPanelLogicNode2.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            pSPanelLogicNode2.setPSSysViewPanelItemId(null);
            this.update(pSPanelLogicNode2);
        }
    }

    public void resetTempPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            PSPanelLogicNode pSPanelLogicNode2 = (PSPanelLogicNode)this.getDEModel().createEntity();
            pSPanelLogicNode2.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            pSPanelLogicNode2.setPSSysViewPanelItemId(null);
            this.updateTemp((IEntity)pSPanelLogicNode2);
        }
    }

    public void removeByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicNodeServiceBase.this.onBeforeRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSPanelLogicNodeServiceBase.this.internalRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSPanelLogicNodeServiceBase.this.onAfterRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            this.remove((IEntity)pSPanelLogicNode);
        }
        this.onAfterRemoveByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    public void resetPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            PSPanelLogicNode pSPanelLogicNode2 = (PSPanelLogicNode)this.getDEModel().createEntity();
            pSPanelLogicNode2.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            pSPanelLogicNode2.setPSSysViewPanelLogicId(null);
            this.update(pSPanelLogicNode2);
        }
    }

    public void resetTempPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            PSPanelLogicNode pSPanelLogicNode2 = (PSPanelLogicNode)this.getDEModel().createEntity();
            pSPanelLogicNode2.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            pSPanelLogicNode2.setPSSysViewPanelLogicId(null);
            this.updateTemp((IEntity)pSPanelLogicNode2);
        }
    }

    public void removeByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicNodeServiceBase.this.onBeforeRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicNodeServiceBase.this.internalRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicNodeServiceBase.this.onAfterRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            this.remove((IEntity)pSPanelLogicNode);
        }
        this.onAfterRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            PSPanelLogicNode pSPanelLogicNode2 = (PSPanelLogicNode)this.getDEModel().createEntity();
            pSPanelLogicNode2.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            pSPanelLogicNode2.setPSSysViewPanelId(null);
            this.update(pSPanelLogicNode2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            PSPanelLogicNode pSPanelLogicNode2 = (PSPanelLogicNode)this.getDEModel().createEntity();
            pSPanelLogicNode2.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            pSPanelLogicNode2.setPSSysViewPanelId(null);
            this.updateTemp((IEntity)pSPanelLogicNode2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicNodeServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicNodeServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicNodeServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            this.remove((IEntity)pSPanelLogicNode);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).testRemoveByPSPanelLogicNode(pSPanelLogicNode);
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).removeByPSPanelLogicNode(pSPanelLogicNode);
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).testRemoveByDstPSPanelLogicNode(pSPanelLogicNode);
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).removeByDstPSPanelLogicNode(pSPanelLogicNode);
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSPanelLogicNode(pSPanelLogicNode);
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).removeBySrcPSPanelLogicNode(pSPanelLogicNode);
        super.onBeforeRemove(pSPanelLogicNode);
    }

    protected void onBeforeRemoveTemp(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).removeTempByPSPanelLogicNode(pSPanelLogicNode);
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).resetTempSrcPSPanelLogicNode(pSPanelLogicNode);
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).resetTempDstPSPanelLogicNode(pSPanelLogicNode);
        super.onBeforeRemoveTemp((IEntity)pSPanelLogicNode);
    }

    public void removeTempByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        final PSPanelLogicParam pSPanelLogicParam2 = pSPanelLogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicNodeServiceBase.this.onBeforeRemoveTempByPSPanelLogicParam(pSPanelLogicParam2);
                PSPanelLogicNodeServiceBase.this.internalRemoveTempByPSPanelLogicParam(pSPanelLogicParam2);
                PSPanelLogicNodeServiceBase.this.onAfterRemoveTempByPSPanelLogicParam(pSPanelLogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void internalRemoveTempByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectTempByPSPanelLogicParam(pSPanelLogicParam);
        this.onBeforeRemoveTempByPSPanelLogicParam(pSPanelLogicParam, arrayList);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            this.removeTemp((IEntity)pSPanelLogicNode);
        }
        this.onAfterRemoveTempByPSPanelLogicParam(pSPanelLogicParam, arrayList);
    }

    protected void onAfterRemoveTempByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSPanelLogicParam(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicNodeServiceBase.this.onBeforeRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSPanelLogicNodeServiceBase.this.internalRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSPanelLogicNodeServiceBase.this.onAfterRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            this.removeTemp((IEntity)pSPanelLogicNode);
        }
        this.onAfterRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicNodeServiceBase.this.onBeforeRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicNodeServiceBase.this.internalRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicNodeServiceBase.this.onAfterRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            this.removeTemp((IEntity)pSPanelLogicNode);
        }
        this.onAfterRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicNodeServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicNodeServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicNodeServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicNode> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            this.removeTemp((IEntity)pSPanelLogicNode);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        this.getRelatedDataTempMajor_PSPanelLNParam(pSPanelLogicNode);
        super.getRelatedDataTempMajor((IEntity)pSPanelLogicNode);
    }

    protected void getRelatedDataTempMajor_PSPanelLNParam(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLNParam> arrayList = null;
        String string = pSPanelLogicNode.getPSPanelLogicNodeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLNParamService.selectByPSPanelLogicNode(pSPanelLogicNode) : pSPanelLNParamService.selectTempByPSPanelLogicNode(pSPanelLogicNode);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            pSPanelLNParamService.getTempMajor(pSPanelLNParam);
        }
    }

    protected void updateRelatedDataTempMajor(PSPanelLogicNode pSPanelLogicNode, PSPanelLogicNode pSPanelLogicNode2) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.updateRelatedDataTempMajor_removePSPanelLNParam(pSPanelLogicNode, pSPanelLogicNode2);
        this.updateRelatedDataTempMajor_updatePSPanelLNParam(pSPanelLogicNode, pSPanelLogicNode2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSPanelLogicNode, (IEntity)pSPanelLogicNode2);
    }

    protected ArrayList<PSPanelLNParam> updateRelatedDataTempMajor_removePSPanelLNParam(PSPanelLogicNode pSPanelLogicNode, PSPanelLogicNode pSPanelLogicNode2) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLNParam> arrayList = pSPanelLNParamService.selectTempByPSPanelLogicNode(pSPanelLogicNode);
        ArrayList<PSPanelLNParam> arrayList2 = pSPanelLNParamService.selectByPSPanelLogicNode(pSPanelLogicNode2);
        HashMap<String, PSPanelLNParam> hashMap = new HashMap<String, PSPanelLNParam>();
        for (PSPanelLNParam pSPanelLNParam : arrayList2) {
            hashMap.put(pSPanelLNParam.getPSPanelLNParamId(), pSPanelLNParam);
        }
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            Object object = pSPanelLNParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLNParam pSPanelLNParam : hashMap.values()) {
            pSPanelLNParamService.remove((IEntity)pSPanelLNParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLNParam(PSPanelLogicNode pSPanelLogicNode, PSPanelLogicNode pSPanelLogicNode2, ArrayList<PSPanelLNParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            pSPanelLNParamService.updateTempMajor(pSPanelLNParam);
        }
    }

    protected void replaceParentInfo(PSPanelLogicNode pSPanelLogicNode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPanelLogicNode, cloneSession);
        if (pSPanelLogicNode.getPSPanelLogicParamId() != null && (iEntity = cloneSession.getEntity("PSPANELLOGICPARAM", (Object)pSPanelLogicNode.getPSPanelLogicParamId())) != null) {
            this.onFillParentInfo_PSPanelLogicParam(pSPanelLogicNode, (PSPanelLogicParam)iEntity);
        }
        if (pSPanelLogicNode.getPSSysViewPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSPanelLogicNode.getPSSysViewPanelItemId())) != null) {
            this.onFillParentInfo_PSSysViewPanelItem(pSPanelLogicNode, (PSSysViewPanelItem)iEntity);
        }
        if (pSPanelLogicNode.getPSSysViewPanelLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELLOGIC", (Object)pSPanelLogicNode.getPSSysViewPanelLogicId())) != null) {
            this.onFillParentInfo_PSSysViewPanelLogic(pSPanelLogicNode, (PSSysViewPanelLogic)iEntity);
        }
        if (pSPanelLogicNode.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSPanelLogicNode.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicNode, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPanelLogicNode, bl);
    }

    protected void onCheckEntity(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSPanelLogicNode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPos(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicNodeType(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParallelOutput(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param1(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param10(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param11(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param12(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param13(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param14(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param5(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param6(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param7(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param8(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param9(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicNodeId(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicNodeName(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicParamId(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelItemId(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelLogicId(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelLogicName(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSPanelLogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPanelLogicNode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isCodeNameDirty() : !pSPanelLogicNode.isCodeNameDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isLeftPosDirty() : !pSPanelLogicNode.isLeftPosDirty()) {
            return null;
        }
        Integer n = pSPanelLogicNode.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LeftPos_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEFTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicNodeType(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isLogicNodeTypeDirty() && !bl2 : !pSPanelLogicNode.isLogicNodeTypeDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getLogicNodeType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNODETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicNodeType_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNODETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isMemoDirty() : !pSPanelLogicNode.isMemoDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPanelLogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParallelOutput(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParallelOutputDirty() : !pSPanelLogicNode.isParallelOutputDirty()) {
            return null;
        }
        Integer n = pSPanelLogicNode.getParallelOutput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ParallelOutput_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARALLELOUTPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param1(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam1Dirty() : !pSPanelLogicNode.isParam1Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam1();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param1_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM1");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param10(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam10Dirty() : !pSPanelLogicNode.isParam10Dirty()) {
            return null;
        }
        Integer n = pSPanelLogicNode.getParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param10_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param11(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam11Dirty() : !pSPanelLogicNode.isParam11Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param11_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param12(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam12Dirty() : !pSPanelLogicNode.isParam12Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param12_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param13(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam13Dirty() : !pSPanelLogicNode.isParam13Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam13();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param13_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM13");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param14(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam14Dirty() : !pSPanelLogicNode.isParam14Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam14();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param14_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM14");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param2(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam2Dirty() : !pSPanelLogicNode.isParam2Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param3(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam3Dirty() : !pSPanelLogicNode.isParam3Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param3_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param4(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam4Dirty() : !pSPanelLogicNode.isParam4Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param4_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param5(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam5Dirty() : !pSPanelLogicNode.isParam5Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param5_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param6(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam6Dirty() : !pSPanelLogicNode.isParam6Dirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param6_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param7(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam7Dirty() : !pSPanelLogicNode.isParam7Dirty()) {
            return null;
        }
        Integer n = pSPanelLogicNode.getParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param7_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param8(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam8Dirty() : !pSPanelLogicNode.isParam8Dirty()) {
            return null;
        }
        Integer n = pSPanelLogicNode.getParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param8_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param9(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isParam9Dirty() : !pSPanelLogicNode.isParam9Dirty()) {
            return null;
        }
        Integer n = pSPanelLogicNode.getParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param9_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicNodeId(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isPSPanelLogicNodeIdDirty() && !bl2 : !pSPanelLogicNode.isPSPanelLogicNodeIdDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getPSPanelLogicNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicNodeId_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicNodeName(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isPSPanelLogicNodeNameDirty() && !bl2 : !pSPanelLogicNode.isPSPanelLogicNodeNameDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getPSPanelLogicNodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICNODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicNodeName_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicParamId(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isPSPanelLogicParamIdDirty() : !pSPanelLogicNode.isPSPanelLogicParamIdDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getPSPanelLogicParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicParamId_Default((IEntity)pSPanelLogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isPSSysViewPanelIdDirty() && !bl2 : !pSPanelLogicNode.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getPSSysViewPanelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSPanelLogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelItemId(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isPSSysViewPanelItemIdDirty() : !pSPanelLogicNode.isPSSysViewPanelItemIdDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getPSSysViewPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelItemId_Default((IEntity)pSPanelLogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelLogicId(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isPSSysViewPanelLogicIdDirty() && !bl2 : !pSPanelLogicNode.isPSSysViewPanelLogicIdDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getPSSysViewPanelLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelLogicId_Default((IEntity)pSPanelLogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelLogicName(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isPSSysViewPanelLogicNameDirty() : !pSPanelLogicNode.isPSSysViewPanelLogicNameDirty()) {
            return null;
        }
        String string = pSPanelLogicNode.getPSSysViewPanelLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelLogicName_Default((IEntity)pSPanelLogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSPanelLogicNode pSPanelLogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicNode.isTopPosDirty() : !pSPanelLogicNode.isTopPosDirty()) {
            return null;
        }
        Integer n = pSPanelLogicNode.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TopPos_Default((IEntity)pSPanelLogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPanelLogicNode, bl);
    }

    protected void onSyncIndexEntities(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPanelLogicNode, bl);
    }

    public Object getDataContextValue(PSPanelLogicNode pSPanelLogicNode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPanelLogicNode, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysViewPanelLogic pSSysViewPanelLogic = pSPanelLogicNode.getPSSysViewPanelLogic();
        if (pSSysViewPanelLogic != null && pSSysViewPanelLogic.contains(string)) {
            return pSSysViewPanelLogic.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPanelLogicNode pSPanelLogicNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPanelLogicNode, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"LEFTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNODETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicNodeType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARALLELOUTPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParallelOutput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM1", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param1_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM13", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param13_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM14", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param14_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicNodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_LeftPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicNodeType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNODETYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_ParallelOutput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param1_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM1", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM11", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM12", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param13_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM13", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param14_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM14", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM4", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM5", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM6", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSPanelLogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_TopPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSPanelLogicNode pSPanelLogicNode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPanelLogicNode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        super.onUpdateParent((IEntity)pSPanelLogicNode);
    }

    @Override
    protected void exportCurXmlModel(PSPanelLogicNode pSPanelLogicNode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPANELLOGICNODE");
        if (!bl) {
            pSPanelLogicNode.setCreateDate(null);
            pSPanelLogicNode.setCreateMan(null);
            pSPanelLogicNode.setPSPanelLogicNodeId(null);
            pSPanelLogicNode.setUpdateDate(null);
            pSPanelLogicNode.setUpdateMan(null);
            pSPanelLogicNode.setPSPanelLogicParamId(null);
            pSPanelLogicNode.setPSSysViewPanelItemId(null);
            pSPanelLogicNode.setPSSysViewPanelLogicId(null);
            pSPanelLogicNode.setPSSysViewPanelLogicName(null);
            pSPanelLogicNode.setPSSystemId(null);
            pSPanelLogicNode.setPSSysViewPanelId(null);
            pSPanelLogicNode.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSPanelLogicNode, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSPanelLogicNode pSPanelLogicNode, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSPanelLNParam(pSPanelLogicNode, xmlNode);
        super.onExportRelatedXmlModel(pSPanelLogicNode, xmlNode);
    }

    protected void exportRelatedXmlModel_PSPanelLNParam(PSPanelLogicNode pSPanelLogicNode, XmlNode xmlNode) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLNParam> arrayList = null;
        String string = pSPanelLogicNode.getPSPanelLogicNodeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLNParamService.selectByPSPanelLogicNode(pSPanelLogicNode, "ORDER BY ORDERVALUE ASC") : pSPanelLNParamService.selectTempByPSPanelLogicNode(pSPanelLogicNode, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLNPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLNParam pSPanelLNParam : arrayList) {
                pSPanelLNParam.set("ORDERVALUE", null);
                pSPanelLNParamService.exportXmlModel(pSPanelLNParam, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSPanelLogicNode pSPanelLogicNode, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSPANELLNPARAMS");
        this.importRelatedXmlModel_PSPanelLNParam(pSPanelLogicNode, xmlNode2);
        super.onImportRelatedXmlModel(pSPanelLogicNode, xmlNode);
    }

    protected void importRelatedXmlModel_PSPanelLNParam(PSPanelLogicNode pSPanelLogicNode, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSPanelLogicNode.getPSPanelLogicNodeId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLNParamService.removeByPSPanelLogicNode(pSPanelLogicNode);
        } else {
            pSPanelLNParamService.removeTempByPSPanelLogicNode(pSPanelLogicNode);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLNParam pSPanelLNParam = new PSPanelLNParam();
                pSPanelLNParam.setOrderValue(n);
                n += 100;
                pSPanelLNParamService.fillParentInfo((IEntity)pSPanelLNParam, "DER1N", "DER1N_PSPANELLNPARAM_PSPANELLOGICNODE_PSPANELLOGICNODEID", pSPanelLogicNode.getPSPanelLogicNodeId());
                pSPanelLNParamService.importXmlModel(pSPanelLNParam, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSPanelLogicNode pSPanelLogicNode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSPanelLogicNode, string);
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
            return "DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID";
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
    public String getModelV2Tag(PSPanelLogicNode pSPanelLogicNode) {
        return super.getModelV2Tag(pSPanelLogicNode);
    }

    @Override
    public boolean setModelV2Tag(PSPanelLogicNode pSPanelLogicNode, String string) {
        return super.setModelV2Tag(pSPanelLogicNode, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSVIEWPANELLOGICID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSPanelLogicNode pSPanelLogicNode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSPanelLogicNode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSPanelLogicNode, true);
        return super.getModelV2Entity(pSPanelLogicNode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSPanelLogicNode pSPanelLogicNode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSPanelLogicNode, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSPANELLNPARAM_PSPANELLOGICNODE_PSPANELLOGICNODEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSPanelLogicNode pSPanelLogicNode, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSPanelLogicNode, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSPanelLogicNode pSPanelLogicNode, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELLNPARAM_PSPANELLOGICNODE_PSPANELLOGICNODEID")) {
            Object object;
            PSPanelLNParam pSPanelLNParam2;
            Object object2;
            Object object3;
            Object object4;
            PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSPanelLNParam> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSPANELLOGICNODE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELLNPARAM", (Object)pSPanelLogicNode.getPSPanelLogicNodeId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSPanelLNParam2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSPanelLNParam2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSPanelLNParam>();
                object4 = pSPanelLNParamService.selectByPSPanelLogicNode(pSPanelLogicNode);
                object3 = StringHelper.format((String)"PSPANELLOGICNODE#%1$s", (Object)pSPanelLogicNode.getPSPanelLogicNodeId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSPanelLNParam2 = object2.next();
                    object = pSPanelLNParamService.getModelV2ResScope((IEntity)pSPanelLNParam2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSPanelLNParam)PSModelV2Helper.toJSONObject((IEntity)pSPanelLNParam2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSPanelLNParamService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("pspanellnparamname")) {
                            string = objectNode.get("pspanellnparamname").asText();
                        }
                        if (objectNode2.has("pspanellnparamname")) {
                            string2 = objectNode2.get("pspanellnparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSPanelLNParam pSPanelLNParam2 : arrayList) {
                    object = new PSPanelLNParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSPanelLNParam2, false);
                    object3.add((JsonNode)pSPanelLNParamService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSPanelLogicNode, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLNParam> arrayList = pSPanelLNParamService.selectByPSPanelLogicNode(pSPanelLogicNode);
        String string = StringHelper.format((String)"PSPANELLOGICNODE#%1$s", (Object)pSPanelLogicNode.getPSPanelLogicNodeId());
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            String string2 = pSPanelLNParamService.getModelV2ResScope((IEntity)pSPanelLNParam);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSPanelLNParamService.emptyModelV2(pSPanelLNParam);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSPanelLogicNode.getPSPanelLogicNodeId());
        pSPanelLNParamService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSPanelLNParamService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELLNPARAM WHERE PSPANELLOGICNODEID = ?", sqlParamList);
        super.onEmptyModelV2(pSPanelLogicNode);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSPanelLNParamService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSPanelLogicNode pSPanelLogicNode, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSPanelLNParam pSPanelLNParam = new PSPanelLNParam();
        pSPanelLNParam.set("PSPANELLOGICNODEID", pSPanelLogicNode.getPSPanelLogicNodeId());
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSPanelLNParamService.getModelV2Entity(pSPanelLNParam, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSPanelLogicNode, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSPanelLogicNode pSPanelLogicNode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSPanelLNParamService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSPanelLNParam pSPanelLNParam = new PSPanelLNParam();
                pSPanelLNParam.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
                pSPanelLNParam.setPSPanelLogicNodeName(pSPanelLogicNode.getPSPanelLogicNodeName());
                pSPanelLNParam.setPSSysViewPanelLogicId(pSPanelLogicNode.getPSSysViewPanelLogicId());
                pSPanelLNParamService.compileModelV2(pSPanelLNParam, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSPanelLNParam pSPanelLNParam = new PSPanelLNParam();
                    pSPanelLNParam.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
                    pSPanelLNParam.setPSPanelLogicNodeName(pSPanelLogicNode.getPSPanelLogicNodeName());
                    pSPanelLNParam.setPSSysViewPanelLogicId(pSPanelLogicNode.getPSSysViewPanelLogicId());
                    pSPanelLNParamService.compileModelV2(pSPanelLNParam, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSPanelLogicNode, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSPanelLogicNode pSPanelLogicNode, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSPANELLNPARAM_PSPANELLOGICNODE_PSPANELLOGICNODEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSPanelLNParams(pSPanelLogicNode, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSPanelLogicNode, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSPanelLNParams(PSPanelLogicNode pSPanelLogicNode, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSPANELLNPARAM", true), (boolean)false) == 0) {
            PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
            PSPanelLNParam pSPanelLNParam = new PSPanelLNParam();
            pSPanelLNParam.setPSPanelLNParamId(pSMOSFile.getPSModelId());
            if (!pSPanelLNParamService.get((IEntity)pSPanelLNParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSPanelLNParam.getPSPanelLogicNodeId(), (String)pSPanelLogicNode.getPSPanelLogicNodeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSPanelLNParamService.exportModelV2(pSPanelLNParam);
            pSPanelLNParam.reset();
            if (!pSPanelLNParamService.setModelV2ResScope((IEntity)pSPanelLNParam, "PSPANELLOGICNODE", pSPanelLogicNode.getPSPanelLogicNodeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSPanelLNParamService.importModelV2(pSPanelLNParam, objectNode);
            SessionFactoryManager.commit();
            return pSPanelLNParamService.getFile((IEntity)pSPanelLNParam);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSPanelLogicNode pSPanelLogicNode, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSPanelLNParams(pSPanelLogicNode, list);
        super.onFillPasteHelps(pSPanelLogicNode, list);
    }

    protected void onFillPasteHelps_PSPanelLNParams(PSPanelLogicNode pSPanelLogicNode, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSPANELLNPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSPANELLNPARAM_PSPANELLOGICNODE_PSPANELLOGICNODEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u903b\u8f91\u8282\u70b9]\u7684[\u9762\u677f\u903b\u8f91\u5904\u7406\u53c2\u6570]");
        list.add(pSHelpSection);
    }
}

