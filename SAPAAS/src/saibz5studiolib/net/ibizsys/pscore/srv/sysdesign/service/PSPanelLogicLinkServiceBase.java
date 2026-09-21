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
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
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
import net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLogicLinkDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLogicLinkDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCond;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCondBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNodeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogicBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLogicLinkServiceBase
extends PSCoreSysServiceBase<PSPanelLogicLink> {
    private static final Log log = LogFactory.getLog(PSPanelLogicLinkServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSPanelLogicLinkDEModel pSPanelLogicLinkDEModel;
    private PSPanelLogicLinkDAO pSPanelLogicLinkDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService";
    }

    public PSPanelLogicLinkDEModel getPSPanelLogicLinkDEModel() {
        if (this.pSPanelLogicLinkDEModel == null) {
            try {
                this.pSPanelLogicLinkDEModel = (PSPanelLogicLinkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLogicLinkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLogicLinkDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPanelLogicLinkDEModel();
    }

    public PSPanelLogicLinkDAO getPSPanelLogicLinkDAO() {
        if (this.pSPanelLogicLinkDAO == null) {
            try {
                this.pSPanelLogicLinkDAO = (PSPanelLogicLinkDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLogicLinkDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLogicLinkDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPanelLogicLinkDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSPanelLogicLink)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSPanelLogicLink)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSPanelLogicLink)iEntity);
            return;
        }
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

    public void createWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSPanelLogicLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSPanelLogicLink, ACTION_CREATEWITHMODEL);
        final PSPanelLogicLink pSPanelLogicLink2 = pSPanelLogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSPanelLogicLinkServiceBase.this.getService(), PSPanelLogicLinkServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSPanelLogicLink2, null).getResult() != 1) {
                    PSPanelLogicLinkServiceBase.this.onCreateWithModel(pSPanelLogicLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSPanelLogicLink, null);
        }
    }

    protected void onCreateWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSPanelLogicLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSPanelLogicLink, ACTION_GETWITHMODEL);
        final PSPanelLogicLink pSPanelLogicLink2 = pSPanelLogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSPanelLogicLinkServiceBase.this.getService(), PSPanelLogicLinkServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSPanelLogicLink2, null).getResult() != 1) {
                    PSPanelLogicLinkServiceBase.this.onGetWithModel(pSPanelLogicLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSPanelLogicLink, null);
        }
    }

    protected void onGetWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSPanelLogicLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSPanelLogicLink, ACTION_UPDATEWITHMODEL);
        final PSPanelLogicLink pSPanelLogicLink2 = pSPanelLogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSPanelLogicLinkServiceBase.this.getService(), PSPanelLogicLinkServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSPanelLogicLink2, null).getResult() != 1) {
                    PSPanelLogicLinkServiceBase.this.onUpdateWithModel(pSPanelLogicLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSPanelLogicLink, null);
        }
    }

    protected void onUpdateWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSPanelLogicLink pSPanelLogicLink, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICLINK_PSPANELLOGICNODE_DSTPSPANELLOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService", (SessionFactory)this.getSessionFactory());
            PSPanelLogicNode pSPanelLogicNode = (PSPanelLogicNode)iService.getDEModel().createEntity();
            pSPanelLogicNode.set("PSPANELLOGICNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPanelLogicNode);
            } else {
                iService.get((IEntity)pSPanelLogicNode);
            }
            this.onFillParentInfo_DstPSPanelLogicNode(pSPanelLogicLink, pSPanelLogicNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICLINK_PSPANELLOGICNODE_SRCPSPANELLOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService", (SessionFactory)this.getSessionFactory());
            PSPanelLogicNode pSPanelLogicNode = (PSPanelLogicNode)iService.getDEModel().createEntity();
            pSPanelLogicNode.set("PSPANELLOGICNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPanelLogicNode);
            } else {
                iService.get((IEntity)pSPanelLogicNode);
            }
            this.onFillParentInfo_SrcPSPanelLogicNode(pSPanelLogicLink, pSPanelLogicNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICLINK_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)iService.getDEModel().createEntity();
            pSSysViewPanelLogic.set("PSSYSVIEWPANELLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelLogic);
            } else {
                iService.get((IEntity)pSSysViewPanelLogic);
            }
            this.onFillParentInfo_PSSysViewPanelLogic(pSPanelLogicLink, pSSysViewPanelLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPANELLOGICLINK_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicLink, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo((IEntity)pSPanelLogicLink, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSPanelLogicNode(PSPanelLogicLink pSPanelLogicLink, PSPanelLogicNode pSPanelLogicNode) throws Exception {
        pSPanelLogicLink.setDstPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
        pSPanelLogicLink.setDstPSPanelLogicNodeName(pSPanelLogicNode.getPSPanelLogicNodeName());
    }

    protected void onFillParentInfo_SrcPSPanelLogicNode(PSPanelLogicLink pSPanelLogicLink, PSPanelLogicNode pSPanelLogicNode) throws Exception {
        pSPanelLogicLink.setSrcPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
        pSPanelLogicLink.setSrcPSPanelLogicNodeName(pSPanelLogicNode.getPSPanelLogicNodeName());
    }

    protected void onFillParentInfo_PSSysViewPanelLogic(PSPanelLogicLink pSPanelLogicLink, PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSPanelLogicLink.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSPanelLogicLink.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
        if (pSSysViewPanelLogic.getPSSysViewPanel() != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicLink, pSSysViewPanelLogic.getPSSysViewPanel());
        }
    }

    protected void onFillParentInfo_PSSysViewPanel(PSPanelLogicLink pSPanelLogicLink, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSPanelLogicLink.setPSSystemId(pSSysViewPanel.getPSSystemId());
        pSPanelLogicLink.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSPanelLogicLink.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSPanelLogicLink, bl);
        this.onFillEntityFullInfo_DstPSPanelLogicNode(pSPanelLogicLink, bl);
        this.onFillEntityFullInfo_SrcPSPanelLogicNode(pSPanelLogicLink, bl);
        this.onFillEntityFullInfo_PSSysViewPanelLogic(pSPanelLogicLink, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLogicLink, bl);
    }

    protected void onFillEntityFullInfo_DstPSPanelLogicNode(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
        if (pSPanelLogicLink.isDstPSPanelLogicNodeIdDirty()) {
            if (pSPanelLogicLink.getDstPSPanelLogicNodeId() != null) {
                if (pSPanelLogicLink.getDstPSPanelLogicNodeId() == null || pSPanelLogicLink.getDstPSPanelLogicNodeName() == null) {
                    PSPanelLogicNode pSPanelLogicNode = pSPanelLogicLink.getDstPSPanelLogicNode();
                    pSPanelLogicLink.setDstPSPanelLogicNodeName(pSPanelLogicNode.getPSPanelLogicNodeName());
                }
            } else {
                pSPanelLogicLink.setDstPSPanelLogicNodeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SrcPSPanelLogicNode(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
        if (pSPanelLogicLink.isSrcPSPanelLogicNodeIdDirty()) {
            if (pSPanelLogicLink.getSrcPSPanelLogicNodeId() != null) {
                if (pSPanelLogicLink.getSrcPSPanelLogicNodeId() == null || pSPanelLogicLink.getSrcPSPanelLogicNodeName() == null) {
                    PSPanelLogicNode pSPanelLogicNode = pSPanelLogicLink.getSrcPSPanelLogicNode();
                    pSPanelLogicLink.setSrcPSPanelLogicNodeName(pSPanelLogicNode.getPSPanelLogicNodeName());
                }
            } else {
                pSPanelLogicLink.setSrcPSPanelLogicNodeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysViewPanelLogic(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
        if (pSPanelLogicLink.isPSSysViewPanelLogicIdDirty()) {
            if (pSPanelLogicLink.getPSSysViewPanelLogicId() != null) {
                PSSysViewPanelLogic pSSysViewPanelLogic;
                if (pSPanelLogicLink.getPSSysViewPanelLogicId() == null || pSPanelLogicLink.getPSSysViewPanelLogicName() == null) {
                    pSSysViewPanelLogic = pSPanelLogicLink.getPSSysViewPanelLogic();
                    pSPanelLogicLink.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSSysViewPanelLogic = pSPanelLogicLink.getPSSysViewPanelLogic()).getPSSysViewPanelId(), (Object)pSPanelLogicLink.getPSSysViewPanelId()) != 0L) {
                    pSPanelLogicLink.setPSSysViewPanelId(pSSysViewPanelLogic.getPSSysViewPanelId());
                    this.onFillEntityFullInfo_PSSysViewPanel(pSPanelLogicLink, bl);
                }
            } else {
                pSPanelLogicLink.setPSSysViewPanelLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPanelLogicLink, bl);
    }

    public ArrayList<PSPanelLogicLink> selectByDstPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase) throws Exception {
        return this.selectByDstPSPanelLogicNode(pSPanelLogicNodeBase, "", -1);
    }

    public ArrayList<PSPanelLogicLink> selectByDstPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string) throws Exception {
        return this.selectByDstPSPanelLogicNode(pSPanelLogicNodeBase, string, -1);
    }

    public ArrayList<PSPanelLogicLink> selectByDstPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSPANELLOGICNODEID", (Object)pSPanelLogicNodeBase.getPSPanelLogicNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSPanelLogicNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSPanelLogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicLink> selectTempByDstPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase) throws Exception {
        return this.selectTempByDstPSPanelLogicNode(pSPanelLogicNodeBase, "");
    }

    public ArrayList<PSPanelLogicLink> selectTempByDstPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSPANELLOGICNODEID", (Object)pSPanelLogicNodeBase.getPSPanelLogicNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSPanelLogicNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSPanelLogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicLink> selectBySrcPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase) throws Exception {
        return this.selectBySrcPSPanelLogicNode(pSPanelLogicNodeBase, "", -1);
    }

    public ArrayList<PSPanelLogicLink> selectBySrcPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string) throws Exception {
        return this.selectBySrcPSPanelLogicNode(pSPanelLogicNodeBase, string, -1);
    }

    public ArrayList<PSPanelLogicLink> selectBySrcPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSPANELLOGICNODEID", (Object)pSPanelLogicNodeBase.getPSPanelLogicNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSPanelLogicNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSPanelLogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicLink> selectTempBySrcPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase) throws Exception {
        return this.selectTempBySrcPSPanelLogicNode(pSPanelLogicNodeBase, "");
    }

    public ArrayList<PSPanelLogicLink> selectTempBySrcPSPanelLogicNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSPANELLOGICNODEID", (Object)pSPanelLogicNodeBase.getPSPanelLogicNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempBySrcPSPanelLogicNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempBySrcPSPanelLogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicLink> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectByPSSysViewPanelLogic(pSSysViewPanelLogicBase, "", -1);
    }

    public ArrayList<PSPanelLogicLink> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        return this.selectByPSSysViewPanelLogic(pSSysViewPanelLogicBase, string, -1);
    }

    public ArrayList<PSPanelLogicLink> selectByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLogicLink> selectTempByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase) throws Exception {
        return this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogicBase, "");
    }

    public ArrayList<PSPanelLogicLink> selectTempByPSSysViewPanelLogic(PSSysViewPanelLogicBase pSSysViewPanelLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELLOGICID", (Object)pSSysViewPanelLogicBase.getPSSysViewPanelLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPanelLogicLink> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSPanelLogicLink> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSPanelLogicLink> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSPanelLogicLink> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSPanelLogicLink> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    public void resetDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectByDstPSPanelLogicNode(pSPanelLogicNode);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            PSPanelLogicLink pSPanelLogicLink2 = (PSPanelLogicLink)this.getDEModel().createEntity();
            pSPanelLogicLink2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
            pSPanelLogicLink2.setDstPSPanelLogicNodeId(null);
            this.update(pSPanelLogicLink2);
        }
    }

    public void resetTempDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectTempByDstPSPanelLogicNode(pSPanelLogicNode);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            PSPanelLogicLink pSPanelLogicLink2 = (PSPanelLogicLink)this.getDEModel().createEntity();
            pSPanelLogicLink2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
            pSPanelLogicLink2.setDstPSPanelLogicNodeId(null);
            this.updateTemp((IEntity)pSPanelLogicLink2);
        }
    }

    public void removeByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        final PSPanelLogicNode pSPanelLogicNode2 = pSPanelLogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLinkServiceBase.this.onBeforeRemoveByDstPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLogicLinkServiceBase.this.internalRemoveByDstPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLogicLinkServiceBase.this.onAfterRemoveByDstPSPanelLogicNode(pSPanelLogicNode2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void internalRemoveByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectByDstPSPanelLogicNode(pSPanelLogicNode);
        this.onBeforeRemoveByDstPSPanelLogicNode(pSPanelLogicNode, arrayList);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            this.remove((IEntity)pSPanelLogicLink);
        }
        this.onAfterRemoveByDstPSPanelLogicNode(pSPanelLogicNode, arrayList);
    }

    protected void onAfterRemoveByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void onBeforeRemoveByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    public void resetSrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectBySrcPSPanelLogicNode(pSPanelLogicNode);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            PSPanelLogicLink pSPanelLogicLink2 = (PSPanelLogicLink)this.getDEModel().createEntity();
            pSPanelLogicLink2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
            pSPanelLogicLink2.setSrcPSPanelLogicNodeId(null);
            this.update(pSPanelLogicLink2);
        }
    }

    public void resetTempSrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectTempBySrcPSPanelLogicNode(pSPanelLogicNode);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            PSPanelLogicLink pSPanelLogicLink2 = (PSPanelLogicLink)this.getDEModel().createEntity();
            pSPanelLogicLink2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
            pSPanelLogicLink2.setSrcPSPanelLogicNodeId(null);
            this.updateTemp((IEntity)pSPanelLogicLink2);
        }
    }

    public void removeBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        final PSPanelLogicNode pSPanelLogicNode2 = pSPanelLogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLinkServiceBase.this.onBeforeRemoveBySrcPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLogicLinkServiceBase.this.internalRemoveBySrcPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLogicLinkServiceBase.this.onAfterRemoveBySrcPSPanelLogicNode(pSPanelLogicNode2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void internalRemoveBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectBySrcPSPanelLogicNode(pSPanelLogicNode);
        this.onBeforeRemoveBySrcPSPanelLogicNode(pSPanelLogicNode, arrayList);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            this.remove((IEntity)pSPanelLogicLink);
        }
        this.onAfterRemoveBySrcPSPanelLogicNode(pSPanelLogicNode, arrayList);
    }

    protected void onAfterRemoveBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    public void resetPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            PSPanelLogicLink pSPanelLogicLink2 = (PSPanelLogicLink)this.getDEModel().createEntity();
            pSPanelLogicLink2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
            pSPanelLogicLink2.setPSSysViewPanelLogicId(null);
            this.update(pSPanelLogicLink2);
        }
    }

    public void resetTempPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            PSPanelLogicLink pSPanelLogicLink2 = (PSPanelLogicLink)this.getDEModel().createEntity();
            pSPanelLogicLink2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
            pSPanelLogicLink2.setPSSysViewPanelLogicId(null);
            this.updateTemp((IEntity)pSPanelLogicLink2);
        }
    }

    public void removeByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLinkServiceBase.this.onBeforeRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicLinkServiceBase.this.internalRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicLinkServiceBase.this.onAfterRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            this.remove((IEntity)pSPanelLogicLink);
        }
        this.onAfterRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            PSPanelLogicLink pSPanelLogicLink2 = (PSPanelLogicLink)this.getDEModel().createEntity();
            pSPanelLogicLink2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
            pSPanelLogicLink2.setPSSysViewPanelId(null);
            this.update(pSPanelLogicLink2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            PSPanelLogicLink pSPanelLogicLink2 = (PSPanelLogicLink)this.getDEModel().createEntity();
            pSPanelLogicLink2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
            pSPanelLogicLink2.setPSSysViewPanelId(null);
            this.updateTemp((IEntity)pSPanelLogicLink2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLinkServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicLinkServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicLinkServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            this.remove((IEntity)pSPanelLogicLink);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        pSPanelLLCondService.testRemoveByPSPanelLogicLink(pSPanelLogicLink);
        pSPanelLLCondService.removeByPSPanelLogicLink(pSPanelLogicLink);
        super.onBeforeRemove(pSPanelLogicLink);
    }

    protected void onBeforeRemoveTemp(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        pSPanelLLCondService.removeTempByPSPanelLogicLink(pSPanelLogicLink);
        super.onBeforeRemoveTemp((IEntity)pSPanelLogicLink);
    }

    public void removeTempByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        final PSPanelLogicNode pSPanelLogicNode2 = pSPanelLogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLinkServiceBase.this.onBeforeRemoveTempByDstPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLogicLinkServiceBase.this.internalRemoveTempByDstPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLogicLinkServiceBase.this.onAfterRemoveTempByDstPSPanelLogicNode(pSPanelLogicNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void internalRemoveTempByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectTempByDstPSPanelLogicNode(pSPanelLogicNode);
        this.onBeforeRemoveTempByDstPSPanelLogicNode(pSPanelLogicNode, arrayList);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            this.removeTemp((IEntity)pSPanelLogicLink);
        }
        this.onAfterRemoveTempByDstPSPanelLogicNode(pSPanelLogicNode, arrayList);
    }

    protected void onAfterRemoveTempByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    public void removeTempBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        final PSPanelLogicNode pSPanelLogicNode2 = pSPanelLogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLinkServiceBase.this.onBeforeRemoveTempBySrcPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLogicLinkServiceBase.this.internalRemoveTempBySrcPSPanelLogicNode(pSPanelLogicNode2);
                PSPanelLogicLinkServiceBase.this.onAfterRemoveTempBySrcPSPanelLogicNode(pSPanelLogicNode2);
            }
        });
    }

    protected void onBeforeRemoveTempBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void internalRemoveTempBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectTempBySrcPSPanelLogicNode(pSPanelLogicNode);
        this.onBeforeRemoveTempBySrcPSPanelLogicNode(pSPanelLogicNode, arrayList);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            this.removeTemp((IEntity)pSPanelLogicLink);
        }
        this.onAfterRemoveTempBySrcPSPanelLogicNode(pSPanelLogicNode, arrayList);
    }

    protected void onAfterRemoveTempBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode) throws Exception {
    }

    protected void onBeforeRemoveTempBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempBySrcPSPanelLogicNode(PSPanelLogicNode pSPanelLogicNode, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLinkServiceBase.this.onBeforeRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicLinkServiceBase.this.internalRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                PSPanelLogicLinkServiceBase.this.onAfterRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        this.onBeforeRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            this.removeTemp((IEntity)pSPanelLogicLink);
        }
        this.onAfterRemoveTempByPSSysViewPanelLogic(pSSysViewPanelLogic, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelLogic(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLinkServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicLinkServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSPanelLogicLinkServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            this.removeTemp((IEntity)pSPanelLogicLink);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        this.getRelatedDataTempMajor_PSPanelLLCond(pSPanelLogicLink);
        super.getRelatedDataTempMajor((IEntity)pSPanelLogicLink);
    }

    protected void getRelatedDataTempMajor_PSPanelLLCond(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = null;
        String string = pSPanelLogicLink.getPSPanelLogicLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLLCondService.selectByPSPanelLogicLink(pSPanelLogicLink) : pSPanelLLCondService.selectTempByPSPanelLogicLink(pSPanelLogicLink);
        PSPanelLogicLinkServiceBase.sortHierarchyEntities(arrayList, (String)"PSPANELLLCONDID", (String)"PPSPANELLLCONDID");
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            pSPanelLLCondService.getTempMajor(pSPanelLLCond);
        }
    }

    protected void updateRelatedDataTempMajor(PSPanelLogicLink pSPanelLogicLink, PSPanelLogicLink pSPanelLogicLink2) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.updateRelatedDataTempMajor_removePSPanelLLCond(pSPanelLogicLink, pSPanelLogicLink2);
        this.updateRelatedDataTempMajor_updatePSPanelLLCond(pSPanelLogicLink, pSPanelLogicLink2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSPanelLogicLink, (IEntity)pSPanelLogicLink2);
    }

    protected ArrayList<PSPanelLLCond> updateRelatedDataTempMajor_removePSPanelLLCond(PSPanelLogicLink pSPanelLogicLink, PSPanelLogicLink pSPanelLogicLink2) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = pSPanelLLCondService.selectTempByPSPanelLogicLink(pSPanelLogicLink);
        ArrayList<PSPanelLLCond> arrayList2 = pSPanelLLCondService.selectByPSPanelLogicLink(pSPanelLogicLink2);
        HashMap<String, PSPanelLLCond> hashMap = new HashMap<String, PSPanelLLCond>();
        for (PSPanelLLCond pSPanelLLCond : arrayList2) {
            hashMap.put(pSPanelLLCond.getPSPanelLLCondId(), pSPanelLLCond);
        }
        PSPanelLogicLinkServiceBase.sortHierarchyEntities(arrayList, (String)"PSPANELLLCONDID", (String)"PPSPANELLLCONDID");
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            Object object = pSPanelLLCond.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLLCond pSPanelLLCond : hashMap.values()) {
            pSPanelLLCondService.remove((IEntity)pSPanelLLCond);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLLCond(PSPanelLogicLink pSPanelLogicLink, PSPanelLogicLink pSPanelLogicLink2, ArrayList<PSPanelLLCond> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            pSPanelLLCondService.updateTempMajor(pSPanelLLCond);
        }
    }

    protected void replaceParentInfo(PSPanelLogicLink pSPanelLogicLink, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPanelLogicLink, cloneSession);
        if (pSPanelLogicLink.getDstPSPanelLogicNodeId() != null && (iEntity = cloneSession.getEntity("PSPANELLOGICNODE", (Object)pSPanelLogicLink.getDstPSPanelLogicNodeId())) != null) {
            this.onFillParentInfo_DstPSPanelLogicNode(pSPanelLogicLink, (PSPanelLogicNode)iEntity);
        }
        if (pSPanelLogicLink.getSrcPSPanelLogicNodeId() != null && (iEntity = cloneSession.getEntity("PSPANELLOGICNODE", (Object)pSPanelLogicLink.getSrcPSPanelLogicNodeId())) != null) {
            this.onFillParentInfo_SrcPSPanelLogicNode(pSPanelLogicLink, (PSPanelLogicNode)iEntity);
        }
        if (pSPanelLogicLink.getPSSysViewPanelLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELLOGIC", (Object)pSPanelLogicLink.getPSSysViewPanelLogicId())) != null) {
            this.onFillParentInfo_PSSysViewPanelLogic(pSPanelLogicLink, (PSSysViewPanelLogic)iEntity);
        }
        if (pSPanelLogicLink.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSPanelLogicLink.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSPanelLogicLink, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPanelLogicLink, bl);
    }

    protected void onCheckEntity(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CallbackName(bl, pSPanelLogicLink, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondModel(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultLink(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstEndPoint(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSPanelLogicNodeId(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSPanelLogicNodeName(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkInfo(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkType(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicLinkId(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPanelLogicLinkName(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelLogicId(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelLogicName(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcEndPoint(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSPanelLogicNodeId(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSPanelLogicNodeName(bl, pSPanelLogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPanelLogicLink, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CallbackName(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isCallbackNameDirty() : !pSPanelLogicLink.isCallbackNameDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getCallbackName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CallbackName_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALLBACKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondModel(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isCondModelDirty() : !pSPanelLogicLink.isCondModelDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getCondModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondModel_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultLink(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isDefaultLinkDirty() && !bl2 : !pSPanelLogicLink.isDefaultLinkDirty()) {
            return null;
        }
        Integer n = pSPanelLogicLink.getDefaultLink();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTLINK");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultLink_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTLINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstEndPoint(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isDstEndPointDirty() : !pSPanelLogicLink.isDstEndPointDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getDstEndPoint();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstEndPoint_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTENDPOINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSPanelLogicNodeId(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isDstPSPanelLogicNodeIdDirty() && !bl2 : !pSPanelLogicLink.isDstPSPanelLogicNodeIdDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getDstPSPanelLogicNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSPANELLOGICNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSPanelLogicNodeId_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSPANELLOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSPanelLogicNodeName(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isDstPSPanelLogicNodeNameDirty() : !pSPanelLogicLink.isDstPSPanelLogicNodeNameDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getDstPSPanelLogicNodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSPanelLogicNodeName_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSPANELLOGICNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkInfo(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isLinkInfoDirty() : !pSPanelLogicLink.isLinkInfoDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getLinkInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkInfo_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkType(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isLinkTypeDirty() : !pSPanelLogicLink.isLinkTypeDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getLinkType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkType_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isMemoDirty() : !pSPanelLogicLink.isMemoDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPanelLogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isOrderValueDirty() && !bl2 : !pSPanelLogicLink.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSPanelLogicLink.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSPanelLogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPanelLogicLinkId(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isPSPanelLogicLinkIdDirty() && !bl2 : !pSPanelLogicLink.isPSPanelLogicLinkIdDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getPSPanelLogicLinkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICLINKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicLinkId_Default((IEntity)pSPanelLogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPanelLogicLinkName(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isPSPanelLogicLinkNameDirty() && !bl2 : !pSPanelLogicLink.isPSPanelLogicLinkNameDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getPSPanelLogicLinkName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPANELLOGICLINKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPanelLogicLinkName_Default((IEntity)pSPanelLogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isPSSysViewPanelIdDirty() && !bl2 : !pSPanelLogicLink.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getPSSysViewPanelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSPanelLogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelLogicId(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isPSSysViewPanelLogicIdDirty() && !bl2 : !pSPanelLogicLink.isPSSysViewPanelLogicIdDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getPSSysViewPanelLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelLogicId_Default((IEntity)pSPanelLogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelLogicName(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isPSSysViewPanelLogicNameDirty() : !pSPanelLogicLink.isPSSysViewPanelLogicNameDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getPSSysViewPanelLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelLogicName_Default((IEntity)pSPanelLogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_SrcEndPoint(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isSrcEndPointDirty() : !pSPanelLogicLink.isSrcEndPointDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getSrcEndPoint();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcEndPoint_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCENDPOINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSPanelLogicNodeId(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isSrcPSPanelLogicNodeIdDirty() && !bl2 : !pSPanelLogicLink.isSrcPSPanelLogicNodeIdDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getSrcPSPanelLogicNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSPANELLOGICNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSPanelLogicNodeId_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSPANELLOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSPanelLogicNodeName(boolean bl, PSPanelLogicLink pSPanelLogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPanelLogicLink.isSrcPSPanelLogicNodeNameDirty() : !pSPanelLogicLink.isSrcPSPanelLogicNodeNameDirty()) {
            return null;
        }
        String string = pSPanelLogicLink.getSrcPSPanelLogicNodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSPanelLogicNodeName_Default((IEntity)pSPanelLogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSPANELLOGICNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPanelLogicLink, bl);
    }

    protected void onSyncIndexEntities(PSPanelLogicLink pSPanelLogicLink, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPanelLogicLink, bl);
    }

    public Object getDataContextValue(PSPanelLogicLink pSPanelLogicLink, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPanelLogicLink, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysViewPanelLogic pSSysViewPanelLogic = pSPanelLogicLink.getPSSysViewPanelLogic();
        if (pSSysViewPanelLogic != null && pSSysViewPanelLogic.contains(string)) {
            return pSSysViewPanelLogic.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPanelLogicLink pSPanelLogicLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPanelLogicLink, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CALLBACKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CallbackName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTLINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTENDPOINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstEndPoint_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSPANELLOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSPanelLogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSPANELLOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSPanelLogicNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCENDPOINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcEndPoint_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSPANELLOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSPanelLogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSPANELLOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSPanelLogicNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CallbackName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALLBACKNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_DefaultLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DstEndPoint_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTENDPOINT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSPanelLogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSPANELLOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSPanelLogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSPANELLOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKINFO", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    protected String onTestValueRule_SrcEndPoint_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCENDPOINT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSPanelLogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSPANELLOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSPanelLogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSPANELLOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPanelLogicLink pSPanelLogicLink) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPanelLogicLink)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        super.onUpdateParent((IEntity)pSPanelLogicLink);
    }

    @Override
    protected void exportCurXmlModel(PSPanelLogicLink pSPanelLogicLink, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPANELLOGICLINK");
        if (!bl) {
            pSPanelLogicLink.setCreateDate(null);
            pSPanelLogicLink.setCreateMan(null);
            pSPanelLogicLink.setPSPanelLogicLinkId(null);
            pSPanelLogicLink.setUpdateDate(null);
            pSPanelLogicLink.setUpdateMan(null);
            pSPanelLogicLink.setDstPSPanelLogicNodeId(null);
            pSPanelLogicLink.setSrcPSPanelLogicNodeId(null);
            pSPanelLogicLink.setPSSysViewPanelLogicId(null);
            pSPanelLogicLink.setPSSysViewPanelLogicName(null);
            pSPanelLogicLink.setPSSystemId(null);
            pSPanelLogicLink.setPSSysViewPanelId(null);
            pSPanelLogicLink.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSPanelLogicLink, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSPanelLogicLink pSPanelLogicLink, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSPanelLLCond(pSPanelLogicLink, xmlNode);
        super.onExportRelatedXmlModel(pSPanelLogicLink, xmlNode);
    }

    protected void exportRelatedXmlModel_PSPanelLLCond(PSPanelLogicLink pSPanelLogicLink, XmlNode xmlNode) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = null;
        String string = pSPanelLogicLink.getPSPanelLogicLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLLCondService.selectByPSPanelLogicLink(pSPanelLogicLink, "ORDER BY ORDERVALUE ASC") : pSPanelLLCondService.selectTempByPSPanelLogicLink(pSPanelLogicLink, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLLCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLLCond pSPanelLLCond : arrayList) {
                if (pSPanelLLCond.getPPSPanelLLCondId() != null) continue;
                pSPanelLLCond.set("ORDERVALUE", null);
                pSPanelLLCondService.exportXmlModel(pSPanelLLCond, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSPanelLogicLink pSPanelLogicLink, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSPANELLLCONDS");
        this.importRelatedXmlModel_PSPanelLLCond(pSPanelLogicLink, xmlNode2);
        super.onImportRelatedXmlModel(pSPanelLogicLink, xmlNode);
    }

    protected void importRelatedXmlModel_PSPanelLLCond(PSPanelLogicLink pSPanelLogicLink, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSPanelLogicLink.getPSPanelLogicLinkId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLLCondService.removeByPSPanelLogicLink(pSPanelLogicLink);
        } else {
            pSPanelLLCondService.removeTempByPSPanelLogicLink(pSPanelLogicLink);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLLCond pSPanelLLCond = new PSPanelLLCond();
                pSPanelLLCond.setOrderValue(n);
                n += 100;
                pSPanelLLCondService.fillParentInfo((IEntity)pSPanelLLCond, "DER1N", "DER1N_PSPANELLLCOND_PSPANELLOGICLINK_PSPANELLOGICLINKID", pSPanelLogicLink.getPSPanelLogicLinkId());
                pSPanelLLCondService.importXmlModel(pSPanelLLCond, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSPanelLogicLink pSPanelLogicLink, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSPanelLogicLink, string);
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
            return "DER1N_PSPANELLOGICLINK_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID";
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
    public String getModelV2Tag(PSPanelLogicLink pSPanelLogicLink) {
        return super.getModelV2Tag(pSPanelLogicLink);
    }

    @Override
    public boolean setModelV2Tag(PSPanelLogicLink pSPanelLogicLink, String string) {
        return super.setModelV2Tag(pSPanelLogicLink, string);
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
    public boolean getModelV2Entity(PSPanelLogicLink pSPanelLogicLink, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSPanelLogicLink.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSPanelLogicLink, true);
        return super.getModelV2Entity(pSPanelLogicLink, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSPanelLogicLink pSPanelLogicLink, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSPanelLogicLink, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSPANELLLCOND_PSPANELLOGICLINK_PSPANELLOGICLINKID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSPanelLogicLink pSPanelLogicLink, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSPanelLogicLink, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSPanelLogicLink pSPanelLogicLink, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELLLCOND_PSPANELLOGICLINK_PSPANELLOGICLINKID")) {
            Object object;
            PSPanelLLCond pSPanelLLCond2;
            Object object2;
            Object object3;
            Object object4;
            PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSPanelLLCond> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSPANELLOGICLINK#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELLLCOND", (Object)pSPanelLogicLink.getPSPanelLogicLinkId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSPanelLLCond2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSPanelLLCond2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSPanelLLCond>();
                object4 = pSPanelLLCondService.selectByPSPanelLogicLink(pSPanelLogicLink);
                object3 = StringHelper.format((String)"PSPANELLOGICLINK#%1$s", (Object)pSPanelLogicLink.getPSPanelLogicLinkId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSPanelLLCond2 = object2.next();
                    object = pSPanelLLCondService.getModelV2ResScope((IEntity)pSPanelLLCond2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSPanelLLCond)PSModelV2Helper.toJSONObject((IEntity)pSPanelLLCond2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSPanelLLCondService.getModelV2Name(false);
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
                        if (objectNode.has("pspanelllcondname")) {
                            string = objectNode.get("pspanelllcondname").asText();
                        }
                        if (objectNode2.has("pspanelllcondname")) {
                            string2 = objectNode2.get("pspanelllcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSPanelLLCond pSPanelLLCond2 : arrayList) {
                    object = new PSPanelLLCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSPanelLLCond2, false);
                    ((PSPanelLLCondBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSPanelLLCondService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSPanelLogicLink, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = pSPanelLLCondService.selectByPSPanelLogicLink(pSPanelLogicLink);
        String string = StringHelper.format((String)"PSPANELLOGICLINK#%1$s", (Object)pSPanelLogicLink.getPSPanelLogicLinkId());
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            String string2 = pSPanelLLCondService.getModelV2ResScope((IEntity)pSPanelLLCond);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSPanelLLCondService.emptyModelV2(pSPanelLLCond);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSPanelLogicLink.getPSPanelLogicLinkId());
        pSPanelLLCondService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSPanelLLCondService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELLLCOND WHERE PSPANELLOGICLINKID = ?", sqlParamList);
        super.onEmptyModelV2(pSPanelLogicLink);
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
    protected IEntity onGetRelatedModelV2Entity(PSPanelLogicLink pSPanelLogicLink, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSPanelLLCond pSPanelLLCond = new PSPanelLLCond();
        pSPanelLLCond.set("PSPANELLOGICLINKID", pSPanelLogicLink.getPSPanelLogicLinkId());
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSPanelLLCondService.getModelV2Entity(pSPanelLLCond, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSPanelLogicLink, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSPanelLogicLink pSPanelLogicLink, ObjectNode objectNode, String string, String string2, int n) throws Exception {
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
                PSPanelLLCond pSPanelLLCond = new PSPanelLLCond();
                pSPanelLLCond.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
                pSPanelLLCond.setPSPanelLogicLinkName(pSPanelLogicLink.getPSPanelLogicLinkName());
                pSPanelLLCond.setPSSysViewPanelLogicId(pSPanelLogicLink.getPSSysViewPanelLogicId());
                pSPanelLLCond.setOrderValue(n2 += 10);
                pSPanelLLCondService.compileModelV2(pSPanelLLCond, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSPanelLLCond pSPanelLLCond = new PSPanelLLCond();
                    pSPanelLLCond.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
                    pSPanelLLCond.setPSPanelLogicLinkName(pSPanelLogicLink.getPSPanelLogicLinkName());
                    pSPanelLLCond.setPSSysViewPanelLogicId(pSPanelLogicLink.getPSSysViewPanelLogicId());
                    pSPanelLLCondService.compileModelV2(pSPanelLLCond, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSPanelLogicLink, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSPanelLogicLink pSPanelLogicLink, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSPANELLLCOND_PSPANELLOGICLINK_PSPANELLOGICLINKID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSPanelLLConds(pSPanelLogicLink, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSPanelLogicLink, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSPanelLLConds(PSPanelLogicLink pSPanelLogicLink, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSPANELLLCOND", true), (boolean)false) == 0) {
            PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
            PSPanelLLCond pSPanelLLCond = new PSPanelLLCond();
            pSPanelLLCond.setPSPanelLLCondId(pSMOSFile.getPSModelId());
            if (!pSPanelLLCondService.get((IEntity)pSPanelLLCond, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSPanelLLCond.getPSPanelLogicLinkId(), (String)pSPanelLogicLink.getPSPanelLogicLinkId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSPanelLLCondService.exportModelV2(pSPanelLLCond);
            pSPanelLLCond.reset();
            if (!pSPanelLLCondService.setModelV2ResScope((IEntity)pSPanelLLCond, "PSPANELLOGICLINK", pSPanelLogicLink.getPSPanelLogicLinkId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSPanelLLCondService.importModelV2(pSPanelLLCond, objectNode);
            SessionFactoryManager.commit();
            return pSPanelLLCondService.getFile((IEntity)pSPanelLLCond);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSPanelLogicLink pSPanelLogicLink, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSPanelLLConds(pSPanelLogicLink, list);
        super.onFillPasteHelps(pSPanelLogicLink, list);
    }

    protected void onFillPasteHelps_PSPanelLLConds(PSPanelLogicLink pSPanelLogicLink, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSPANELLLCOND");
        pSHelpSection.setSectionParam2("DER1N_PSPANELLLCOND_PSPANELLOGICLINK_PSPANELLOGICLINKID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u903b\u8f91\u8fde\u63a5]\u7684[\u9762\u677f\u903b\u8f91\u8fde\u63a5\u6761\u4ef6]");
        list.add(pSHelpSection);
    }
}

