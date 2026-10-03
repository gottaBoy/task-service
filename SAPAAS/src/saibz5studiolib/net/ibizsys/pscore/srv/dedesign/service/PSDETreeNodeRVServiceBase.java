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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDETreeNodeRVDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeNodeRVDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRV;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeNodeRVServiceBase
extends PSCoreSysServiceBase<PSDETreeNodeRV> {
    private static final Log log = LogFactory.getLog(PSDETreeNodeRVServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDETreeNodeRVDEModel pSDETreeNodeRVDEModel;
    private PSDETreeNodeRVDAO pSDETreeNodeRVDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRVService";
    }

    public PSDETreeNodeRVDEModel getPSDETreeNodeRVDEModel() {
        if (this.pSDETreeNodeRVDEModel == null) {
            try {
                this.pSDETreeNodeRVDEModel = (PSDETreeNodeRVDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeNodeRVDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeNodeRVDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETreeNodeRVDEModel();
    }

    public PSDETreeNodeRVDAO getPSDETreeNodeRVDAO() {
        if (this.pSDETreeNodeRVDAO == null) {
            try {
                this.pSDETreeNodeRVDAO = (PSDETreeNodeRVDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETreeNodeRVDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeNodeRVDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETreeNodeRVDAO();
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

    protected void onFillParentInfo(PSDETreeNodeRV pSDETreeNodeRV, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODERV_PSDETREENODE_PSDETREENODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService", (SessionFactory)this.getSessionFactory());
            PSDETreeNode pSDETreeNode = (PSDETreeNode)iService.getDEModel().createEntity();
            pSDETreeNode.set("PSDETREENODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDETreeNode);
            } else {
                iService.get(pSDETreeNode);
            }
            this.onFillParentInfo_PSDETreeNode(pSDETreeNodeRV, pSDETreeNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREENODERV_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDETreeNodeRV, pSDEViewBase);
            return;
        }
        super.onFillParentInfo(pSDETreeNodeRV, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDETreeNode(PSDETreeNodeRV pSDETreeNodeRV, PSDETreeNode pSDETreeNode) throws Exception {
        pSDETreeNodeRV.setPSDETreeNodeId(pSDETreeNode.getPSDETreeNodeId());
        pSDETreeNodeRV.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
        pSDETreeNodeRV.setPSDETreeViewId(pSDETreeNode.getPSDETreeViewId());
    }

    protected void onFillParentInfo_PSDEViewBase(PSDETreeNodeRV pSDETreeNodeRV, PSDEViewBase pSDEViewBase) throws Exception {
        pSDETreeNodeRV.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDETreeNodeRV.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillEntityFullInfo(PSDETreeNodeRV pSDETreeNodeRV, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDETreeNodeRV, bl);
        this.onFillEntityFullInfo_PSDETreeNode(pSDETreeNodeRV, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDETreeNodeRV, bl);
    }

    protected void onFillEntityFullInfo_PSDETreeNode(PSDETreeNodeRV pSDETreeNodeRV, boolean bl) throws Exception {
        if (pSDETreeNodeRV.isPSDETreeNodeIdDirty()) {
            if (pSDETreeNodeRV.getPSDETreeNodeId() != null) {
                if (pSDETreeNodeRV.getPSDETreeNodeId() == null || pSDETreeNodeRV.getPSDETreeViewId() == null) {
                    PSDETreeNode pSDETreeNode = pSDETreeNodeRV.getPSDETreeNode();
                    pSDETreeNodeRV.setPSDETreeNodeName(pSDETreeNode.getPSDETreeNodeName());
                    pSDETreeNodeRV.setPSDETreeViewId(pSDETreeNode.getPSDETreeViewId());
                }
            } else {
                pSDETreeNodeRV.setPSDETreeNodeName(null);
                pSDETreeNodeRV.setPSDETreeViewId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDETreeNodeRV pSDETreeNodeRV, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETreeNodeRV pSDETreeNodeRV, boolean bl) throws Exception {
        super.onWriteBackParent(pSDETreeNodeRV, bl);
    }

    public ArrayList<PSDETreeNodeRV> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectByPSDETreeNode(pSDETreeNodeBase, "", -1);
    }

    public ArrayList<PSDETreeNodeRV> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        return this.selectByPSDETreeNode(pSDETreeNodeBase, string, -1);
    }

    public ArrayList<PSDETreeNodeRV> selectByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETreeNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeRV> selectTempByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase) throws Exception {
        return this.selectTempByPSDETreeNode(pSDETreeNodeBase, "");
    }

    public ArrayList<PSDETreeNodeRV> selectTempByPSDETreeNode(PSDETreeNodeBase pSDETreeNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREENODEID", (Object)pSDETreeNodeBase.getPSDETreeNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeNodeRV> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDETreeNodeRV> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDETreeNodeRV> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    public void resetPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRV> arrayList = this.selectByPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            PSDETreeNodeRV pSDETreeNodeRV2 = (PSDETreeNodeRV)this.getDEModel().createEntity();
            pSDETreeNodeRV2.setPSDETreeNodeRVId(pSDETreeNodeRV.getPSDETreeNodeRVId());
            pSDETreeNodeRV2.setPSDETreeNodeId(null);
            this.update(pSDETreeNodeRV2);
        }
    }

    public void resetTempPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRV> arrayList = this.selectTempByPSDETreeNode(pSDETreeNode);
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            PSDETreeNodeRV pSDETreeNodeRV2 = (PSDETreeNodeRV)this.getDEModel().createEntity();
            pSDETreeNodeRV2.setPSDETreeNodeRVId(pSDETreeNodeRV.getPSDETreeNodeRVId());
            pSDETreeNodeRV2.setPSDETreeNodeId(null);
            this.updateTemp(pSDETreeNodeRV2);
        }
    }

    public void removeByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRVServiceBase.this.onBeforeRemoveByPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRVServiceBase.this.internalRemoveByPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRVServiceBase.this.onAfterRemoveByPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRV> arrayList = this.selectByPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveByPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            this.remove(pSDETreeNodeRV);
        }
        this.onAfterRemoveByPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRV> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeRV> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREENODERV_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDETREENODERV", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeRV> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            PSDETreeNodeRV pSDETreeNodeRV2 = (PSDETreeNodeRV)this.getDEModel().createEntity();
            pSDETreeNodeRV2.setPSDETreeNodeRVId(pSDETreeNodeRV.getPSDETreeNodeRVId());
            pSDETreeNodeRV2.setPSDEViewBaseId(null);
            this.update(pSDETreeNodeRV2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRVServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDETreeNodeRVServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDETreeNodeRVServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDETreeNodeRV> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            this.remove(pSDETreeNodeRV);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDETreeNodeRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDETreeNodeRV> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETreeNodeRV pSDETreeNodeRV) throws Exception {
        super.onBeforeRemove(pSDETreeNodeRV);
    }

    public void removeTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        final PSDETreeNode pSDETreeNode2 = pSDETreeNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRVServiceBase.this.onBeforeRemoveTempByPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRVServiceBase.this.internalRemoveTempByPSDETreeNode(pSDETreeNode2);
                PSDETreeNodeRVServiceBase.this.onAfterRemoveTempByPSDETreeNode(pSDETreeNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
        ArrayList<PSDETreeNodeRV> arrayList = this.selectTempByPSDETreeNode(pSDETreeNode);
        this.onBeforeRemoveTempByPSDETreeNode(pSDETreeNode, arrayList);
        for (PSDETreeNodeRV pSDETreeNodeRV : arrayList) {
            this.removeTemp(pSDETreeNodeRV);
        }
        this.onAfterRemoveTempByPSDETreeNode(pSDETreeNode, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeNode(PSDETreeNode pSDETreeNode, ArrayList<PSDETreeNodeRV> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDETreeNodeRV pSDETreeNodeRV, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDETreeNodeRV, cloneSession);
        if (pSDETreeNodeRV.getPSDETreeNodeId() != null && (iEntity = cloneSession.getEntity("PSDETREENODE", (Object)pSDETreeNodeRV.getPSDETreeNodeId())) != null) {
            this.onFillParentInfo_PSDETreeNode(pSDETreeNodeRV, (PSDETreeNode)iEntity);
        }
        if (pSDETreeNodeRV.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDETreeNodeRV.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDETreeNodeRV, (PSDEViewBase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETreeNodeRV pSDETreeNodeRV, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDETreeNodeRV, bl);
    }

    protected void onCheckEntity(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDETreeNodeRV, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeId(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeRVId(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeRVName(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMode(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefModeText(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefParam(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefParamDesc(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParams(bl, pSDETreeNodeRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDETreeNodeRV, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isMemoDirty() : !pSDETreeNodeRV.isMemoDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDETreeNodeRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeNodeId(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isPSDETreeNodeIdDirty() && !bl2 : !pSDETreeNodeRV.isPSDETreeNodeIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getPSDETreeNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeId_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeRVId(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isPSDETreeNodeRVIdDirty() && !bl2 : !pSDETreeNodeRV.isPSDETreeNodeRVIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getPSDETreeNodeRVId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODERVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeRVId_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODERVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeRVName(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isPSDETreeNodeRVNameDirty() && !bl2 : !pSDETreeNodeRV.isPSDETreeNodeRVNameDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getPSDETreeNodeRVName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODERVNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeRVName_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODERVNAME");
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
                string3 = "PSDETREENODEID";
                String string4 = this.checkFieldDupRule(this.getPSDETreeNodeRVDEModel(), "PSDETREENODERVNAME", string3, pSDETreeNodeRV, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDETREENODERVNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isPSDETreeViewIdDirty() : !pSDETreeNodeRV.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getPSDETreeViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isPSDEViewBaseIdDirty() && !bl2 : !pSDETreeNodeRV.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMode(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isRefModeDirty() : !pSDETreeNodeRV.isRefModeDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getRefMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMode_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefModeText(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isRefModeTextDirty() : !pSDETreeNodeRV.isRefModeTextDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getRefModeText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefModeText_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefParam(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isRefParamDirty() : !pSDETreeNodeRV.isRefParamDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getRefParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefParam_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefParamDesc(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isRefParamDescDirty() : !pSDETreeNodeRV.isRefParamDescDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getRefParamDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefParamDesc_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPARAMDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isUserCatDirty() : !pSDETreeNodeRV.isUserCatDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDETreeNodeRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isUserTagDirty() : !pSDETreeNodeRV.isUserTagDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDETreeNodeRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isUserTag2Dirty() : !pSDETreeNodeRV.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDETreeNodeRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isUserTag3Dirty() : !pSDETreeNodeRV.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDETreeNodeRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isUserTag4Dirty() : !pSDETreeNodeRV.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDETreeNodeRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewParams(boolean bl, PSDETreeNodeRV pSDETreeNodeRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeNodeRV.isViewParamsDirty() : !pSDETreeNodeRV.isViewParamsDirty()) {
            return null;
        }
        String string = pSDETreeNodeRV.getViewParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParams_Default(pSDETreeNodeRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDETreeNodeRV pSDETreeNodeRV, boolean bl) throws Exception {
        super.onSyncEntity(pSDETreeNodeRV, bl);
    }

    protected void onSyncIndexEntities(PSDETreeNodeRV pSDETreeNodeRV, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDETreeNodeRV, bl);
    }

    public Object getDataContextValue(PSDETreeNodeRV pSDETreeNodeRV, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDETreeNodeRV, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDETreeNodeRV pSDETreeNodeRV, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDETreeNodeRV, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODERVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeRVId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODERVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeRVName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefModeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPARAMDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefParamDesc_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDETreeNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeRVId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODERVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeRVName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODERVNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefModeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODETEXT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefParamDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPARAMDESC", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ViewParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDETreeNodeRV pSDETreeNodeRV) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDETreeNodeRV)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETreeNodeRV pSDETreeNodeRV) throws Exception {
        super.onUpdateParent(pSDETreeNodeRV);
    }

    @Override
    protected void exportCurXmlModel(PSDETreeNodeRV pSDETreeNodeRV, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETREENODERV");
        if (!bl) {
            pSDETreeNodeRV.setCreateDate(null);
            pSDETreeNodeRV.setCreateMan(null);
            pSDETreeNodeRV.setPSDETreeNodeRVId(null);
            pSDETreeNodeRV.setPSDETreeViewId(null);
            pSDETreeNodeRV.setUpdateDate(null);
            pSDETreeNodeRV.setUpdateMan(null);
            pSDETreeNodeRV.setPSDETreeNodeId(null);
            pSDETreeNodeRV.setPSDETreeNodeName(null);
            pSDETreeNodeRV.setPSDETreeViewId(null);
            super.exportCurXmlModel(pSDETreeNodeRV, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETreeNodeRV pSDETreeNodeRV, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETreeNodeRV, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREENODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDETREENODE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREENODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETREENODERV_PSDETREENODE_PSDETREENODEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREENODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETREENODENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDETREENODE", (boolean)true) == 0) {
            iEntity.set("PSDETREENODEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDETREENODEID"};
    }

    @Override
    public String getModelV2Tag(PSDETreeNodeRV pSDETreeNodeRV) {
        if (!StringHelper.isNullOrEmpty((String)pSDETreeNodeRV.getPSDETreeNodeRVName())) {
            return pSDETreeNodeRV.getPSDETreeNodeRVName();
        }
        return super.getModelV2Tag(pSDETreeNodeRV);
    }

    @Override
    public boolean setModelV2Tag(PSDETreeNodeRV pSDETreeNodeRV, String string) {
        pSDETreeNodeRV.setPSDETreeNodeRVName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDETREENODERVNAME", "");
        map.put("PSDETREENODEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETreeNodeRV pSDETreeNodeRV, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETreeNodeRV.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETreeNodeRV, true);
        pSDETreeNodeRV.set("PSDETREENODERVNAME", string);
        if (this.select(pSDETreeNodeRV, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDETreeNodeRV, true);
        return super.getModelV2Entity(pSDETreeNodeRV, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETreeNodeRV pSDETreeNodeRV, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDETreeNodeRV, objectNode, string, string2, n);
    }
}

