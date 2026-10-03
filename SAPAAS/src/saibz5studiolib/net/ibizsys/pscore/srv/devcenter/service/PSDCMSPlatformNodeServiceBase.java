/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
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
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformNodeDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformNodeDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItemBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformNode;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformNodeBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMSPlatformNodeServiceBase
extends PSCoreSysServiceBase<PSDCMSPlatformNode> {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformNodeServiceBase.class);
    public static final String DATASET_APINODE = "APINode";
    public static final String DATASET_APPNODE = "AppNode";
    public static final String DATASET_CURMSP = "CurMSP";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCMSPlatformNodeDEModel pSDCMSPlatformNodeDEModel;
    private PSDCMSPlatformNodeDAO pSDCMSPlatformNodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService";
    }

    public PSDCMSPlatformNodeDEModel getPSDCMSPlatformNodeDEModel() {
        if (this.pSDCMSPlatformNodeDEModel == null) {
            try {
                this.pSDCMSPlatformNodeDEModel = (PSDCMSPlatformNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformNodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMSPlatformNodeDEModel();
    }

    public PSDCMSPlatformNodeDAO getPSDCMSPlatformNodeDAO() {
        if (this.pSDCMSPlatformNodeDAO == null) {
            try {
                this.pSDCMSPlatformNodeDAO = (PSDCMSPlatformNodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformNodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformNodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMSPlatformNodeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_APINODE, (boolean)true) == 0) {
            return this.fetchAPINode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_APPNODE, (boolean)true) == 0) {
            return this.fetchAppNode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMSP, (boolean)true) == 0) {
            return this.fetchCurMSP(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchAPINode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_APINODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchAppNode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_APPNODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurMSP(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMSP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCMSPlatformNode pSDCMSPlatformNode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORMNODE_PSDCMSPLATFORM_PSDCMSPLATFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatform pSDCMSPlatform = (PSDCMSPlatform)iService.getDEModel().createEntity();
            pSDCMSPlatform.set("PSDCMSPLATFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMSPlatform);
            } else {
                iService.get(pSDCMSPlatform);
            }
            this.onFillParentInfo_PSDCMSPlatform(pSDCMSPlatformNode, pSDCMSPlatform);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORMNODE_PSDCREGISTRYITEM_PSDCREGISTRYITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryItem pSDCRegistryItem = (PSDCRegistryItem)iService.getDEModel().createEntity();
            pSDCRegistryItem.set("PSDCREGISTRYITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRegistryItem);
            } else {
                iService.get(pSDCRegistryItem);
            }
            this.onFillParentInfo_PSDCRegistryItem(pSDCMSPlatformNode, pSDCRegistryItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORMNODE_PSMSPLATFORMNODE_PSMSPLATFORMNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformNodeService", (SessionFactory)this.getSessionFactory());
            PSMSPlatformNode pSMSPlatformNode = (PSMSPlatformNode)iService.getDEModel().createEntity();
            pSMSPlatformNode.set("PSMSPLATFORMNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSMSPlatformNode);
            } else {
                iService.get(pSMSPlatformNode);
            }
            this.onFillParentInfo_PSMSPlatformNode(pSDCMSPlatformNode, pSMSPlatformNode);
            return;
        }
        super.onFillParentInfo(pSDCMSPlatformNode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMSPlatform(PSDCMSPlatformNode pSDCMSPlatformNode, PSDCMSPlatform pSDCMSPlatform) throws Exception {
        pSDCMSPlatformNode.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
        pSDCMSPlatformNode.setPSDCMSPlatformName(pSDCMSPlatform.getPSDCMSPlatformName());
        pSDCMSPlatformNode.setPSDevSlnId(pSDCMSPlatform.getPSDevSlnId());
        pSDCMSPlatformNode.setPSDevSlnName(pSDCMSPlatform.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSDCRegistryItem(PSDCMSPlatformNode pSDCMSPlatformNode, PSDCRegistryItem pSDCRegistryItem) throws Exception {
        pSDCMSPlatformNode.setDCRegistryItemTag(pSDCRegistryItem.getItemTag());
        pSDCMSPlatformNode.setDCRegistryItemTag2(pSDCRegistryItem.getItemTag2());
        pSDCMSPlatformNode.setDCRegistryItemTag3(pSDCRegistryItem.getItemTag3());
        pSDCMSPlatformNode.setDCRegistryItemTag4(pSDCRegistryItem.getItemTag4());
        pSDCMSPlatformNode.setPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
        pSDCMSPlatformNode.setPSDCRegistryItemName(pSDCRegistryItem.getPSDCRegistryItemName());
    }

    protected void onFillParentInfo_PSMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, PSMSPlatformNode pSMSPlatformNode) throws Exception {
        pSDCMSPlatformNode.setPSMSPlatformNodeId(pSMSPlatformNode.getPSMSPlatformNodeId());
        pSDCMSPlatformNode.setPSMSPlatformNodeName(pSMSPlatformNode.getPSMSPlatformNodeName());
    }

    protected void onFillEntityFullInfo(PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl) throws Exception {
        if (bl) {
            if (pSDCMSPlatformNode.getRefCount() == null) {
                pSDCMSPlatformNode.setRefCount((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCMSPlatformNode.getValidFlag() == null) {
                pSDCMSPlatformNode.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDCMSPlatformNode, bl);
        this.onFillEntityFullInfo_PSDCMSPlatform(pSDCMSPlatformNode, bl);
        this.onFillEntityFullInfo_PSDCRegistryItem(pSDCMSPlatformNode, bl);
        this.onFillEntityFullInfo_PSMSPlatformNode(pSDCMSPlatformNode, bl);
    }

    protected void onFillEntityFullInfo_PSDCMSPlatform(PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl) throws Exception {
        if (pSDCMSPlatformNode.isPSDCMSPlatformIdDirty()) {
            if (pSDCMSPlatformNode.getPSDCMSPlatformId() != null) {
                if (pSDCMSPlatformNode.getPSDCMSPlatformId() == null || pSDCMSPlatformNode.getPSDCMSPlatformName() == null) {
                    PSDCMSPlatform pSDCMSPlatform = pSDCMSPlatformNode.getPSDCMSPlatform();
                    pSDCMSPlatformNode.setPSDCMSPlatformName(pSDCMSPlatform.getPSDCMSPlatformName());
                    pSDCMSPlatformNode.setPSDevSlnId(pSDCMSPlatform.getPSDevSlnId());
                    pSDCMSPlatformNode.setPSDevSlnName(pSDCMSPlatform.getPSDevSlnName());
                }
            } else {
                pSDCMSPlatformNode.setPSDCMSPlatformName(null);
                pSDCMSPlatformNode.setPSDevSlnId(null);
                pSDCMSPlatformNode.setPSDevSlnName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDCRegistryItem(PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl) throws Exception {
        if (pSDCMSPlatformNode.isPSMSPlatformNodeIdDirty()) {
            if (pSDCMSPlatformNode.getPSMSPlatformNodeId() != null) {
                if (pSDCMSPlatformNode.getPSMSPlatformNodeId() == null || pSDCMSPlatformNode.getPSMSPlatformNodeName() == null) {
                    PSMSPlatformNode pSMSPlatformNode = pSDCMSPlatformNode.getPSMSPlatformNode();
                    pSDCMSPlatformNode.setPSMSPlatformNodeName(pSMSPlatformNode.getPSMSPlatformNodeName());
                }
            } else {
                pSDCMSPlatformNode.setPSMSPlatformNodeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCMSPlatformNode, bl);
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, "", -1);
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, string, -1);
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMSPLATFORMID", (Object)pSDCMSPlatformBase.getPSDCMSPlatformId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMSPlatformCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMSPlatformCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase) throws Exception {
        return this.selectByPSDCRegistryItem(pSDCRegistryItemBase, "", -1);
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string) throws Exception {
        return this.selectByPSDCRegistryItem(pSDCRegistryItemBase, string, -1);
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCREGISTRYITEMID", (Object)pSDCRegistryItemBase.getPSDCRegistryItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRegistryItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRegistryItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSMSPlatformNode(PSMSPlatformNodeBase pSMSPlatformNodeBase) throws Exception {
        return this.selectByPSMSPlatformNode(pSMSPlatformNodeBase, "", -1);
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSMSPlatformNode(PSMSPlatformNodeBase pSMSPlatformNodeBase, String string) throws Exception {
        return this.selectByPSMSPlatformNode(pSMSPlatformNodeBase, string, -1);
    }

    public ArrayList<PSDCMSPlatformNode> selectByPSMSPlatformNode(PSMSPlatformNodeBase pSMSPlatformNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMSPLATFORMNODEID", (Object)pSMSPlatformNodeBase.getPSMSPlatformNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSMSPlatformNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSMSPlatformNodeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    public void resetPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDCMSPlatformNode> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        for (PSDCMSPlatformNode pSDCMSPlatformNode : arrayList) {
            PSDCMSPlatformNode pSDCMSPlatformNode2 = (PSDCMSPlatformNode)this.getDEModel().createEntity();
            pSDCMSPlatformNode2.setPSDCMSPlatformNodeId(pSDCMSPlatformNode.getPSDCMSPlatformNodeId());
            pSDCMSPlatformNode2.setPSDCMSPlatformId(null);
            this.update(pSDCMSPlatformNode2);
        }
    }

    public void removeByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        final PSDCMSPlatform pSDCMSPlatform2 = pSDCMSPlatform;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformNodeServiceBase.this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDCMSPlatformNodeServiceBase.this.internalRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDCMSPlatformNodeServiceBase.this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDCMSPlatformNode> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
        for (PSDCMSPlatformNode pSDCMSPlatformNode : arrayList) {
            this.remove(pSDCMSPlatformNode);
        }
        this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDCMSPlatformNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDCMSPlatformNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDCMSPlatformNode> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCRegistryItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORMNODE_PSDCREGISTRYITEM_PSDCREGISTRYITEMID", "", iDataEntityModel.getName(), "PSDCMSPLATFORMNODE", iDataEntityModel.getDataInfo(pSDCRegistryItem), arrayList.get(0)));
        }
    }

    public void resetPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDCMSPlatformNode> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem);
        for (PSDCMSPlatformNode pSDCMSPlatformNode : arrayList) {
            PSDCMSPlatformNode pSDCMSPlatformNode2 = (PSDCMSPlatformNode)this.getDEModel().createEntity();
            pSDCMSPlatformNode2.setPSDCMSPlatformNodeId(pSDCMSPlatformNode.getPSDCMSPlatformNodeId());
            pSDCMSPlatformNode2.setPSDCRegistryItemId(null);
            this.update(pSDCMSPlatformNode2);
        }
    }

    public void removeByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        final PSDCRegistryItem pSDCRegistryItem2 = pSDCRegistryItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformNodeServiceBase.this.onBeforeRemoveByPSDCRegistryItem(pSDCRegistryItem2);
                PSDCMSPlatformNodeServiceBase.this.internalRemoveByPSDCRegistryItem(pSDCRegistryItem2);
                PSDCMSPlatformNodeServiceBase.this.onAfterRemoveByPSDCRegistryItem(pSDCRegistryItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void internalRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDCMSPlatformNode> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem);
        this.onBeforeRemoveByPSDCRegistryItem(pSDCRegistryItem, arrayList);
        for (PSDCMSPlatformNode pSDCMSPlatformNode : arrayList) {
            this.remove(pSDCMSPlatformNode);
        }
        this.onAfterRemoveByPSDCRegistryItem(pSDCRegistryItem, arrayList);
    }

    protected void onAfterRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDCMSPlatformNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDCMSPlatformNode> arrayList) throws Exception {
    }

    public void testRemoveByPSMSPlatformNode(PSMSPlatformNode pSMSPlatformNode) throws Exception {
        ArrayList<PSDCMSPlatformNode> arrayList = this.selectByPSMSPlatformNode(pSMSPlatformNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMSPLATFORMNODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSMSPlatformNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMSPLATFORMNODE_PSMSPLATFORMNODE_PSMSPLATFORMNODEID", "", iDataEntityModel.getName(), "PSDCMSPLATFORMNODE", iDataEntityModel.getDataInfo(pSMSPlatformNode), arrayList.get(0)));
        }
    }

    public void resetPSMSPlatformNode(PSMSPlatformNode pSMSPlatformNode) throws Exception {
        ArrayList<PSDCMSPlatformNode> arrayList = this.selectByPSMSPlatformNode(pSMSPlatformNode);
        for (PSDCMSPlatformNode pSDCMSPlatformNode : arrayList) {
            PSDCMSPlatformNode pSDCMSPlatformNode2 = (PSDCMSPlatformNode)this.getDEModel().createEntity();
            pSDCMSPlatformNode2.setPSDCMSPlatformNodeId(pSDCMSPlatformNode.getPSDCMSPlatformNodeId());
            pSDCMSPlatformNode2.setPSMSPlatformNodeId(null);
            this.update(pSDCMSPlatformNode2);
        }
    }

    public void removeByPSMSPlatformNode(PSMSPlatformNode pSMSPlatformNode) throws Exception {
        final PSMSPlatformNode pSMSPlatformNode2 = pSMSPlatformNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformNodeServiceBase.this.onBeforeRemoveByPSMSPlatformNode(pSMSPlatformNode2);
                PSDCMSPlatformNodeServiceBase.this.internalRemoveByPSMSPlatformNode(pSMSPlatformNode2);
                PSDCMSPlatformNodeServiceBase.this.onAfterRemoveByPSMSPlatformNode(pSMSPlatformNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSMSPlatformNode(PSMSPlatformNode pSMSPlatformNode) throws Exception {
    }

    protected void internalRemoveByPSMSPlatformNode(PSMSPlatformNode pSMSPlatformNode) throws Exception {
        ArrayList<PSDCMSPlatformNode> arrayList = this.selectByPSMSPlatformNode(pSMSPlatformNode);
        this.onBeforeRemoveByPSMSPlatformNode(pSMSPlatformNode, arrayList);
        for (PSDCMSPlatformNode pSDCMSPlatformNode : arrayList) {
            this.remove(pSDCMSPlatformNode);
        }
        this.onAfterRemoveByPSMSPlatformNode(pSMSPlatformNode, arrayList);
    }

    protected void onAfterRemoveByPSMSPlatformNode(PSMSPlatformNode pSMSPlatformNode) throws Exception {
    }

    protected void onBeforeRemoveByPSMSPlatformNode(PSMSPlatformNode pSMSPlatformNode, ArrayList<PSDCMSPlatformNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSMSPlatformNode(PSMSPlatformNode pSMSPlatformNode, ArrayList<PSDCMSPlatformNode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode);
        pSCoreSysServiceBase = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode);
        pSCoreSysServiceBase = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode);
        super.onBeforeRemove(pSDCMSPlatformNode);
    }

    protected void replaceParentInfo(PSDCMSPlatformNode pSDCMSPlatformNode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCMSPlatformNode, cloneSession);
        if (pSDCMSPlatformNode.getPSDCMSPlatformId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORM", (Object)pSDCMSPlatformNode.getPSDCMSPlatformId())) != null) {
            this.onFillParentInfo_PSDCMSPlatform(pSDCMSPlatformNode, (PSDCMSPlatform)iEntity);
        }
        if (pSDCMSPlatformNode.getPSDCRegistryItemId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYITEM", (Object)pSDCMSPlatformNode.getPSDCRegistryItemId())) != null) {
            this.onFillParentInfo_PSDCRegistryItem(pSDCMSPlatformNode, (PSDCRegistryItem)iEntity);
        }
        if (pSDCMSPlatformNode.getPSMSPlatformNodeId() != null && (iEntity = cloneSession.getEntity("PSMSPLATFORMNODE", (Object)pSDCMSPlatformNode.getPSMSPlatformNodeId())) != null) {
            this.onFillParentInfo_PSMSPlatformNode(pSDCMSPlatformNode, (PSMSPlatformNode)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCMSPlatformNode, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CfgType(bl, pSDCMSPlatformNode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContainerCfg(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnvParams(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxCPU(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxMem(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinCPU(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinMem(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeTag(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeTag2(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port2(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformId(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformName(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformNodeId(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformNodeName(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryItemId(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformNodeId(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformNodeName(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCount(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefInfo(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Scale(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSDCMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCMSPlatformNode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CfgType(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isCfgTypeDirty() : !pSDCMSPlatformNode.isCfgTypeDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getCfgType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgType_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContainerCfg(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isContainerCfgDirty() : !pSDCMSPlatformNode.isContainerCfgDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getContainerCfg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContainerCfg_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTAINERCFG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnvParams(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isEnvParamsDirty() : !pSDCMSPlatformNode.isEnvParamsDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getEnvParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnvParams_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENVPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isIpAddrDirty() : !pSDCMSPlatformNode.isIpAddrDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isIpAddr2Dirty() : !pSDCMSPlatformNode.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxCPU(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isMaxCPUDirty() : !pSDCMSPlatformNode.isMaxCPUDirty()) {
            return null;
        }
        Double d = pSDCMSPlatformNode.getMaxCPU();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxCPU_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXCPU");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxMem(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isMaxMemDirty() : !pSDCMSPlatformNode.isMaxMemDirty()) {
            return null;
        }
        Double d = pSDCMSPlatformNode.getMaxMem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxMem_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXMEN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isMemoDirty() : !pSDCMSPlatformNode.isMemoDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinCPU(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isMinCPUDirty() : !pSDCMSPlatformNode.isMinCPUDirty()) {
            return null;
        }
        Double d = pSDCMSPlatformNode.getMinCPU();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinCPU_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINCPU");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinMem(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isMinMemDirty() : !pSDCMSPlatformNode.isMinMemDirty()) {
            return null;
        }
        Double d = pSDCMSPlatformNode.getMinMem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinMem_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINMEN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeTag(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isNodeTagDirty() : !pSDCMSPlatformNode.isNodeTagDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getNodeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeTag_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeTag2(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isNodeTag2Dirty() : !pSDCMSPlatformNode.isNodeTag2Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getNodeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeTag2_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPasswdDirty() : !pSDCMSPlatformNode.isPasswdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Port(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPortDirty() : !pSDCMSPlatformNode.isPortDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformNode.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (n == null) {
                bl4 = false;
            }
            if (bl4) {
                String string = "";
                string = "PSDCMSPLATFORMID";
                String string2 = this.checkFieldDupRule(this.getPSDCMSPlatformNodeDEModel(), "PORT", string, pSDCMSPlatformNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PORT");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Port2(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPort2Dirty() : !pSDCMSPlatformNode.isPort2Dirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformNode.getPort2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port2_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformId(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPSDCMSPlatformIdDirty() : !pSDCMSPlatformNode.isPSDCMSPlatformIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getPSDCMSPlatformId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformId_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformName(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPSDCMSPlatformNameDirty() : !pSDCMSPlatformNode.isPSDCMSPlatformNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getPSDCMSPlatformName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformName_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformNodeId(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPSDCMSPlatformNodeIdDirty() && !bl2 : !pSDCMSPlatformNode.isPSDCMSPlatformNodeIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getPSDCMSPlatformNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformNodeId_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformNodeName(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPSDCMSPlatformNodeNameDirty() && !bl2 : !pSDCMSPlatformNode.isPSDCMSPlatformNodeNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getPSDCMSPlatformNodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformNodeName_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDCMSPLATFORMID";
                String string4 = this.checkFieldDupRule(this.getPSDCMSPlatformNodeDEModel(), "PSDCMSPLATFORMNODENAME", string3, pSDCMSPlatformNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDCMSPLATFORMNODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRegistryItemId(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPSDCRegistryItemIdDirty() : !pSDCMSPlatformNode.isPSDCRegistryItemIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getPSDCRegistryItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryItemId_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMSPlatformNodeId(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPSMSPlatformNodeIdDirty() : !pSDCMSPlatformNode.isPSMSPlatformNodeIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getPSMSPlatformNodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformNodeId_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMSPlatformNodeName(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isPSMSPlatformNodeNameDirty() : !pSDCMSPlatformNode.isPSMSPlatformNodeNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getPSMSPlatformNodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformNodeName_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCount(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isRefCountDirty() : !pSDCMSPlatformNode.isRefCountDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformNode.getRefCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefCount_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefInfo(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isRefInfoDirty() : !pSDCMSPlatformNode.isRefInfoDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getRefInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefInfo_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Scale(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isScaleDirty() : !pSDCMSPlatformNode.isScaleDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformNode.getScale();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Scale_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SCALE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isSSHIPAddrDirty() : !pSDCMSPlatformNode.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHIPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isSSHPortDirty() : !pSDCMSPlatformNode.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformNode.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isUploadFileModeDirty() : !pSDCMSPlatformNode.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADFILEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isUploadPathDirty() : !pSDCMSPlatformNode.isUploadPathDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isUserNameDirty() : !pSDCMSPlatformNode.isUserNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isUserParamsDirty() : !pSDCMSPlatformNode.isUserParamsDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isUserTagDirty() : !pSDCMSPlatformNode.isUserTagDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDCMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isUserTag2Dirty() : !pSDCMSPlatformNode.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDCMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isUserTag3Dirty() : !pSDCMSPlatformNode.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDCMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isUserTag4Dirty() : !pSDCMSPlatformNode.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDCMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isValidFlagDirty() && !bl2 : !pSDCMSPlatformNode.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformNode.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformNode.isWorkshopPathDirty() : !pSDCMSPlatformNode.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSDCMSPlatformNode.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSDCMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSHOPPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl) throws Exception {
        super.onSyncEntity(pSDCMSPlatformNode, bl);
    }

    protected void onSyncIndexEntities(PSDCMSPlatformNode pSDCMSPlatformNode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCMSPlatformNode, bl);
    }

    public Object getDataContextValue(PSDCMSPlatformNode pSDCMSPlatformNode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCMSPlatformNode, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCMSPlatform pSDCMSPlatform = pSDCMSPlatformNode.getPSDCMSPlatform();
        if (pSDCMSPlatform != null && pSDCMSPlatform.contains(string)) {
            return pSDCMSPlatform.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCMSPlatformNode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CFGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTAINERCFG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContainerCfg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCREGISTRYITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCRegistryItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCREGISTRYITEMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCRegistryItemTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCREGISTRYITEMTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCRegistryItemTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCREGISTRYITEMTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCRegistryItemTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENVPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnvParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXCPU", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxCPU_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXMEN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxMem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINCPU", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinCPU_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINMEN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinMem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODESTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Port_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Port2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCount_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPLICATED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Replicated_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SCALE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Scale_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHIPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHIPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADFILEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadFileMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CfgType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContainerCfg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTAINERCFG", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_DCRegistryItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCREGISTRYITEMTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCRegistryItemTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCREGISTRYITEMTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCRegistryItemTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCREGISTRYITEMTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCRegistryItemTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCREGISTRYITEMTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnvParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENVPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxCPU_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxMem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinCPU_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinMem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NodeInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODESTATE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Passwd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Port_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldValueRangeRule("PORT", iEntity, bl2, new Double(1.0), true, new Double(65535.0), true, "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[1]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[65535]", false)) {
                return null;
            }
            return "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[1]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[65535]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Port2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldValueRangeRule("PORT2", iEntity, bl2, new Double(1.0), true, new Double(65535.0), true, "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[1]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[65535]", false)) {
                return null;
            }
            return "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[1]\u4e14\u5c0f\u4e8e\u7b49\u4e8e[65535]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMSPlatformNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMSPlatformNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Replicated_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Scale_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ServiceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEID", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHIPAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SSHIPADDR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UploadFileMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADFILEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UploadPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_WorkshopPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKSHOPPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCMSPlatformNode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        super.onUpdateParent(pSDCMSPlatformNode);
    }

    @Override
    protected void exportCurXmlModel(PSDCMSPlatformNode pSDCMSPlatformNode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMSPLATFORMNODE");
        if (!bl) {
            pSDCMSPlatformNode.setCreateDate(null);
            pSDCMSPlatformNode.setCreateMan(null);
            pSDCMSPlatformNode.setPSDCMSPlatformNodeId(null);
            pSDCMSPlatformNode.setRefCount(null);
            pSDCMSPlatformNode.setRefInfo(null);
            pSDCMSPlatformNode.setUpdateDate(null);
            pSDCMSPlatformNode.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMSPlatformNode, xmlNode, bl);
        }
    }
}

