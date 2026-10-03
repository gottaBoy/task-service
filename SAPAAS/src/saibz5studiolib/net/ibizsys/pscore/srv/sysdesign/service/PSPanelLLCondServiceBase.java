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
import net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLLCondDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLLCondDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCond;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCondBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLinkBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParamBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLLCondServiceBase
extends PSCoreSysServiceBase<PSPanelLLCond> {
    private static final Log log = LogFactory.getLog(PSPanelLLCondServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPanelLLCondDEModel pSPanelLLCondDEModel;
    private PSPanelLLCondDAO pSPanelLLCondDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService";
    }

    public PSPanelLLCondDEModel getPSPanelLLCondDEModel() {
        if (this.pSPanelLLCondDEModel == null) {
            try {
                this.pSPanelLLCondDEModel = (PSPanelLLCondDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLLCondDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLLCondDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPanelLLCondDEModel();
    }

    public PSPanelLLCondDAO getPSPanelLLCondDAO() {
        if (this.pSPanelLLCondDAO == null) {
            try {
                this.pSPanelLLCondDAO = (PSPanelLLCondDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLLCondDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLLCondDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPanelLLCondDAO();
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

    protected void onFillParentInfo(PSPanelLLCond pSPanelLLCond, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLLCOND_PSPANELLLCOND_PPSPANELLLCONDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService", (SessionFactory)this.getSessionFactory());
            PSPanelLLCond pSPanelLLCond2 = (PSPanelLLCond)iService.getDEModel().createEntity();
            pSPanelLLCond2.set("PSPANELLLCONDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPanelLLCond2);
            } else {
                iService.get(pSPanelLLCond2);
            }
            this.onFillParentInfo_PPSPanelLLCond(pSPanelLLCond, pSPanelLLCond2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLLCOND_PSPANELLOGICLINK_PSPANELLOGICLINKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService", (SessionFactory)this.getSessionFactory());
            PSPanelLogicLink pSPanelLogicLink = (PSPanelLogicLink)iService.getDEModel().createEntity();
            pSPanelLogicLink.set("PSPANELLOGICLINKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPanelLogicLink);
            } else {
                iService.get(pSPanelLogicLink);
            }
            this.onFillParentInfo_PSPanelLogicLink(pSPanelLLCond, pSPanelLogicLink);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLLCOND_PSPANELLOGICPARAM_DSTPSPANELLPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService", (SessionFactory)this.getSessionFactory());
            PSPanelLogicParam pSPanelLogicParam = (PSPanelLogicParam)iService.getDEModel().createEntity();
            pSPanelLogicParam.set("PSPANELLOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPanelLogicParam);
            } else {
                iService.get(pSPanelLogicParam);
            }
            this.onFillParentInfo_DstPSPanelLP(pSPanelLLCond, pSPanelLogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLLCOND_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSPanelLLCond, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSPanelLLCond, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSPanelLLCond(PSPanelLLCond pSPanelLLCond, PSPanelLLCond pSPanelLLCond2) throws Exception {
        pSPanelLLCond.setPPSPanelLLCondId(pSPanelLLCond2.getPSPanelLLCondId());
        pSPanelLLCond.setPPSPanelLLCondName(pSPanelLLCond2.getPSPanelLLCondName());
    }

    protected void onFillParentInfo_PSPanelLogicLink(PSPanelLLCond pSPanelLLCond, PSPanelLogicLink pSPanelLogicLink) throws Exception {
        pSPanelLLCond.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
        pSPanelLLCond.setPSPanelLogicLinkName(pSPanelLogicLink.getPSPanelLogicLinkName());
        pSPanelLLCond.setPSSysViewPanelLogicId(pSPanelLogicLink.getPSSysViewPanelLogicId());
        if (pSPanelLogicLink.getPSSysViewPanel() != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLLCond, pSPanelLogicLink.getPSSysViewPanel());
        }
    }

    protected void onFillParentInfo_DstPSPanelLP(PSPanelLLCond pSPanelLLCond, PSPanelLogicParam pSPanelLogicParam) throws Exception {
        pSPanelLLCond.setDstPSPanelLPId(pSPanelLogicParam.getPSPanelLogicParamId());
        pSPanelLLCond.setDstPSPanelLPName(pSPanelLogicParam.getPSPanelLogicParamName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSPanelLLCond pSPanelLLCond, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSPanelLLCond.setPSSystemId(pSSysViewPanel.getPSSystemId());
        pSPanelLLCond.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSPanelLLCond.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPanelLLCond, bl);
        this.onFillEntityFullInfo_PPSPanelLLCond(pSPanelLLCond, bl);
        this.onFillEntityFullInfo_PSPanelLogicLink(pSPanelLLCond, bl);
        this.onFillEntityFullInfo_DstPSPanelLP(pSPanelLLCond, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLLCond, bl);
    }

    protected void onFillEntityFullInfo_PPSPanelLLCond(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
        if (pSPanelLLCond.isPPSPanelLLCondIdDirty()) {
            if (pSPanelLLCond.getPPSPanelLLCondId() != null) {
                if (pSPanelLLCond.getPPSPanelLLCondId() == null || pSPanelLLCond.getPPSPanelLLCondName() == null) {
                    PSPanelLLCond pSPanelLLCond2 = pSPanelLLCond.getPPSPanelLLCond();
                    pSPanelLLCond.setPPSPanelLLCondName(pSPanelLLCond2.getPSPanelLLCondName());
                }
            } else {
                pSPanelLLCond.setPPSPanelLLCondName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPanelLogicLink(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
        if (pSPanelLLCond.isPSPanelLogicLinkIdDirty()) {
            if (pSPanelLLCond.getPSPanelLogicLinkId() != null) {
                PSPanelLogicLink pSPanelLogicLink;
                if (pSPanelLLCond.getPSPanelLogicLinkId() == null || pSPanelLLCond.getPSPanelLogicLinkName() == null) {
                    pSPanelLogicLink = pSPanelLLCond.getPSPanelLogicLink();
                    pSPanelLLCond.setPSPanelLogicLinkName(pSPanelLogicLink.getPSPanelLogicLinkName());
                    pSPanelLLCond.setPSSysViewPanelLogicId(pSPanelLogicLink.getPSSysViewPanelLogicId());
                }
                pSPanelLogicLink = pSPanelLLCond.getPSPanelLogicLink();
                if (DataTypeHelper.compare((int)25, (Object)pSPanelLogicLink.getPSSysViewPanelId(), (Object)pSPanelLLCond.getPSSysViewPanelId()) != 0L) {
                    pSPanelLLCond.setPSSysViewPanelId(pSPanelLogicLink.getPSSysViewPanelId());
                    this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLLCond, bl);
                }
            } else {
                pSPanelLLCond.setPSPanelLogicLinkName(null);
                pSPanelLLCond.setPSSysViewPanelLogicId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSPanelLP(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
        super.onWriteBackParent(pSPanelLLCond, bl);
    }

    public ArrayList<PSPanelLLCond> selectByPPSPanelLLCond(PSPanelLLCondBase pSPanelLLCondBase) throws Exception {
        return this.selectByPPSPanelLLCond(pSPanelLLCondBase, "", -1);
    }

    public ArrayList<PSPanelLLCond> selectByPPSPanelLLCond(PSPanelLLCondBase pSPanelLLCondBase, String string) throws Exception {
        return this.selectByPPSPanelLLCond(pSPanelLLCondBase, string, -1);
    }

    public ArrayList<PSPanelLLCond> selectByPPSPanelLLCond(PSPanelLLCondBase pSPanelLLCondBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSPANELLLCONDID", (Object)pSPanelLLCondBase.getPSPanelLLCondId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSPanelLLCondCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSPanelLLCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLLCond> selectTempByPPSPanelLLCond(PSPanelLLCondBase pSPanelLLCondBase) throws Exception {
        return this.selectTempByPPSPanelLLCond(pSPanelLLCondBase, "");
    }

    public ArrayList<PSPanelLLCond> selectTempByPPSPanelLLCond(PSPanelLLCondBase pSPanelLLCondBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSPANELLLCONDID", (Object)pSPanelLLCondBase.getPSPanelLLCondId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSPanelLLCondCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSPanelLLCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLLCond> selectByPSPanelLogicLink(PSPanelLogicLinkBase pSPanelLogicLinkBase) throws Exception {
        return this.selectByPSPanelLogicLink(pSPanelLogicLinkBase, "", -1);
    }

    public ArrayList<PSPanelLLCond> selectByPSPanelLogicLink(PSPanelLogicLinkBase pSPanelLogicLinkBase, String string) throws Exception {
        return this.selectByPSPanelLogicLink(pSPanelLogicLinkBase, string, -1);
    }

    public ArrayList<PSPanelLLCond> selectByPSPanelLogicLink(PSPanelLogicLinkBase pSPanelLogicLinkBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELLOGICLINKID", (Object)pSPanelLogicLinkBase.getPSPanelLogicLinkId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPanelLogicLinkCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPanelLogicLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLLCond> selectTempByPSPanelLogicLink(PSPanelLogicLinkBase pSPanelLogicLinkBase) throws Exception {
        return this.selectTempByPSPanelLogicLink(pSPanelLogicLinkBase, "");
    }

    public ArrayList<PSPanelLLCond> selectTempByPSPanelLogicLink(PSPanelLogicLinkBase pSPanelLogicLinkBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPANELLOGICLINKID", (Object)pSPanelLogicLinkBase.getPSPanelLogicLinkId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSPanelLogicLinkCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSPanelLogicLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLLCond> selectByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase) throws Exception {
        return this.selectByDstPSPanelLP(pSPanelLogicParamBase, "", -1);
    }

    public ArrayList<PSPanelLLCond> selectByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string) throws Exception {
        return this.selectByDstPSPanelLP(pSPanelLogicParamBase, string, -1);
    }

    public ArrayList<PSPanelLLCond> selectByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLLCond> selectTempByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase) throws Exception {
        return this.selectTempByDstPSPanelLP(pSPanelLogicParamBase, "");
    }

    public ArrayList<PSPanelLLCond> selectTempByDstPSPanelLP(PSPanelLogicParamBase pSPanelLogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSPANELLPID", (Object)pSPanelLogicParamBase.getPSPanelLogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSPanelLPCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSPanelLPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLLCond> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSPanelLLCond> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSPanelLLCond> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLLCond> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSPanelLLCond> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
    }

    public void resetPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByPPSPanelLLCond(pSPanelLLCond);
        for (PSPanelLLCond pSPanelLLCond2 : arrayList) {
            PSPanelLLCond pSPanelLLCond3 = (PSPanelLLCond)this.getDEModel().createEntity();
            pSPanelLLCond3.setPSPanelLLCondId(pSPanelLLCond2.getPSPanelLLCondId());
            pSPanelLLCond3.setPPSPanelLLCondId(null);
            this.update(pSPanelLLCond3);
        }
    }

    public void resetTempPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectTempByPPSPanelLLCond(pSPanelLLCond);
        for (PSPanelLLCond pSPanelLLCond2 : arrayList) {
            PSPanelLLCond pSPanelLLCond3 = (PSPanelLLCond)this.getDEModel().createEntity();
            pSPanelLLCond3.setPSPanelLLCondId(pSPanelLLCond2.getPSPanelLLCondId());
            pSPanelLLCond3.setPPSPanelLLCondId(null);
            this.updateTemp(pSPanelLLCond3);
        }
    }

    public void removeByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
        final PSPanelLLCond pSPanelLLCond2 = pSPanelLLCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondServiceBase.this.onBeforeRemoveByPPSPanelLLCond(pSPanelLLCond2);
                PSPanelLLCondServiceBase.this.internalRemoveByPPSPanelLLCond(pSPanelLLCond2);
                PSPanelLLCondServiceBase.this.onAfterRemoveByPPSPanelLLCond(pSPanelLLCond2);
            }
        });
    }

    protected void onBeforeRemoveByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
    }

    protected void internalRemoveByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByPPSPanelLLCond(pSPanelLLCond);
        this.onBeforeRemoveByPPSPanelLLCond(pSPanelLLCond, arrayList);
        for (PSPanelLLCond pSPanelLLCond2 : arrayList) {
            this.remove(pSPanelLLCond2);
        }
        this.onAfterRemoveByPPSPanelLLCond(pSPanelLLCond, arrayList);
    }

    protected void onAfterRemoveByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
    }

    protected void onBeforeRemoveByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    public void testRemoveByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
    }

    public void resetPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByPSPanelLogicLink(pSPanelLogicLink);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            PSPanelLLCond pSPanelLLCond2 = (PSPanelLLCond)this.getDEModel().createEntity();
            pSPanelLLCond2.setPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
            pSPanelLLCond2.setPSPanelLogicLinkId(null);
            this.update(pSPanelLLCond2);
        }
    }

    public void resetTempPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectTempByPSPanelLogicLink(pSPanelLogicLink);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            PSPanelLLCond pSPanelLLCond2 = (PSPanelLLCond)this.getDEModel().createEntity();
            pSPanelLLCond2.setPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
            pSPanelLLCond2.setPSPanelLogicLinkId(null);
            this.updateTemp(pSPanelLLCond2);
        }
    }

    public void removeByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        final PSPanelLogicLink pSPanelLogicLink2 = pSPanelLogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondServiceBase.this.onBeforeRemoveByPSPanelLogicLink(pSPanelLogicLink2);
                PSPanelLLCondServiceBase.this.internalRemoveByPSPanelLogicLink(pSPanelLogicLink2);
                PSPanelLLCondServiceBase.this.onAfterRemoveByPSPanelLogicLink(pSPanelLogicLink2);
            }
        });
    }

    protected void onBeforeRemoveByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
    }

    protected void internalRemoveByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByPSPanelLogicLink(pSPanelLogicLink);
        this.onBeforeRemoveByPSPanelLogicLink(pSPanelLogicLink, arrayList);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            this.remove(pSPanelLLCond);
        }
        this.onAfterRemoveByPSPanelLogicLink(pSPanelLogicLink, arrayList);
    }

    protected void onAfterRemoveByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
    }

    protected void onBeforeRemoveByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    public void testRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByDstPSPanelLP(pSPanelLogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPANELLOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPanelLogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPANELLLCOND_PSPANELLOGICPARAM_DSTPSPANELLPID", "", iDataEntityModel.getName(), "PSPANELLLCOND", iDataEntityModel.getDataInfo(pSPanelLogicParam), arrayList.get(0)));
        }
    }

    public void resetDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByDstPSPanelLP(pSPanelLogicParam);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            PSPanelLLCond pSPanelLLCond2 = (PSPanelLLCond)this.getDEModel().createEntity();
            pSPanelLLCond2.setPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
            pSPanelLLCond2.setDstPSPanelLPId(null);
            this.update(pSPanelLLCond2);
        }
    }

    public void resetTempDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectTempByDstPSPanelLP(pSPanelLogicParam);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            PSPanelLLCond pSPanelLLCond2 = (PSPanelLLCond)this.getDEModel().createEntity();
            pSPanelLLCond2.setPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
            pSPanelLLCond2.setDstPSPanelLPId(null);
            this.updateTemp(pSPanelLLCond2);
        }
    }

    public void removeByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        final PSPanelLogicParam pSPanelLogicParam2 = pSPanelLogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondServiceBase.this.onBeforeRemoveByDstPSPanelLP(pSPanelLogicParam2);
                PSPanelLLCondServiceBase.this.internalRemoveByDstPSPanelLP(pSPanelLogicParam2);
                PSPanelLLCondServiceBase.this.onAfterRemoveByDstPSPanelLP(pSPanelLogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void internalRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByDstPSPanelLP(pSPanelLogicParam);
        this.onBeforeRemoveByDstPSPanelLP(pSPanelLogicParam, arrayList);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            this.remove(pSPanelLLCond);
        }
        this.onAfterRemoveByDstPSPanelLP(pSPanelLogicParam, arrayList);
    }

    protected void onAfterRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void onBeforeRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            PSPanelLLCond pSPanelLLCond2 = (PSPanelLLCond)this.getDEModel().createEntity();
            pSPanelLLCond2.setPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
            pSPanelLLCond2.setPSSysViewPanelId(null);
            this.update(pSPanelLLCond2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            PSPanelLLCond pSPanelLLCond2 = (PSPanelLLCond)this.getDEModel().createEntity();
            pSPanelLLCond2.setPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
            pSPanelLLCond2.setPSSysViewPanelId(null);
            this.updateTemp(pSPanelLLCond2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLLCondServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLLCondServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            this.remove(pSPanelLLCond);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPanelLLCond pSPanelLLCond) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        pSPanelLLCondService.testRemoveByPPSPanelLLCond(pSPanelLLCond);
        pSPanelLLCondService.resetPPSPanelLLCond(pSPanelLLCond);
        super.onBeforeRemove(pSPanelLLCond);
    }

    protected void onBeforeRemoveTemp(PSPanelLLCond pSPanelLLCond) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        pSPanelLLCondService.resetTempPPSPanelLLCond(pSPanelLLCond);
        super.onBeforeRemoveTemp(pSPanelLLCond);
    }

    public void removeTempByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
        final PSPanelLLCond pSPanelLLCond2 = pSPanelLLCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondServiceBase.this.onBeforeRemoveTempByPPSPanelLLCond(pSPanelLLCond2);
                PSPanelLLCondServiceBase.this.internalRemoveTempByPPSPanelLLCond(pSPanelLLCond2);
                PSPanelLLCondServiceBase.this.onAfterRemoveTempByPPSPanelLLCond(pSPanelLLCond2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
    }

    protected void internalRemoveTempByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectTempByPPSPanelLLCond(pSPanelLLCond);
        this.onBeforeRemoveTempByPPSPanelLLCond(pSPanelLLCond, arrayList);
        for (PSPanelLLCond pSPanelLLCond2 : arrayList) {
            this.removeTemp(pSPanelLLCond2);
        }
        this.onAfterRemoveTempByPPSPanelLLCond(pSPanelLLCond, arrayList);
    }

    protected void onAfterRemoveTempByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSPanelLLCond(PSPanelLLCond pSPanelLLCond, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    public void removeTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        final PSPanelLogicParam pSPanelLogicParam2 = pSPanelLogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondServiceBase.this.onBeforeRemoveTempByDstPSPanelLP(pSPanelLogicParam2);
                PSPanelLLCondServiceBase.this.internalRemoveTempByDstPSPanelLP(pSPanelLogicParam2);
                PSPanelLLCondServiceBase.this.onAfterRemoveTempByDstPSPanelLP(pSPanelLogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void internalRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectTempByDstPSPanelLP(pSPanelLogicParam);
        this.onBeforeRemoveTempByDstPSPanelLP(pSPanelLogicParam, arrayList);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            this.removeTemp(pSPanelLLCond);
        }
        this.onAfterRemoveTempByDstPSPanelLP(pSPanelLogicParam, arrayList);
    }

    protected void onAfterRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSPanelLP(PSPanelLogicParam pSPanelLogicParam, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    public void removeTempByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        final PSPanelLogicLink pSPanelLogicLink2 = pSPanelLogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondServiceBase.this.onBeforeRemoveTempByPSPanelLogicLink(pSPanelLogicLink2);
                PSPanelLLCondServiceBase.this.internalRemoveTempByPSPanelLogicLink(pSPanelLogicLink2);
                PSPanelLLCondServiceBase.this.onAfterRemoveTempByPSPanelLogicLink(pSPanelLogicLink2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
    }

    protected void internalRemoveTempByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectTempByPSPanelLogicLink(pSPanelLogicLink);
        this.onBeforeRemoveTempByPSPanelLogicLink(pSPanelLogicLink, arrayList);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            this.removeTemp(pSPanelLLCond);
        }
        this.onAfterRemoveTempByPSPanelLogicLink(pSPanelLogicLink, arrayList);
    }

    protected void onAfterRemoveTempByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink) throws Exception {
    }

    protected void onBeforeRemoveTempByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSPanelLogicLink(PSPanelLogicLink pSPanelLogicLink, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLLCondServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLLCondServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            this.removeTemp(pSPanelLLCond);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLLCond> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSPanelLLCond pSPanelLLCond) throws Exception {
        super.getRelatedDataTempMajor(pSPanelLLCond);
    }

    protected void updateRelatedDataTempMajor(PSPanelLLCond pSPanelLLCond, PSPanelLLCond pSPanelLLCond2) throws Exception {
        super.updateRelatedDataTempMajor(pSPanelLLCond, pSPanelLLCond2);
    }

    protected void replaceParentInfo(PSPanelLLCond pSPanelLLCond, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPanelLLCond, cloneSession);
        if (pSPanelLLCond.getPPSPanelLLCondId() != null && (iEntity = cloneSession.getEntity("PSPANELLLCOND", (Object)pSPanelLLCond.getPPSPanelLLCondId())) != null) {
            this.onFillParentInfo_PPSPanelLLCond(pSPanelLLCond, (PSPanelLLCond)iEntity);
        }
        if (pSPanelLLCond.getPSPanelLogicLinkId() != null && (iEntity = cloneSession.getEntity("PSPANELLOGICLINK", (Object)pSPanelLLCond.getPSPanelLogicLinkId())) != null) {
            this.onFillParentInfo_PSPanelLogicLink(pSPanelLLCond, (PSPanelLogicLink)iEntity);
        }
        if (pSPanelLLCond.getDstPSPanelLPId() != null && (iEntity = cloneSession.getEntity("PSPANELLOGICPARAM", (Object)pSPanelLLCond.getDstPSPanelLPId())) != null) {
            this.onFillParentInfo_DstPSPanelLP(pSPanelLLCond, (PSPanelLogicParam)iEntity);
        }
        if (pSPanelLLCond.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSPanelLLCond.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLLCond, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPanelLLCond, bl);
    }

    protected void onCheckEntity(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondOp(bl, pSPanelLLCond, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondValue(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstFieldName(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSPanelLPId(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupNotFlag(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupOP(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicType(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSPanelLLCondId(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSPanelLLCondName(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLLCondId(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLLCondName(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicLinkId(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicLinkName(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSPanelLLCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPanelLLCond, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondOp(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isCondOpDirty() : !pSPanelLLCond.isCondOpDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getCondOp();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondOp_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_CondValue(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isCondValueDirty() : !pSPanelLLCond.isCondValueDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getCondValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValue_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstFieldName(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isDstFieldNameDirty() : !pSPanelLLCond.isDstFieldNameDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getDstFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstFieldName_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstPSPanelLPId(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isDstPSPanelLPIdDirty() : !pSPanelLLCond.isDstPSPanelLPIdDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getDstPSPanelLPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSPanelLPId_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupNotFlag(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isGroupNotFlagDirty() : !pSPanelLLCond.isGroupNotFlagDirty()) {
            return null;
        }
        Integer n = pSPanelLLCond.getGroupNotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupNotFlag_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupOP(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isGroupOPDirty() : !pSPanelLLCond.isGroupOPDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getGroupOP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupOP_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicType(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isLogicTypeDirty() && !bl2 : !pSPanelLLCond.isLogicTypeDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicType_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isMemoDirty() : !pSPanelLLCond.isMemoDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isOrderValueDirty() : !pSPanelLLCond.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSPanelLLCond.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isParamTypeDirty() : !pSPanelLLCond.isParamTypeDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default(pSPanelLLCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSPanelLLCondId(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isPPSPanelLLCondIdDirty() : !pSPanelLLCond.isPPSPanelLLCondIdDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getPPSPanelLLCondId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSPanelLLCondId_Default(pSPanelLLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSPANELLLCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSPanelLLCondName(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isPPSPanelLLCondNameDirty() : !pSPanelLLCond.isPPSPanelLLCondNameDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getPPSPanelLLCondName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSPanelLLCondName_Default(pSPanelLLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSPANELLLCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLLCondId(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isPSPanelLLCondIdDirty() && !bl2 : !pSPanelLLCond.isPSPanelLLCondIdDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getPSPanelLLCondId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLLCONDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLLCondId_Default(pSPanelLLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLLCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLLCondName(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isPSPanelLLCondNameDirty() && !bl2 : !pSPanelLLCond.isPSPanelLLCondNameDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getPSPanelLLCondName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLLCONDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLLCondName_Default(pSPanelLLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLLCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicLinkId(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isPSPanelLogicLinkIdDirty() && !bl2 : !pSPanelLLCond.isPSPanelLogicLinkIdDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getPSPanelLogicLinkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICLINKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicLinkId_Default(pSPanelLLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPanelLogicLinkName(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isPSPanelLogicLinkNameDirty() : !pSPanelLLCond.isPSPanelLogicLinkNameDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getPSPanelLogicLinkName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicLinkName_Default(pSPanelLLCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICLINKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSPanelLLCond pSPanelLLCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLLCond.isPSSysViewPanelIdDirty() && !bl2 : !pSPanelLLCond.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSPanelLLCond.getPSSysViewPanelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSPanelLLCond, bl2, bl3);
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

    protected void onSyncEntity(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
        super.onSyncEntity(pSPanelLLCond, bl);
    }

    protected void onSyncIndexEntities(PSPanelLLCond pSPanelLLCond, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPanelLLCond, bl);
    }

    public Object getDataContextValue(PSPanelLLCond pSPanelLLCond, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPanelLLCond, string, iDataContextParam)) != null) {
            return object;
        }
        PSPanelLogicLink pSPanelLogicLink = pSPanelLLCond.getPSPanelLogicLink();
        if (pSPanelLogicLink != null && pSPanelLogicLink.contains(string)) {
            return pSPanelLogicLink.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPanelLLCond pSPanelLLCond, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPanelLLCond, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DSTFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSPANELLPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSPanelLPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSPANELLPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSPanelLPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPNOTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupNotFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupOP_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSPANELLLCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSPanelLLCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSPANELLLCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSPanelLLCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLLCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLLCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLLCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLLCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPanelLogicLinkName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CONDVALUE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSPanelLLCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSPANELLLCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSPanelLLCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSPANELLLCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLLCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLLCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLLCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLLCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLogicLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLOGICLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPanelLogicLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPANELLOGICLINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPanelLLCond pSPanelLLCond) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPanelLLCond)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPanelLLCond pSPanelLLCond) throws Exception {
        super.onUpdateParent(pSPanelLLCond);
    }

    @Override
    protected void exportCurXmlModel(PSPanelLLCond pSPanelLLCond, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPANELLLCOND");
        if (!bl) {
            pSPanelLLCond.setCreateDate(null);
            pSPanelLLCond.setCreateMan(null);
            pSPanelLLCond.setPSPanelLLCondId(null);
            pSPanelLLCond.setUpdateDate(null);
            pSPanelLLCond.setUpdateMan(null);
            pSPanelLLCond.setPPSPanelLLCondId(null);
            pSPanelLLCond.setDstPSPanelLPId(null);
            pSPanelLLCond.setPSPanelLogicLinkId(null);
            pSPanelLLCond.setPSPanelLogicLinkName(null);
            pSPanelLLCond.setPSSysViewPanelLogicId(null);
            pSPanelLLCond.setPSSystemId(null);
            pSPanelLLCond.setPSSysViewPanelId(null);
            pSPanelLLCond.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSPanelLLCond, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSPanelLLCond pSPanelLLCond, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSPanelLLCond, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSPanelLLCond pSPanelLLCond, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSPanelLLCond, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSPanelLLCond pSPanelLLCond, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSPanelLLCond, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSPANELLLCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSPANELLLCOND#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSPANELLOGICLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSPANELLOGICLINK#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSPANELLLCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSPANELLLCOND_PSPANELLLCOND_PPSPANELLLCONDID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSPANELLOGICLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSPANELLLCOND_PSPANELLOGICLINK_PSPANELLOGICLINKID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSPANELLLCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSPANELLLCONDNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSPANELLOGICLINKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSPANELLOGICLINKNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSPANELLLCOND", (boolean)true) == 0) {
            iEntity.set("PPSPANELLLCONDID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSPANELLOGICLINK", (boolean)true) == 0) {
            iEntity.set("PSPANELLOGICLINKID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSPANELLLCONDID", "PSPANELLOGICLINKID"};
    }

    @Override
    public String getModelV2Tag(PSPanelLLCond pSPanelLLCond) {
        return super.getModelV2Tag(pSPanelLLCond);
    }

    @Override
    public boolean setModelV2Tag(PSPanelLLCond pSPanelLLCond, String string) {
        return super.setModelV2Tag(pSPanelLLCond, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSPANELLLCONDID", "");
        map.put("PSPANELLOGICLINKID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSPanelLLCond pSPanelLLCond, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSPanelLLCond.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSPanelLLCond, true);
        return super.getModelV2Entity(pSPanelLLCond, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSPanelLLCond pSPanelLLCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSPanelLLCond.getPPSPanelLLCondId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSPanelLLCond.getPSPanelLogicLinkId())) {
            bl = true;
        } else if (bl && !objectNode.has("pspanellogiclinkid")) {
            objectNode.put("pspanellogiclinkid", "<PSPANELLOGICLINK>");
        }
        return super.testCompileCurModelV2(pSPanelLLCond, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSPanelLLCond pSPanelLLCond, String string, Map<String, String> map) throws Exception {
        if (PSPanelLLCondServiceBase.isSimpleImportExportMode()) {
            map.put("PPSPANELLLCONDID", "");
            map.put("PSPANELLOGICLINKID", "");
        }
        return super.onFillModelV2(objectNode, pSPanelLLCond, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSPANELLLCOND_PSPANELLLCOND_PPSPANELLLCONDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSPanelLLCond pSPanelLLCond, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSPanelLLCond, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSPanelLLCond pSPanelLLCond, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELLLCOND_PSPANELLLCOND_PPSPANELLLCONDID")) {
            PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSPANELLLCOND#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELLLCOND", (Object)pSPanelLLCond.getPSPanelLLCondId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSPANELLLCOND#%1$s", (Object)pSPanelLLCond.getPSPanelLLCondId());
                for (PSPanelLLCond cond : pSPanelLLCondService.selectByPPSPanelLLCond(pSPanelLLCond)) {
                    String condScope = pSPanelLLCondService.getModelV2ResScope(cond);
                    if (StringHelper.compare((String)scope, (String)condScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(cond, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSPanelLLCondService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pspanelllcondname")) {
                            string = objectNode.get("pspanelllcondname").asText();
                        }
                        if (objectNode2.has("pspanelllcondname")) {
                            string2 = objectNode2.get("pspanelllcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode condNode : arrayList) {
                    PSPanelLLCond cond = new PSPanelLLCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)cond, condNode, false);
                    ((PSPanelLLCondBase)cond).remove("ordervalue");
                    output.add((JsonNode)pSPanelLLCondService.exportModelV2(cond, string));
                }
            }
        }
        super.onExportCurModelV2(pSPanelLLCond, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSPanelLLCond pSPanelLLCond) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = pSPanelLLCondService.selectByPPSPanelLLCond(pSPanelLLCond);
        String string = StringHelper.format((String)"PSPANELLLCOND#%1$s", (Object)pSPanelLLCond.getPSPanelLLCondId());
        for (PSPanelLLCond pSPanelLLCond2 : arrayList) {
            String string2 = pSPanelLLCondService.getModelV2ResScope(pSPanelLLCond2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSPanelLLCondService.emptyModelV2(pSPanelLLCond2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSPanelLLCond.getPSPanelLLCondId());
        pSPanelLLCondService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSPanelLLCondService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELLLCOND WHERE PPSPANELLLCONDID = ?", sqlParamList);
        super.onEmptyModelV2(pSPanelLLCond);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSPanelLLCondService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSPanelLLCond pSPanelLLCond, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSPanelLLCond pSPanelLLCond2 = new PSPanelLLCond();
        pSPanelLLCond2.set("PPSPANELLLCONDID", pSPanelLLCond.getPSPanelLLCondId());
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSPanelLLCondService.getModelV2Entity(pSPanelLLCond2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSPanelLLCond, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSPanelLLCond pSPanelLLCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSPanelLLCondService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSPanelLLCond pSPanelLLCond2 = new PSPanelLLCond();
                pSPanelLLCond2.setPPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
                pSPanelLLCond2.setPPSPanelLLCondName(pSPanelLLCond.getPSPanelLLCondName());
                pSPanelLLCond2.setOrderValue(n2 += 10);
                pSPanelLLCondService.compileModelV2(pSPanelLLCond2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSPanelLLCond pSPanelLLCond3 = new PSPanelLLCond();
                    pSPanelLLCond3.setPPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
                    pSPanelLLCond3.setPPSPanelLLCondName(pSPanelLLCond.getPSPanelLLCondName());
                    pSPanelLLCondService.compileModelV2(pSPanelLLCond3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSPanelLLCond, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSPanelLLCond pSPanelLLCond, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSPanelLLCond, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSPanelLLCond pSPanelLLCond, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSPanelLLCond, list);
    }
}

