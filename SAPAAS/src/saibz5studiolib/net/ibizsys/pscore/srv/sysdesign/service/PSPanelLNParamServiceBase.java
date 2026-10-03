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
import net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLNParamDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLNParamDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLNParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNodeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParamBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLNParamServiceBase
extends PSCoreSysServiceBase<PSPanelLNParam> {
    private static final Log log = LogFactory.getLog(PSPanelLNParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPanelLNParamDEModel pSPanelLNParamDEModel;
    private PSPanelLNParamDAO pSPanelLNParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamService";
    }

    public PSPanelLNParamDEModel getPSPanelLNParamDEModel() {
        if (this.pSPanelLNParamDEModel == null) {
            try {
                this.pSPanelLNParamDEModel = (PSPanelLNParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLNParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLNParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPanelLNParamDEModel();
    }

    public PSPanelLNParamDAO getPSPanelLNParamDAO() {
        if (this.pSPanelLNParamDAO == null) {
            try {
                this.pSPanelLNParamDAO = (PSPanelLNParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLNParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLNParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPanelLNParamDAO();
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

    protected void onFillParentInfo(PSPanelLNParam pSPanelLNParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLNPARAM_PSPANELLOGICNODE_PSPANELLOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService", (SessionFactory)this.getSessionFactory());
            PSPanelLogicNode pSPanelLogicNode = (PSPanelLogicNode)iService.getDEModel().createEntity();
            pSPanelLogicNode.set("PSPANELLOGICNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPanelLogicNode);
            } else {
                iService.get(pSPanelLogicNode);
            }
            this.onFillParentInfo_PSPanelLogicNode(pSPanelLNParam, pSPanelLogicNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLNPARAM_PSPANELLOGICPARAM_DSTPSPANELLPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService", (SessionFactory)this.getSessionFactory());
            PSPanelLogicParam pSPanelLogicParam = (PSPanelLogicParam)iService.getDEModel().createEntity();
            pSPanelLogicParam.set("PSPANELLOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPanelLogicParam);
            } else {
                iService.get(pSPanelLogicParam);
            }
            this.onFillParentInfo_DstPSPanelLP(pSPanelLNParam, pSPanelLogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLNPARAM_PSPANELLOGICPARAM_SRCPSPANELLPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService", (SessionFactory)this.getSessionFactory());
            PSPanelLogicParam pSPanelLogicParam = (PSPanelLogicParam)iService.getDEModel().createEntity();
            pSPanelLogicParam.set("PSPANELLOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPanelLogicParam);
            } else {
                iService.get(pSPanelLogicParam);
            }
            this.onFillParentInfo_SrcPSPanelLP(pSPanelLNParam, pSPanelLogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLNPARAM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSPanelLNParam, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSPanelLNParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPanelLogicNode(PSPanelLNParam pSPanelLNParam, PSPanelLogicNode pSPanelLogicNode) throws Exception {
        pSPanelLNParam.setPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
        pSPanelLNParam.setPSPanelLogicNodeName(pSPanelLogicNode.getPSPanelLogicNodeName());
        pSPanelLNParam.setPSSysViewPanelLogicId(pSPanelLogicNode.getPSSysViewPanelLogicId());
        if (pSPanelLogicNode.getPSSysViewPanel() != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLNParam, pSPanelLogicNode.getPSSysViewPanel());
        }
    }

    protected void onFillParentInfo_DstPSPanelLP(PSPanelLNParam pSPanelLNParam, PSPanelLogicParam pSPanelLogicParam) throws Exception {
        pSPanelLNParam.setDstPSPanelLPId(pSPanelLogicParam.getPSPanelLogicParamId());
        pSPanelLNParam.setDstPSPanelLPName(pSPanelLogicParam.getPSPanelLogicParamName());
    }

    protected void onFillParentInfo_SrcPSPanelLP(PSPanelLNParam pSPanelLNParam, PSPanelLogicParam pSPanelLogicParam) throws Exception {
        pSPanelLNParam.setSrcPSPanelLPId(pSPanelLogicParam.getPSPanelLogicParamId());
        pSPanelLNParam.setSrcPSPanelLPName(pSPanelLogicParam.getPSPanelLogicParamName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSPanelLNParam pSPanelLNParam, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSPanelLNParam.setPSSystemId(pSSysViewPanel.getPSSystemId());
        pSPanelLNParam.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSPanelLNParam.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPanelLNParam, bl);
        this.onFillEntityFullInfo_PSPanelLogicNode(pSPanelLNParam, bl);
        this.onFillEntityFullInfo_DstPSPanelLP(pSPanelLNParam, bl);
        this.onFillEntityFullInfo_SrcPSPanelLP(pSPanelLNParam, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLNParam, bl);
    }

    protected void onFillEntityFullInfo_PSPanelLogicNode(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
        if (pSPanelLNParam.isPSPanelLogicNodeIdDirty()) {
            if (pSPanelLNParam.getPSPanelLogicNodeId() != null) {
                PSPanelLogicNode pSPanelLogicNode;
                if (pSPanelLNParam.getPSPanelLogicNodeId() == null || pSPanelLNParam.getPSPanelLogicNodeName() == null) {
                    pSPanelLogicNode = pSPanelLNParam.getPSPanelLogicNode();
                    pSPanelLNParam.setPSPanelLogicNodeName(pSPanelLogicNode.getPSPanelLogicNodeName());
                    pSPanelLNParam.setPSSysViewPanelLogicId(pSPanelLogicNode.getPSSysViewPanelLogicId());
                }
                pSPanelLogicNode = pSPanelLNParam.getPSPanelLogicNode();
                if (DataTypeHelper.compare((int)25, (Object)pSPanelLogicNode.getPSSysViewPanelId(), (Object)pSPanelLNParam.getPSSysViewPanelId()) != 0L) {
                    pSPanelLNParam.setPSSysViewPanelId(pSPanelLogicNode.getPSSysViewPanelId());
                    this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLNParam, bl);
                }
            } else {
                pSPanelLNParam.setPSPanelLogicNodeName(null);
                pSPanelLNParam.setPSSysViewPanelLogicId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSPanelLP(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SrcPSPanelLP(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSPanelLNParam, bl);
    }

    public ArrayList<PSPanelLNParam> selectByPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase) throws Exception {
        return this.selectByPSPanelLogicNode(pSPanelLogicNodeBase, "", -1);
    }

    public ArrayList<PSPanelLNParam> selectByPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string) throws Exception {
        return this.selectByPSPanelLogicNode(pSPanelLogicNodeBase, string, -1);
    }

    public ArrayList<PSPanelLNParam> selectByPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELLOGICNODEID", (Object)pSPanelLogicNodeBase.getPSPanelLogicNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPanelLogicNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPanelLogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLNParam> selectTempByPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase) throws Exception {
        return this.selectTempByPSPanelLogicNode(pSPanelLogicNodeBase, "");
    }

    public ArrayList<PSPanelLNParam> selectTempByPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELLOGICNODEID", (Object)pSPanelLogicNodeBase.getPSPanelLogicNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSPanelLogicNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSPanelLogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLNParam> selectByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase) throws Exception {
        return this.selectByDstPSPanelLP(pSPanelLogicParamBase, "", -1);
    }

    public ArrayList<PSPanelLNParam> selectByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string) throws Exception {
        return this.selectByDstPSPanelLP(pSPanelLogicParamBase, string, -1);
    }

    public ArrayList<PSPanelLNParam> selectByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSPANELLPID", (Object)pSPanelLogicParamBase.getPSPanelLogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSPanelLPCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSPanelLPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLNParam> selectTempByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase) throws Exception {
        return this.selectTempByDstPSPanelLP(pSPanelLogicParamBase, "");
    }

    public ArrayList<PSPanelLNParam> selectTempByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSPANELLPID", (Object)pSPanelLogicParamBase.getPSPanelLogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSPanelLPCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSPanelLPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLNParam> selectBySrcPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase) throws Exception {
        return this.selectBySrcPSPanelLP(pSPanelLogicParamBase, "", -1);
    }

    public ArrayList<PSPanelLNParam> selectBySrcPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string) throws Exception {
        return this.selectBySrcPSPanelLP(pSPanelLogicParamBase, string, -1);
    }

    public ArrayList<PSPanelLNParam> selectBySrcPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSPANELLPID", (Object)pSPanelLogicParamBase.getPSPanelLogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSPanelLPCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSPanelLPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLNParam> selectTempBySrcPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase) throws Exception {
        return this.selectTempBySrcPSPanelLP(pSPanelLogicParamBase, "");
    }

    public ArrayList<PSPanelLNParam> selectTempBySrcPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSPANELLPID", (Object)pSPanelLogicParamBase.getPSPanelLogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempBySrcPSPanelLPCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempBySrcPSPanelLPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLNParam> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSPanelLNParam> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSPanelLNParam> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLNParam> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSPanelLNParam> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    public void resetPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectByPSPanelLogicNode(pSPanelLogicNode);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            PSPanelLNParam pSPanelLNParam2 = (PSPanelLNParam)this.getDEModel().createEntity();
            pSPanelLNParam2.setPSPanelLNParamId(pSPanelLNParam.getPSPanelLNParamId());
            pSPanelLNParam2.setPSPanelLogicNodeId(null);
            this.update(pSPanelLNParam2);
        }
    }

    public void resetTempPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectTempByPSPanelLogicNode(pSPanelLogicNode);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            PSPanelLNParam pSPanelLNParam2 = (PSPanelLNParam)this.getDEModel().createEntity();
            pSPanelLNParam2.setPSPanelLNParamId(pSPanelLNParam.getPSPanelLNParamId());
            pSPanelLNParam2.setPSPanelLogicNodeId(null);
            this.updateTemp(pSPanelLNParam2);
        }
    }

    public void removeByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        final PSPanelLogicNode pSPanelLogicNode2 = pSPanelLogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLNParamServiceBase.this.onBeforeRemoveByPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLNParamServiceBase.this.internalRemoveByPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLNParamServiceBase.this.onAfterRemoveByPSPanelLogicNode(pSPanelLogicNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void internalRemoveByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectByPSPanelLogicNode(pSPanelLogicNode);
        this.onBeforeRemoveByPSPanelLogicNode(pSPanelLogicNode, arrayList);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            this.remove(pSPanelLNParam);
        }
        this.onAfterRemoveByPSPanelLogicNode(pSPanelLogicNode, arrayList);
    }

    protected void onAfterRemoveByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void onBeforeRemoveByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    public void testRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectByDstPSPanelLP(pSPanelLogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPANELLOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPanelLogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELLNPARAM_PSPANELLOGICPARAM_DSTPSPANELLPID", "", iDataEntityModel.getName(), "PSPANELLNPARAM", iDataEntityModel.getDataInfo(pSPanelLogicParam), arrayList.get(0)));
        }
    }

    public void resetDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectByDstPSPanelLP(pSPanelLogicParam);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            PSPanelLNParam pSPanelLNParam2 = (PSPanelLNParam)this.getDEModel().createEntity();
            pSPanelLNParam2.setPSPanelLNParamId(pSPanelLNParam.getPSPanelLNParamId());
            pSPanelLNParam2.setDstPSPanelLPId(null);
            this.update(pSPanelLNParam2);
        }
    }

    public void resetTempDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectTempByDstPSPanelLP(pSPanelLogicParam);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            PSPanelLNParam pSPanelLNParam2 = (PSPanelLNParam)this.getDEModel().createEntity();
            pSPanelLNParam2.setPSPanelLNParamId(pSPanelLNParam.getPSPanelLNParamId());
            pSPanelLNParam2.setDstPSPanelLPId(null);
            this.updateTemp(pSPanelLNParam2);
        }
    }

    public void removeByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        final PSPanelLogicParam pSPanelLogicParam2 = pSPanelLogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLNParamServiceBase.this.onBeforeRemoveByDstPSPanelLP(pSPanelLogicParam2);
                PSPanelLNParamServiceBase.this.internalRemoveByDstPSPanelLP(pSPanelLogicParam2);
                PSPanelLNParamServiceBase.this.onAfterRemoveByDstPSPanelLP(pSPanelLogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void internalRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectByDstPSPanelLP(pSPanelLogicParam);
        this.onBeforeRemoveByDstPSPanelLP(pSPanelLogicParam, arrayList);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            this.remove(pSPanelLNParam);
        }
        this.onAfterRemoveByDstPSPanelLP(pSPanelLogicParam, arrayList);
    }

    protected void onAfterRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void onBeforeRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectBySrcPSPanelLP(pSPanelLogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPANELLOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPanelLogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELLNPARAM_PSPANELLOGICPARAM_SRCPSPANELLPID", "", iDataEntityModel.getName(), "PSPANELLNPARAM", iDataEntityModel.getDataInfo(pSPanelLogicParam), arrayList.get(0)));
        }
    }

    public void resetSrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectBySrcPSPanelLP(pSPanelLogicParam);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            PSPanelLNParam pSPanelLNParam2 = (PSPanelLNParam)this.getDEModel().createEntity();
            pSPanelLNParam2.setPSPanelLNParamId(pSPanelLNParam.getPSPanelLNParamId());
            pSPanelLNParam2.setSrcPSPanelLPId(null);
            this.update(pSPanelLNParam2);
        }
    }

    public void resetTempSrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectTempBySrcPSPanelLP(pSPanelLogicParam);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            PSPanelLNParam pSPanelLNParam2 = (PSPanelLNParam)this.getDEModel().createEntity();
            pSPanelLNParam2.setPSPanelLNParamId(pSPanelLNParam.getPSPanelLNParamId());
            pSPanelLNParam2.setSrcPSPanelLPId(null);
            this.updateTemp(pSPanelLNParam2);
        }
    }

    public void removeBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        final PSPanelLogicParam pSPanelLogicParam2 = pSPanelLogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLNParamServiceBase.this.onBeforeRemoveBySrcPSPanelLP(pSPanelLogicParam2);
                PSPanelLNParamServiceBase.this.internalRemoveBySrcPSPanelLP(pSPanelLogicParam2);
                PSPanelLNParamServiceBase.this.onAfterRemoveBySrcPSPanelLP(pSPanelLogicParam2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void internalRemoveBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectBySrcPSPanelLP(pSPanelLogicParam);
        this.onBeforeRemoveBySrcPSPanelLP(pSPanelLogicParam, arrayList);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            this.remove(pSPanelLNParam);
        }
        this.onAfterRemoveBySrcPSPanelLP(pSPanelLogicParam, arrayList);
    }

    protected void onAfterRemoveBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            PSPanelLNParam pSPanelLNParam2 = (PSPanelLNParam)this.getDEModel().createEntity();
            pSPanelLNParam2.setPSPanelLNParamId(pSPanelLNParam.getPSPanelLNParamId());
            pSPanelLNParam2.setPSSysViewPanelId(null);
            this.update(pSPanelLNParam2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            PSPanelLNParam pSPanelLNParam2 = (PSPanelLNParam)this.getDEModel().createEntity();
            pSPanelLNParam2.setPSPanelLNParamId(pSPanelLNParam.getPSPanelLNParamId());
            pSPanelLNParam2.setPSSysViewPanelId(null);
            this.updateTemp(pSPanelLNParam2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLNParamServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLNParamServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLNParamServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            this.remove(pSPanelLNParam);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPanelLNParam pSPanelLNParam) throws Exception {
        super.onBeforeRemove(pSPanelLNParam);
    }

    public void removeTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        final PSPanelLogicParam pSPanelLogicParam2 = pSPanelLogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLNParamServiceBase.this.onBeforeRemoveTempByDstPSPanelLP(pSPanelLogicParam2);
                PSPanelLNParamServiceBase.this.internalRemoveTempByDstPSPanelLP(pSPanelLogicParam2);
                PSPanelLNParamServiceBase.this.onAfterRemoveTempByDstPSPanelLP(pSPanelLogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void internalRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectTempByDstPSPanelLP(pSPanelLogicParam);
        this.onBeforeRemoveTempByDstPSPanelLP(pSPanelLogicParam, arrayList);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            this.removeTemp(pSPanelLNParam);
        }
        this.onAfterRemoveTempByDstPSPanelLP(pSPanelLogicParam, arrayList);
    }

    protected void onAfterRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    public void removeTempBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        final PSPanelLogicParam pSPanelLogicParam2 = pSPanelLogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLNParamServiceBase.this.onBeforeRemoveTempBySrcPSPanelLP(pSPanelLogicParam2);
                PSPanelLNParamServiceBase.this.internalRemoveTempBySrcPSPanelLP(pSPanelLogicParam2);
                PSPanelLNParamServiceBase.this.onAfterRemoveTempBySrcPSPanelLP(pSPanelLogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void internalRemoveTempBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectTempBySrcPSPanelLP(pSPanelLogicParam);
        this.onBeforeRemoveTempBySrcPSPanelLP(pSPanelLogicParam, arrayList);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            this.removeTemp(pSPanelLNParam);
        }
        this.onAfterRemoveTempBySrcPSPanelLP(pSPanelLogicParam, arrayList);
    }

    protected void onAfterRemoveTempBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempBySrcPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    public void removeTempByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        final PSPanelLogicNode pSPanelLogicNode2 = pSPanelLogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLNParamServiceBase.this.onBeforeRemoveTempByPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLNParamServiceBase.this.internalRemoveTempByPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLNParamServiceBase.this.onAfterRemoveTempByPSPanelLogicNode(pSPanelLogicNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void internalRemoveTempByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectTempByPSPanelLogicNode(pSPanelLogicNode);
        this.onBeforeRemoveTempByPSPanelLogicNode(pSPanelLogicNode, arrayList);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            this.removeTemp(pSPanelLNParam);
        }
        this.onAfterRemoveTempByPSPanelLogicNode(pSPanelLogicNode, arrayList);
    }

    protected void onAfterRemoveTempByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void onBeforeRemoveTempByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLNParamServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLNParamServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLNParamServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLNParam> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            this.removeTemp(pSPanelLNParam);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLNParam> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSPanelLNParam pSPanelLNParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPanelLNParam, cloneSession);
        if (pSPanelLNParam.getPSPanelLogicNodeId() != null && (iEntity = cloneSession.getEntity("PSPANELLOGICNODE", (Object)pSPanelLNParam.getPSPanelLogicNodeId())) != null) {
            this.onFillParentInfo_PSPanelLogicNode(pSPanelLNParam, (PSPanelLogicNode)iEntity);
        }
        if (pSPanelLNParam.getDstPSPanelLPId() != null && (iEntity = cloneSession.getEntity("PSPANELLOGICPARAM", (Object)pSPanelLNParam.getDstPSPanelLPId())) != null) {
            this.onFillParentInfo_DstPSPanelLP(pSPanelLNParam, (PSPanelLogicParam)iEntity);
        }
        if (pSPanelLNParam.getSrcPSPanelLPId() != null && (iEntity = cloneSession.getEntity("PSPANELLOGICPARAM", (Object)pSPanelLNParam.getSrcPSPanelLPId())) != null) {
            this.onFillParentInfo_SrcPSPanelLP(pSPanelLNParam, (PSPanelLogicParam)iEntity);
        }
        if (pSPanelLNParam.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSPanelLNParam.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLNParam, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPanelLNParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DstFieldName(bl, pSPanelLNParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSPanelLPId(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLNParamId(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLNParamName(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicNodeId(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicNodeName(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcFieldName(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSPanelLPId(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValue(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValueType(bl, pSPanelLNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPanelLNParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DstFieldName(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isDstFieldNameDirty() : !pSPanelLNParam.isDstFieldNameDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getDstFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstFieldName_Default(pSPanelLNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstPSPanelLPId(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isDstPSPanelLPIdDirty() : !pSPanelLNParam.isDstPSPanelLPIdDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getDstPSPanelLPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSPanelLPId_Default(pSPanelLNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSPANELLPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isOrderValueDirty() && !bl2 : !pSPanelLNParam.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSPanelLNParam.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSPanelLNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isParamTypeDirty() && !bl2 : !pSPanelLNParam.isParamTypeDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getParamType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default(pSPanelLNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPanelLNParamId(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isPSPanelLNParamIdDirty() && !bl2 : !pSPanelLNParam.isPSPanelLNParamIdDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getPSPanelLNParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLNPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLNParamId_Default(pSPanelLNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLNPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLNParamName(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isPSPanelLNParamNameDirty() && !bl2 : !pSPanelLNParam.isPSPanelLNParamNameDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getPSPanelLNParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLNPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLNParamName_Default(pSPanelLNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLNPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicNodeId(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isPSPanelLogicNodeIdDirty() && !bl2 : !pSPanelLNParam.isPSPanelLogicNodeIdDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getPSPanelLogicNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicNodeId_Default(pSPanelLNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPanelLogicNodeName(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isPSPanelLogicNodeNameDirty() : !pSPanelLNParam.isPSPanelLogicNodeNameDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getPSPanelLogicNodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicNodeName_Default(pSPanelLNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isPSSysViewPanelIdDirty() && !bl2 : !pSPanelLNParam.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getPSSysViewPanelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSPanelLNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_SrcFieldName(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isSrcFieldNameDirty() : !pSPanelLNParam.isSrcFieldNameDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getSrcFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcFieldName_Default(pSPanelLNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSPanelLPId(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isSrcPSPanelLPIdDirty() : !pSPanelLNParam.isSrcPSPanelLPIdDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getSrcPSPanelLPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSPanelLPId_Default(pSPanelLNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSPANELLPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValue(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isSrcValueDirty() : !pSPanelLNParam.isSrcValueDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getSrcValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcValue_Default(pSPanelLNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValueType(boolean bl, PSPanelLNParam pSPanelLNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLNParam.isSrcValueTypeDirty() && !bl2 : !pSPanelLNParam.isSrcValueTypeDirty()) {
            return null;
        }
        String string = pSPanelLNParam.getSrcValueType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcValueType_Default(pSPanelLNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
        super.onSyncEntity(pSPanelLNParam, bl);
    }

    protected void onSyncIndexEntities(PSPanelLNParam pSPanelLNParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPanelLNParam, bl);
    }

    public Object getDataContextValue(PSPanelLNParam pSPanelLNParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPanelLNParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSPanelLogicNode pSPanelLogicNode = pSPanelLNParam.getPSPanelLogicNode();
        if (pSPanelLogicNode != null && pSPanelLogicNode.contains(string)) {
            return pSPanelLogicNode.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPanelLNParam pSPanelLNParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPanelLNParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSPANELLPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSPanelLPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSPANELLPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSPanelLPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLNPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLNParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLNPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLNParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicNodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSPANELLPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSPanelLPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSPANELLPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSPanelLPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValueType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DstFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTFIELDNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("DSTFIELDNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSPanelLPId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSPANELLPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSPanelLPName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSPANELLPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLNParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLNPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLNParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLNPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_SrcFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCFIELDNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("SRCFIELDNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSPanelLPId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSPANELLPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSPanelLPName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSPANELLPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCVALUE", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCVALUETYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected boolean onMergeChild(String string, String string2, PSPanelLNParam pSPanelLNParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPanelLNParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPanelLNParam pSPanelLNParam) throws Exception {
        super.onUpdateParent(pSPanelLNParam);
    }

    @Override
    protected void exportCurXmlModel(PSPanelLNParam pSPanelLNParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPANELLNPARAM");
        if (!bl) {
            pSPanelLNParam.setCreateDate(null);
            pSPanelLNParam.setCreateMan(null);
            pSPanelLNParam.setPSPanelLNParamId(null);
            pSPanelLNParam.setUpdateDate(null);
            pSPanelLNParam.setUpdateMan(null);
            pSPanelLNParam.setDstPSPanelLPId(null);
            pSPanelLNParam.setSrcPSPanelLPId(null);
            pSPanelLNParam.setPSPanelLogicNodeId(null);
            pSPanelLNParam.setPSPanelLogicNodeName(null);
            pSPanelLNParam.setPSSysViewPanelLogicId(null);
            pSPanelLNParam.setPSSystemId(null);
            pSPanelLNParam.setPSSysViewPanelId(null);
            pSPanelLNParam.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSPanelLNParam, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSPanelLNParam pSPanelLNParam, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSPanelLNParam, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSPANELLOGICNODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSPANELLOGICNODE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSPANELLOGICNODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSPANELLNPARAM_PSPANELLOGICNODE_PSPANELLOGICNODEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSPANELLOGICNODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSPANELLOGICNODENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICNODE", (boolean)true) == 0) {
            iEntity.set("PSPANELLOGICNODEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSPANELLOGICNODEID"};
    }

    @Override
    public String getModelV2Tag(PSPanelLNParam pSPanelLNParam) {
        return super.getModelV2Tag(pSPanelLNParam);
    }

    @Override
    public boolean setModelV2Tag(PSPanelLNParam pSPanelLNParam, String string) {
        return super.setModelV2Tag(pSPanelLNParam, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSPANELLOGICNODEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSPanelLNParam pSPanelLNParam, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSPanelLNParam.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSPanelLNParam, true);
        return super.getModelV2Entity(pSPanelLNParam, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSPanelLNParam pSPanelLNParam, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSPanelLNParam, objectNode, string, string2, n);
    }
}

