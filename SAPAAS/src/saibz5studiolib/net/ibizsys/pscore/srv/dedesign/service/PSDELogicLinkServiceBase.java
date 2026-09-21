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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDELogicLinkDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicLinkDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCondBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicLink;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParamBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELogicLinkServiceBase
extends PSCoreSysServiceBase<PSDELogicLink> {
    private static final Log log = LogFactory.getLog(PSDELogicLinkServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDELogicLinkDEModel pSDELogicLinkDEModel;
    private PSDELogicLinkDAO pSDELogicLinkDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService";
    }

    public PSDELogicLinkDEModel getPSDELogicLinkDEModel() {
        if (this.pSDELogicLinkDEModel == null) {
            try {
                this.pSDELogicLinkDEModel = (PSDELogicLinkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicLinkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELogicLinkDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDELogicLinkDEModel();
    }

    public PSDELogicLinkDAO getPSDELogicLinkDAO() {
        if (this.pSDELogicLinkDAO == null) {
            try {
                this.pSDELogicLinkDAO = (PSDELogicLinkDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDELogicLinkDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELogicLinkDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDELogicLinkDAO();
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
            this.createWithModel((PSDELogicLink)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDELogicLink)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDELogicLink)iEntity);
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

    public void createWithModel(PSDELogicLink pSDELogicLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSDELogicLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDELogicLink, ACTION_CREATEWITHMODEL);
        final PSDELogicLink pSDELogicLink2 = pSDELogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDELogicLinkServiceBase.this.getService(), PSDELogicLinkServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSDELogicLink2, null).getResult() != 1) {
                    PSDELogicLinkServiceBase.this.onCreateWithModel(pSDELogicLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSDELogicLink, null);
        }
    }

    protected void onCreateWithModel(PSDELogicLink pSDELogicLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getWithModel(PSDELogicLink pSDELogicLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSDELogicLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDELogicLink, ACTION_GETWITHMODEL);
        final PSDELogicLink pSDELogicLink2 = pSDELogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDELogicLinkServiceBase.this.getService(), PSDELogicLinkServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSDELogicLink2, null).getResult() != 1) {
                    PSDELogicLinkServiceBase.this.onGetWithModel(pSDELogicLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSDELogicLink, null);
        }
    }

    protected void onGetWithModel(PSDELogicLink pSDELogicLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateWithModel(PSDELogicLink pSDELogicLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSDELogicLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDELogicLink, ACTION_UPDATEWITHMODEL);
        final PSDELogicLink pSDELogicLink2 = pSDELogicLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDELogicLinkServiceBase.this.getService(), PSDELogicLinkServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSDELogicLink2, null).getResult() != 1) {
                    PSDELogicLinkServiceBase.this.onUpdateWithModel(pSDELogicLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSDELogicLink, null);
        }
    }

    protected void onUpdateWithModel(PSDELogicLink pSDELogicLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDELogicLink pSDELogicLink, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICLINK_PSDELOGICNODE_DSTPSDELOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService", (SessionFactory)this.getSessionFactory());
            PSDELogicNode pSDELogicNode = (PSDELogicNode)iService.getDEModel().createEntity();
            pSDELogicNode.set("PSDELOGICNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicNode);
            } else {
                iService.get((IEntity)pSDELogicNode);
            }
            this.onFillParentInfo_DstPSDELogicNode(pSDELogicLink, pSDELogicNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICLINK_PSDELOGICNODE_SRCPSDELOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService", (SessionFactory)this.getSessionFactory());
            PSDELogicNode pSDELogicNode = (PSDELogicNode)iService.getDEModel().createEntity();
            pSDELogicNode.set("PSDELOGICNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicNode);
            } else {
                iService.get((IEntity)pSDELogicNode);
            }
            this.onFillParentInfo_SrcPSDELogicNode(pSDELogicLink, pSDELogicNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICLINK_PSDELOGICPARAM_DSTPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicParam);
            } else {
                iService.get((IEntity)pSDELogicParam);
            }
            this.onFillParentInfo_DstPSDLParam(pSDELogicLink, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICLINK_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDELogicLink, pSDELogic);
            return;
        }
        super.onFillParentInfo((IEntity)pSDELogicLink, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDELOGICLINK_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", string2);
            return this.onSyncDER1NData_PSDELogic(pSDELogic, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDELogicNode(PSDELogicLink pSDELogicLink, PSDELogicNode pSDELogicNode) throws Exception {
        pSDELogicLink.setDstPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
        pSDELogicLink.setDstPSDELogicNodeName(pSDELogicNode.getPSDELogicNodeName());
    }

    protected void onFillParentInfo_SrcPSDELogicNode(PSDELogicLink pSDELogicLink, PSDELogicNode pSDELogicNode) throws Exception {
        pSDELogicLink.setSrcPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
        pSDELogicLink.setSrcPSDELogicNodeName(pSDELogicNode.getPSDELogicNodeName());
    }

    protected void onFillParentInfo_DstPSDLParam(PSDELogicLink pSDELogicLink, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELogicLink.setDstPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELogicLink.setDstPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_PSDELogic(PSDELogicLink pSDELogicLink, PSDELogic pSDELogic) throws Exception {
        pSDELogicLink.setPSDEId(pSDELogic.getPSDEId());
        pSDELogicLink.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDELogicLink.setPSDELogicName(pSDELogic.getPSDELogicName());
        pSDELogicLink.setPSSystemId(pSDELogic.getPSSystemId());
    }

    protected String onSyncDER1NData_PSDELogic(PSDELogic pSDELogic, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDELogic(pSDELogic);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDELogicLink> arrayList = this.selectByPSDELogic(pSDELogic);
            for (PSDELogicLink pSDELogicLink : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDELogicLink, (String)"PSDELOGICLINKID", (String)""))) continue;
                this.remove((IEntity)pSDELogicLink);
            }
        }
        return null;
    }

    protected void onFillEntityFullInfo(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDELogicLink, bl);
        this.onFillEntityFullInfo_DstPSDELogicNode(pSDELogicLink, bl);
        this.onFillEntityFullInfo_SrcPSDELogicNode(pSDELogicLink, bl);
        this.onFillEntityFullInfo_DstPSDLParam(pSDELogicLink, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDELogicLink, bl);
    }

    protected void onFillEntityFullInfo_DstPSDELogicNode(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SrcPSDELogicNode(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDLParam(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
        if (pSDELogicLink.isDstPSDLParamIdDirty()) {
            if (pSDELogicLink.getDstPSDLParamId() != null) {
                if (pSDELogicLink.getDstPSDLParamId() == null || pSDELogicLink.getDstPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELogicLink.getDstPSDLParam();
                    pSDELogicLink.setDstPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELogicLink.setDstPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
        if (pSDELogicLink.isPSDELogicIdDirty()) {
            if (pSDELogicLink.getPSDELogicId() != null) {
                if (pSDELogicLink.getPSDEId() == null || pSDELogicLink.getPSDELogicId() == null || pSDELogicLink.getPSSystemId() == null) {
                    PSDELogic pSDELogic = pSDELogicLink.getPSDELogic();
                    pSDELogicLink.setPSDEId(pSDELogic.getPSDEId());
                    pSDELogicLink.setPSDELogicName(pSDELogic.getPSDELogicName());
                    pSDELogicLink.setPSSystemId(pSDELogic.getPSSystemId());
                }
            } else {
                pSDELogicLink.setPSDEId(null);
                pSDELogicLink.setPSDELogicName(null);
                pSDELogicLink.setPSSystemId(null);
            }
        }
    }

    protected void onWriteBackParent(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDELogicLink, bl);
    }

    public ArrayList<PSDELogicLink> selectByDstPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase) throws Exception {
        return this.selectByDstPSDELogicNode(pSDELogicNodeBase, "", -1);
    }

    public ArrayList<PSDELogicLink> selectByDstPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string) throws Exception {
        return this.selectByDstPSDELogicNode(pSDELogicNodeBase, string, -1);
    }

    public ArrayList<PSDELogicLink> selectByDstPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDELOGICNODEID", (Object)pSDELogicNodeBase.getPSDELogicNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDELogicNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDELogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicLink> selectTempByDstPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase) throws Exception {
        return this.selectTempByDstPSDELogicNode(pSDELogicNodeBase, "");
    }

    public ArrayList<PSDELogicLink> selectTempByDstPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDELOGICNODEID", (Object)pSDELogicNodeBase.getPSDELogicNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSDELogicNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSDELogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicLink> selectBySrcPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase) throws Exception {
        return this.selectBySrcPSDELogicNode(pSDELogicNodeBase, "", -1);
    }

    public ArrayList<PSDELogicLink> selectBySrcPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string) throws Exception {
        return this.selectBySrcPSDELogicNode(pSDELogicNodeBase, string, -1);
    }

    public ArrayList<PSDELogicLink> selectBySrcPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDELOGICNODEID", (Object)pSDELogicNodeBase.getPSDELogicNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDELogicNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDELogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicLink> selectTempBySrcPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase) throws Exception {
        return this.selectTempBySrcPSDELogicNode(pSDELogicNodeBase, "");
    }

    public ArrayList<PSDELogicLink> selectTempBySrcPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDELOGICNODEID", (Object)pSDELogicNodeBase.getPSDELogicNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempBySrcPSDELogicNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempBySrcPSDELogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicLink> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectByDstPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELogicLink> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectByDstPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELogicLink> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicLink> selectTempByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempByDstPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELogicLink> selectTempByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicLink> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDELogicLink> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDELogicLink> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDELogicLink> selectTempByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectTempByPSDELogic(pSDELogicBase, "");
    }

    public ArrayList<PSDELogicLink> selectTempByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDELogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    public void resetDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectByDstPSDELogicNode(pSDELogicNode);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            PSDELogicLink pSDELogicLink2 = (PSDELogicLink)this.getDEModel().createEntity();
            pSDELogicLink2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
            pSDELogicLink2.setDstPSDELogicNodeId(null);
            this.update(pSDELogicLink2);
        }
    }

    public void resetTempDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectTempByDstPSDELogicNode(pSDELogicNode);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            PSDELogicLink pSDELogicLink2 = (PSDELogicLink)this.getDEModel().createEntity();
            pSDELogicLink2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
            pSDELogicLink2.setDstPSDELogicNodeId(null);
            this.updateTemp((IEntity)pSDELogicLink2);
        }
    }

    public void removeByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        final PSDELogicNode pSDELogicNode2 = pSDELogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLinkServiceBase.this.onBeforeRemoveByDstPSDELogicNode(pSDELogicNode2);
                PSDELogicLinkServiceBase.this.internalRemoveByDstPSDELogicNode(pSDELogicNode2);
                PSDELogicLinkServiceBase.this.onAfterRemoveByDstPSDELogicNode(pSDELogicNode2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void internalRemoveByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectByDstPSDELogicNode(pSDELogicNode);
        this.onBeforeRemoveByDstPSDELogicNode(pSDELogicNode, arrayList);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            this.remove((IEntity)pSDELogicLink);
        }
        this.onAfterRemoveByDstPSDELogicNode(pSDELogicNode, arrayList);
    }

    protected void onAfterRemoveByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    public void resetSrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectBySrcPSDELogicNode(pSDELogicNode);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            PSDELogicLink pSDELogicLink2 = (PSDELogicLink)this.getDEModel().createEntity();
            pSDELogicLink2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
            pSDELogicLink2.setSrcPSDELogicNodeId(null);
            this.update(pSDELogicLink2);
        }
    }

    public void resetTempSrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectTempBySrcPSDELogicNode(pSDELogicNode);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            PSDELogicLink pSDELogicLink2 = (PSDELogicLink)this.getDEModel().createEntity();
            pSDELogicLink2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
            pSDELogicLink2.setSrcPSDELogicNodeId(null);
            this.updateTemp((IEntity)pSDELogicLink2);
        }
    }

    public void removeBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        final PSDELogicNode pSDELogicNode2 = pSDELogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLinkServiceBase.this.onBeforeRemoveBySrcPSDELogicNode(pSDELogicNode2);
                PSDELogicLinkServiceBase.this.internalRemoveBySrcPSDELogicNode(pSDELogicNode2);
                PSDELogicLinkServiceBase.this.onAfterRemoveBySrcPSDELogicNode(pSDELogicNode2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void internalRemoveBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectBySrcPSDELogicNode(pSDELogicNode);
        this.onBeforeRemoveBySrcPSDELogicNode(pSDELogicNode, arrayList);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            this.remove((IEntity)pSDELogicLink);
        }
        this.onAfterRemoveBySrcPSDELogicNode(pSDELogicNode, arrayList);
    }

    protected void onAfterRemoveBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectByDstPSDLParam(pSDELogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICLINK_PSDELOGICPARAM_DSTPSDLPARAMID", "", iDataEntityModel.getName(), "PSDELOGICLINK", iDataEntityModel.getDataInfo((IEntity)pSDELogicParam), arrayList.get(0)));
        }
    }

    public void resetDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectByDstPSDLParam(pSDELogicParam);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            PSDELogicLink pSDELogicLink2 = (PSDELogicLink)this.getDEModel().createEntity();
            pSDELogicLink2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
            pSDELogicLink2.setDstPSDLParamId(null);
            this.update(pSDELogicLink2);
        }
    }

    public void resetTempDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectTempByDstPSDLParam(pSDELogicParam);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            PSDELogicLink pSDELogicLink2 = (PSDELogicLink)this.getDEModel().createEntity();
            pSDELogicLink2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
            pSDELogicLink2.setDstPSDLParamId(null);
            this.updateTemp((IEntity)pSDELogicLink2);
        }
    }

    public void removeByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLinkServiceBase.this.onBeforeRemoveByDstPSDLParam(pSDELogicParam2);
                PSDELogicLinkServiceBase.this.internalRemoveByDstPSDLParam(pSDELogicParam2);
                PSDELogicLinkServiceBase.this.onAfterRemoveByDstPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectByDstPSDLParam(pSDELogicParam);
        this.onBeforeRemoveByDstPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            this.remove((IEntity)pSDELogicLink);
        }
        this.onAfterRemoveByDstPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            PSDELogicLink pSDELogicLink2 = (PSDELogicLink)this.getDEModel().createEntity();
            pSDELogicLink2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
            pSDELogicLink2.setPSDELogicId(null);
            this.update(pSDELogicLink2);
        }
    }

    public void resetTempPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectTempByPSDELogic(pSDELogic);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            PSDELogicLink pSDELogicLink2 = (PSDELogicLink)this.getDEModel().createEntity();
            pSDELogicLink2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
            pSDELogicLink2.setPSDELogicId(null);
            this.updateTemp((IEntity)pSDELogicLink2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLinkServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDELogicLinkServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDELogicLinkServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            this.remove((IEntity)pSDELogicLink);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDELogicLink pSDELogicLink) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        pSDELLCondService.testRemoveByPSDELogicLink(pSDELogicLink);
        pSDELLCondService.removeByPSDELogicLink(pSDELogicLink);
        super.onBeforeRemove(pSDELogicLink);
    }

    protected void onBeforeRemoveTemp(PSDELogicLink pSDELogicLink) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        pSDELLCondService.removeTempByPSDELogicLink(pSDELogicLink);
        super.onBeforeRemoveTemp((IEntity)pSDELogicLink);
    }

    public void removeTempByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        final PSDELogicNode pSDELogicNode2 = pSDELogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLinkServiceBase.this.onBeforeRemoveTempByDstPSDELogicNode(pSDELogicNode2);
                PSDELogicLinkServiceBase.this.internalRemoveTempByDstPSDELogicNode(pSDELogicNode2);
                PSDELogicLinkServiceBase.this.onAfterRemoveTempByDstPSDELogicNode(pSDELogicNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void internalRemoveTempByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectTempByDstPSDELogicNode(pSDELogicNode);
        this.onBeforeRemoveTempByDstPSDELogicNode(pSDELogicNode, arrayList);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            this.removeTemp((IEntity)pSDELogicLink);
        }
        this.onAfterRemoveTempByDstPSDELogicNode(pSDELogicNode, arrayList);
    }

    protected void onAfterRemoveTempByDstPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    public void removeTempBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        final PSDELogicNode pSDELogicNode2 = pSDELogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLinkServiceBase.this.onBeforeRemoveTempBySrcPSDELogicNode(pSDELogicNode2);
                PSDELogicLinkServiceBase.this.internalRemoveTempBySrcPSDELogicNode(pSDELogicNode2);
                PSDELogicLinkServiceBase.this.onAfterRemoveTempBySrcPSDELogicNode(pSDELogicNode2);
            }
        });
    }

    protected void onBeforeRemoveTempBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void internalRemoveTempBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectTempBySrcPSDELogicNode(pSDELogicNode);
        this.onBeforeRemoveTempBySrcPSDELogicNode(pSDELogicNode, arrayList);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            this.removeTemp((IEntity)pSDELogicLink);
        }
        this.onAfterRemoveTempBySrcPSDELogicNode(pSDELogicNode, arrayList);
    }

    protected void onAfterRemoveTempBySrcPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void onBeforeRemoveTempBySrcPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempBySrcPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    public void removeTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLinkServiceBase.this.onBeforeRemoveTempByDstPSDLParam(pSDELogicParam2);
                PSDELogicLinkServiceBase.this.internalRemoveTempByDstPSDLParam(pSDELogicParam2);
                PSDELogicLinkServiceBase.this.onAfterRemoveTempByDstPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectTempByDstPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempByDstPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            this.removeTemp((IEntity)pSDELogicLink);
        }
        this.onAfterRemoveTempByDstPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    public void removeTempByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLinkServiceBase.this.onBeforeRemoveTempByPSDELogic(pSDELogic2);
                PSDELogicLinkServiceBase.this.internalRemoveTempByPSDELogic(pSDELogic2);
                PSDELogicLinkServiceBase.this.onAfterRemoveTempByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveTempByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicLink> arrayList = this.selectTempByPSDELogic(pSDELogic);
        this.onBeforeRemoveTempByPSDELogic(pSDELogic, arrayList);
        for (PSDELogicLink pSDELogicLink : arrayList) {
            this.removeTemp((IEntity)pSDELogicLink);
        }
        this.onAfterRemoveTempByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveTempByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicLink> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDELogicLink pSDELogicLink) throws Exception {
        this.getRelatedDataTempMajor_PSDELLCond(pSDELogicLink);
        super.getRelatedDataTempMajor((IEntity)pSDELogicLink);
    }

    protected void getRelatedDataTempMajor_PSDELLCond(PSDELogicLink pSDELogicLink) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELLCond> arrayList = null;
        String string = pSDELogicLink.getPSDELogicLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDELLCondService.selectByPSDELogicLink(pSDELogicLink) : pSDELLCondService.selectTempByPSDELogicLink(pSDELogicLink);
        PSDELogicLinkServiceBase.sortHierarchyEntities(arrayList, (String)"PSDELLCONDID", (String)"PPSDELLCONDID");
        for (PSDELLCond pSDELLCond : arrayList) {
            pSDELLCondService.getTempMajor(pSDELLCond);
        }
    }

    protected void updateRelatedDataTempMajor(PSDELogicLink pSDELogicLink, PSDELogicLink pSDELogicLink2) throws Exception {
        ArrayList<PSDELLCond> arrayList = this.updateRelatedDataTempMajor_removePSDELLCond(pSDELogicLink, pSDELogicLink2);
        this.updateRelatedDataTempMajor_updatePSDELLCond(pSDELogicLink, pSDELogicLink2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDELogicLink, (IEntity)pSDELogicLink2);
    }

    protected ArrayList<PSDELLCond> updateRelatedDataTempMajor_removePSDELLCond(PSDELogicLink pSDELogicLink, PSDELogicLink pSDELogicLink2) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELLCond> arrayList = pSDELLCondService.selectTempByPSDELogicLink(pSDELogicLink);
        ArrayList<PSDELLCond> arrayList2 = pSDELLCondService.selectByPSDELogicLink(pSDELogicLink2);
        HashMap<String, PSDELLCond> hashMap = new HashMap<String, PSDELLCond>();
        for (PSDELLCond pSDELLCond : arrayList2) {
            hashMap.put(pSDELLCond.getPSDELLCondId(), pSDELLCond);
        }
        PSDELogicLinkServiceBase.sortHierarchyEntities(arrayList, (String)"PSDELLCONDID", (String)"PPSDELLCONDID");
        for (PSDELLCond pSDELLCond : arrayList) {
            Object object = pSDELLCond.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDELLCond pSDELLCond : hashMap.values()) {
            pSDELLCondService.remove((IEntity)pSDELLCond);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDELLCond(PSDELogicLink pSDELogicLink, PSDELogicLink pSDELogicLink2, ArrayList<PSDELLCond> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        for (PSDELLCond pSDELLCond : arrayList) {
            pSDELLCondService.updateTempMajor(pSDELLCond);
        }
    }

    protected void replaceParentInfo(PSDELogicLink pSDELogicLink, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDELogicLink, cloneSession);
        if (pSDELogicLink.getDstPSDELogicNodeId() != null && (iEntity = cloneSession.getEntity("PSDELOGICNODE", (Object)pSDELogicLink.getDstPSDELogicNodeId())) != null) {
            this.onFillParentInfo_DstPSDELogicNode(pSDELogicLink, (PSDELogicNode)iEntity);
        }
        if (pSDELogicLink.getSrcPSDELogicNodeId() != null && (iEntity = cloneSession.getEntity("PSDELOGICNODE", (Object)pSDELogicLink.getSrcPSDELogicNodeId())) != null) {
            this.onFillParentInfo_SrcPSDELogicNode(pSDELogicLink, (PSDELogicNode)iEntity);
        }
        if (pSDELogicLink.getDstPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELogicLink.getDstPSDLParamId())) != null) {
            this.onFillParentInfo_DstPSDLParam(pSDELogicLink, (PSDELogicParam)iEntity);
        }
        if (pSDELogicLink.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDELogicLink.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDELogicLink, (PSDELogic)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDELogicLink, bl);
    }

    protected void onCheckEntity(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondModel(bl, pSDELogicLink, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DebugMode(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultLink(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstEndPoint(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDELogicNodeId(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDLParamId(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDLParamName(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkCond(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkCond2(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkInfo(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicLinkId(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicLinkName(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeParams(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcEndPoint(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDELogicNodeId(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDELogicLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDELogicLink, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondModel(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isCondModelDirty() : !pSDELogicLink.isCondModelDirty()) {
            return null;
        }
        String string = pSDELogicLink.getCondModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondModel_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_DebugMode(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isDebugModeDirty() : !pSDELogicLink.isDebugModeDirty()) {
            return null;
        }
        Integer n = pSDELogicLink.getDebugMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DebugMode_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEBUGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultLink(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isDefaultLinkDirty() && !bl2 : !pSDELogicLink.isDefaultLinkDirty()) {
            return null;
        }
        Integer n = pSDELogicLink.getDefaultLink();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTLINK");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultLink_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstEndPoint(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isDstEndPointDirty() : !pSDELogicLink.isDstEndPointDirty()) {
            return null;
        }
        String string = pSDELogicLink.getDstEndPoint();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstEndPoint_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstPSDELogicNodeId(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isDstPSDELogicNodeIdDirty() && !bl2 : !pSDELogicLink.isDstPSDELogicNodeIdDirty()) {
            return null;
        }
        String string = pSDELogicLink.getDstPSDELogicNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDELOGICNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDELogicNodeId_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDELOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDLParamId(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isDstPSDLParamIdDirty() : !pSDELogicLink.isDstPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELogicLink.getDstPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDLParamId_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDLParamName(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isDstPSDLParamNameDirty() : !pSDELogicLink.isDstPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELogicLink.getDstPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDLParamName_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isDynaModelFlagDirty() : !pSDELogicLink.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDELogicLink.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkCond(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isLinkCondDirty() : !pSDELogicLink.isLinkCondDirty()) {
            return null;
        }
        String string = pSDELogicLink.getLinkCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkCond_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkCond2(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isLinkCond2Dirty() : !pSDELogicLink.isLinkCond2Dirty()) {
            return null;
        }
        String string = pSDELogicLink.getLinkCond2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkCond2_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKCOND2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkInfo(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isLinkInfoDirty() : !pSDELogicLink.isLinkInfoDirty()) {
            return null;
        }
        String string = pSDELogicLink.getLinkInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkInfo_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isMemoDirty() : !pSDELogicLink.isMemoDirty()) {
            return null;
        }
        String string = pSDELogicLink.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isOrderValueDirty() && !bl2 : !pSDELogicLink.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDELogicLink.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isPSDEIdDirty() : !pSDELogicLink.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDELogicLink.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isPSDELogicIdDirty() && !bl2 : !pSDELogicLink.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDELogicLink.getPSDELogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicLinkId(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isPSDELogicLinkIdDirty() && !bl2 : !pSDELogicLink.isPSDELogicLinkIdDirty()) {
            return null;
        }
        String string = pSDELogicLink.getPSDELogicLinkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICLINKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicLinkId_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicLinkName(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isPSDELogicLinkNameDirty() && !bl2 : !pSDELogicLink.isPSDELogicLinkNameDirty()) {
            return null;
        }
        String string = pSDELogicLink.getPSDELogicLinkName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICLINKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicLinkName_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICLINKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isPSDynaInstIdDirty() : !pSDELogicLink.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDELogicLink.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isPSSystemIdDirty() : !pSDELogicLink.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDELogicLink.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeParams(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isShapeParamsDirty() : !pSDELogicLink.isShapeParamsDirty()) {
            return null;
        }
        String string = pSDELogicLink.getShapeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeParams_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcEndPoint(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isSrcEndPointDirty() : !pSDELogicLink.isSrcEndPointDirty()) {
            return null;
        }
        String string = pSDELogicLink.getSrcEndPoint();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcEndPoint_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_SrcPSDELogicNodeId(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isSrcPSDELogicNodeIdDirty() && !bl2 : !pSDELogicLink.isSrcPSDELogicNodeIdDirty()) {
            return null;
        }
        String string = pSDELogicLink.getSrcPSDELogicNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDELOGICNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDELogicNodeId_Default((IEntity)pSDELogicLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDELOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isUserCatDirty() : !pSDELogicLink.isUserCatDirty()) {
            return null;
        }
        String string = pSDELogicLink.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isUserTagDirty() : !pSDELogicLink.isUserTagDirty()) {
            return null;
        }
        String string = pSDELogicLink.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isUserTag2Dirty() : !pSDELogicLink.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDELogicLink.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isUserTag3Dirty() : !pSDELogicLink.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDELogicLink.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDELogicLink pSDELogicLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicLink.isUserTag4Dirty() : !pSDELogicLink.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDELogicLink.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDELogicLink, bl2, bl3);
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

    protected void onSyncEntity(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDELogicLink, bl);
    }

    protected void onSyncIndexEntities(PSDELogicLink pSDELogicLink, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDELogicLink, bl);
    }

    public Object getDataContextValue(PSDELogicLink pSDELogicLink, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDELogicLink, string, iDataContextParam)) != null) {
            return object;
        }
        PSDELogic pSDELogic = pSDELogicLink.getPSDELogic();
        if (pSDELogic != null && pSDELogic.contains(string)) {
            return pSDELogic.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDELogicLink pSDELogicLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDELLCond_PSDELogicLink(pSDELogicLink, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDELogicLink, arrayList, n);
    }

    protected void onExportRelatedModel_PSDELLCond_PSDELogicLink(PSDELogicLink pSDELogicLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELLCond> arrayList2 = pSDELLCondService.selectByPSDELogicLink(pSDELogicLink);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"9a62552af7b8412dcfa665f5fdc8f010");
            jSONObject.put("srfdename", (Object)"PSDELLCOND");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDELogicLink, (String)"PSDELOGICLINKID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDELLCond pSDELLCond : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDELLCond, (String)"srfsyspub", (int)1) == 0) continue;
            pSDELLCondService.exportModel(pSDELLCond, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDELogicLink pSDELogicLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDELogicLink, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEBUGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DebugMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTLINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTENDPOINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstEndPoint_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDELOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDELogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDELOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDELogicNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKCOND2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkCond2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkInfo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDELOGICLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCENDPOINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcEndPoint_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDELOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDELogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDELOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDELogicNodeName_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_DebugMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DstPSDELogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDELOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDELogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDELOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKCOND", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkCond2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKCOND2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDELogicLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICLINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ShapeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_SrcPSDELogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDELOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDELogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDELOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDELogicLink pSDELogicLink) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDELogicLink)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDELogicLink pSDELogicLink) throws Exception {
        super.onUpdateParent((IEntity)pSDELogicLink);
    }

    @Override
    protected void exportCurXmlModel(PSDELogicLink pSDELogicLink, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDELOGICLINK");
        if (!bl) {
            pSDELogicLink.setCreateDate(null);
            pSDELogicLink.setCreateMan(null);
            pSDELogicLink.setPSDEId(null);
            pSDELogicLink.setPSDELogicLinkId(null);
            pSDELogicLink.setPSSystemId(null);
            pSDELogicLink.setUpdateDate(null);
            pSDELogicLink.setUpdateMan(null);
            pSDELogicLink.setDstPSDELogicNodeId(null);
            pSDELogicLink.setSrcPSDELogicNodeId(null);
            pSDELogicLink.setDstPSDLParamId(null);
            pSDELogicLink.setPSDEId(null);
            pSDELogicLink.setPSDELogicId(null);
            pSDELogicLink.setPSDELogicName(null);
            pSDELogicLink.setPSSystemId(null);
            super.exportCurXmlModel(pSDELogicLink, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDELogicLink pSDELogicLink, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDELLCond(pSDELogicLink, xmlNode);
        super.onExportRelatedXmlModel(pSDELogicLink, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDELLCond(PSDELogicLink pSDELogicLink, XmlNode xmlNode) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELLCond> arrayList = null;
        String string = pSDELogicLink.getPSDELogicLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDELLCondService.selectByPSDELogicLink(pSDELogicLink, "ORDER BY ORDERVALUE ASC") : pSDELLCondService.selectTempByPSDELogicLink(pSDELogicLink, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDELLCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSDELLCond pSDELLCond : arrayList) {
                if (pSDELLCond.getPPSDELLCondId() != null) continue;
                pSDELLCond.set("ORDERVALUE", null);
                pSDELLCondService.exportXmlModel(pSDELLCond, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDELogicLink pSDELogicLink, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDELLCONDS");
        this.importRelatedXmlModel_PSDELLCond(pSDELogicLink, xmlNode2);
        super.onImportRelatedXmlModel(pSDELogicLink, xmlNode);
    }

    protected void importRelatedXmlModel_PSDELLCond(PSDELogicLink pSDELogicLink, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDELogicLink.getPSDELogicLinkId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDELLCondService.removeByPSDELogicLink(pSDELogicLink);
        } else {
            pSDELLCondService.removeTempByPSDELogicLink(pSDELogicLink);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDELLCond pSDELLCond = new PSDELLCond();
                pSDELLCond.setOrderValue(n);
                n += 100;
                pSDELLCondService.fillParentInfo((IEntity)pSDELLCond, "DER1N", "DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID", pSDELogicLink.getPSDELogicLinkId());
                pSDELLCondService.importXmlModel(pSDELLCond, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDELogicLink pSDELogicLink, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDELogicLink, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDELOGIC#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDELOGICLINK_PSDELOGIC_PSDELOGICID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDELOGIC", (boolean)true) == 0) {
            iEntity.set("PSDELOGICID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDELOGICID"};
    }

    @Override
    public String getModelV2Tag(PSDELogicLink pSDELogicLink) {
        return super.getModelV2Tag(pSDELogicLink);
    }

    @Override
    public boolean setModelV2Tag(PSDELogicLink pSDELogicLink, String string) {
        return super.setModelV2Tag(pSDELogicLink, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDELOGICID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDELogicLink pSDELogicLink, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDELogicLink.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDELogicLink, true);
        return super.getModelV2Entity(pSDELogicLink, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDELogicLink pSDELogicLink, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDELogicLink, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDELogicLink pSDELogicLink, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDELogicLink, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDELogicLink pSDELogicLink, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID")) {
            Object object;
            PSDELLCond pSDELLCond2;
            Object object2;
            Object object3;
            Object object4;
            PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDELLCond> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDELOGICLINK#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDELLCOND", (Object)pSDELogicLink.getPSDELogicLinkId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDELLCond2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDELLCond2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDELLCond>();
                object4 = pSDELLCondService.selectByPSDELogicLink(pSDELogicLink);
                object3 = StringHelper.format((String)"PSDELOGICLINK#%1$s", (Object)pSDELogicLink.getPSDELogicLinkId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDELLCond2 = object2.next();
                    object = pSDELLCondService.getModelV2ResScope((IEntity)pSDELLCond2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDELLCond)PSModelV2Helper.toJSONObject((IEntity)pSDELLCond2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDELLCondService.getModelV2Name(false);
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
                        if (objectNode.has("psdellcondname")) {
                            string = objectNode.get("psdellcondname").asText();
                        }
                        if (objectNode2.has("psdellcondname")) {
                            string2 = objectNode2.get("psdellcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSDELLCond pSDELLCond2 : arrayList) {
                    object = new PSDELLCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDELLCond2, false);
                    ((PSDELLCondBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSDELLCondService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDELogicLink, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDELogicLink pSDELogicLink) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELLCond> arrayList = pSDELLCondService.selectByPSDELogicLink(pSDELogicLink);
        String string = StringHelper.format((String)"PSDELOGICLINK#%1$s", (Object)pSDELogicLink.getPSDELogicLinkId());
        for (PSDELLCond pSDELLCond : arrayList) {
            String string2 = pSDELLCondService.getModelV2ResScope((IEntity)pSDELLCond);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDELLCondService.emptyModelV2(pSDELLCond);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDELogicLink.getPSDELogicLinkId());
        pSDELLCondService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDELLCondService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDELLCOND WHERE PSDELOGICLINKID = ?", sqlParamList);
        super.onEmptyModelV2(pSDELogicLink);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSDELLCondService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDELogicLink pSDELogicLink, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDELLCond pSDELLCond = new PSDELLCond();
        pSDELLCond.set("PSDELOGICLINKID", pSDELogicLink.getPSDELogicLinkId());
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDELLCondService.getModelV2Entity(pSDELLCond, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDELogicLink, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDELogicLink pSDELogicLink, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDELLCondService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDELLCond pSDELLCond = new PSDELLCond();
                pSDELLCond.setPSDElogicId(pSDELogicLink.getPSDELogicId());
                pSDELLCond.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
                pSDELLCond.setPSDELogicLinkName(pSDELogicLink.getPSDELogicLinkName());
                pSDELLCond.setOrderValue(n2 += 10);
                pSDELLCondService.compileModelV2(pSDELLCond, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDELLCond pSDELLCond = new PSDELLCond();
                    pSDELLCond.setPSDElogicId(pSDELogicLink.getPSDELogicId());
                    pSDELLCond.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
                    pSDELLCond.setPSDELogicLinkName(pSDELogicLink.getPSDELogicLinkName());
                    pSDELLCondService.compileModelV2(pSDELLCond, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDELogicLink, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDELogicLink pSDELogicLink, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDELLConds(pSDELogicLink, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDELogicLink, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDELLConds(PSDELogicLink pSDELogicLink, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDELLCOND", true), (boolean)false) == 0) {
            PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
            PSDELLCond pSDELLCond = new PSDELLCond();
            pSDELLCond.setPSDELLCondId(pSMOSFile.getPSModelId());
            if (!pSDELLCondService.get((IEntity)pSDELLCond, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDELLCond.getPSDELogicLinkId(), (String)pSDELogicLink.getPSDELogicLinkId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDELLCondService.exportModelV2(pSDELLCond);
            pSDELLCond.reset();
            if (!pSDELLCondService.setModelV2ResScope((IEntity)pSDELLCond, "PSDELOGICLINK", pSDELogicLink.getPSDELogicLinkId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDELLCondService.importModelV2(pSDELLCond, objectNode);
            SessionFactoryManager.commit();
            return pSDELLCondService.getFile((IEntity)pSDELLCond);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDELogicLink pSDELogicLink, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDELLConds(pSDELogicLink, list);
        super.onFillPasteHelps(pSDELogicLink, list);
    }

    protected void onFillPasteHelps_PSDELLConds(PSDELogicLink pSDELogicLink, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDELLCOND");
        pSHelpSection.setSectionParam2("DER1N_PSDELLCOND_PSDELOGICLINK_PSDELOGICLINKID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5]\u7684[\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u6761\u4ef6]");
        list.add(pSHelpSection);
    }
}

