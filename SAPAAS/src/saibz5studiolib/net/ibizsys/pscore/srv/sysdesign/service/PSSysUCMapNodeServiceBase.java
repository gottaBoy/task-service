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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysUCMapNodeDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUCMapNodeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMapBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMapNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUCMapNodeServiceBase
extends PSCoreSysServiceBase<PSSysUCMapNode> {
    private static final Log log = LogFactory.getLog(PSSysUCMapNodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysUCMapNodeDEModel pSSysUCMapNodeDEModel;
    private PSSysUCMapNodeDAO pSSysUCMapNodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapNodeService";
    }

    public PSSysUCMapNodeDEModel getPSSysUCMapNodeDEModel() {
        if (this.pSSysUCMapNodeDEModel == null) {
            try {
                this.pSSysUCMapNodeDEModel = (PSSysUCMapNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUCMapNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUCMapNodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUCMapNodeDEModel();
    }

    public PSSysUCMapNodeDAO getPSSysUCMapNodeDAO() {
        if (this.pSSysUCMapNodeDAO == null) {
            try {
                this.pSSysUCMapNodeDAO = (PSSysUCMapNodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysUCMapNodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUCMapNodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUCMapNodeDAO();
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

    protected void onFillParentInfo(PSSysUCMapNode pSSysUCMapNode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUCMAPNODE_PSSYSACTOR_PSSYSACTORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService", (SessionFactory)this.getSessionFactory());
            PSSysActor pSSysActor = (PSSysActor)iService.getDEModel().createEntity();
            pSSysActor.set("PSSYSACTORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysActor);
            } else {
                iService.get(pSSysActor);
            }
            this.onFillParentInfo_PSSysActor(pSSysUCMapNode, pSSysActor);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUCMAPNODE_PSSYSUCMAP_PSSYSUCMAPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService", (SessionFactory)this.getSessionFactory());
            PSSysUCMap pSSysUCMap = (PSSysUCMap)iService.getDEModel().createEntity();
            pSSysUCMap.set("PSSYSUCMAPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUCMap);
            } else {
                iService.get(pSSysUCMap);
            }
            this.onFillParentInfo_PSSysUCMap(pSSysUCMapNode, pSSysUCMap);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUCMAPNODE_PSSYSUSERCASE_PSSYSUSERCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = (PSSysUserCase)iService.getDEModel().createEntity();
            pSSysUserCase.set("PSSYSUSERCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUserCase);
            } else {
                iService.get(pSSysUserCase);
            }
            this.onFillParentInfo_PSSysUserCase(pSSysUCMapNode, pSSysUserCase);
            return;
        }
        super.onFillParentInfo(pSSysUCMapNode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysActor(PSSysUCMapNode pSSysUCMapNode, PSSysActor pSSysActor) throws Exception {
        pSSysUCMapNode.setPSSysActorId(pSSysActor.getPSSysActorId());
        pSSysUCMapNode.setPSSysActorName(pSSysActor.getPSSysActorName());
    }

    protected void onFillParentInfo_PSSysUCMap(PSSysUCMapNode pSSysUCMapNode, PSSysUCMap pSSysUCMap) throws Exception {
        pSSysUCMapNode.setPSSysUCMapId(pSSysUCMap.getPSSysUCMapId());
        pSSysUCMapNode.setPSSysUCMapName(pSSysUCMap.getPSSysUCMapName());
    }

    protected void onFillParentInfo_PSSysUserCase(PSSysUCMapNode pSSysUCMapNode, PSSysUserCase pSSysUserCase) throws Exception {
        pSSysUCMapNode.setPSSysUserCaseId(pSSysUserCase.getPSSysUserCaseId());
        pSSysUCMapNode.setPSSysUserCaseName(pSSysUserCase.getPSSysUserCaseName());
    }

    protected void onFillEntityFullInfo(PSSysUCMapNode pSSysUCMapNode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysUCMapNode, bl);
        this.onFillEntityFullInfo_PSSysActor(pSSysUCMapNode, bl);
        this.onFillEntityFullInfo_PSSysUCMap(pSSysUCMapNode, bl);
        this.onFillEntityFullInfo_PSSysUserCase(pSSysUCMapNode, bl);
    }

    protected void onFillEntityFullInfo_PSSysActor(PSSysUCMapNode pSSysUCMapNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUCMap(PSSysUCMapNode pSSysUCMapNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserCase(PSSysUCMapNode pSSysUCMapNode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysUCMapNode pSSysUCMapNode, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysUCMapNode, bl);
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysActor(PSSysActorBase pSSysActorBase) throws Exception {
        return this.selectByPSSysActor(pSSysActorBase, "", -1);
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysActor(PSSysActorBase pSSysActorBase, String string) throws Exception {
        return this.selectByPSSysActor(pSSysActorBase, string, -1);
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysActor(PSSysActorBase pSSysActorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSACTORID", (Object)pSSysActorBase.getPSSysActorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysActorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysActorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysUCMap(PSSysUCMapBase pSSysUCMapBase) throws Exception {
        return this.selectByPSSysUCMap(pSSysUCMapBase, "", -1);
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysUCMap(PSSysUCMapBase pSSysUCMapBase, String string) throws Exception {
        return this.selectByPSSysUCMap(pSSysUCMapBase, string, -1);
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysUCMap(PSSysUCMapBase pSSysUCMapBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUCMAPID", (Object)pSSysUCMapBase.getPSSysUCMapId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUCMapCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUCMapCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUCMapNode> selectTempByPSSysUCMap(PSSysUCMapBase pSSysUCMapBase) throws Exception {
        return this.selectTempByPSSysUCMap(pSSysUCMapBase, "");
    }

    public ArrayList<PSSysUCMapNode> selectTempByPSSysUCMap(PSSysUCMapBase pSSysUCMapBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUCMAPID", (Object)pSSysUCMapBase.getPSSysUCMapId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysUCMapCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysUCMapCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, "", -1);
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, string, -1);
    }

    public ArrayList<PSSysUCMapNode> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERCASEID", (Object)pSSysUserCaseBase.getPSSysUserCaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserCaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserCaseCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectByPSSysActor(pSSysActor, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSACTOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysActor);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUCMAPNODE_PSSYSACTOR_PSSYSACTORID", "", iDataEntityModel.getName(), "PSSYSUCMAPNODE", iDataEntityModel.getDataInfo(pSSysActor), arrayList.get(0)));
        }
    }

    public void resetPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectByPSSysActor(pSSysActor);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            PSSysUCMapNode pSSysUCMapNode2 = (PSSysUCMapNode)this.getDEModel().createEntity();
            pSSysUCMapNode2.setPSSysUCMapNodeId(pSSysUCMapNode.getPSSysUCMapNodeId());
            pSSysUCMapNode2.setPSSysActorId(null);
            this.update(pSSysUCMapNode2);
        }
    }

    public void removeByPSSysActor(PSSysActor pSSysActor) throws Exception {
        final PSSysActor pSSysActor2 = pSSysActor;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapNodeServiceBase.this.onBeforeRemoveByPSSysActor(pSSysActor2);
                PSSysUCMapNodeServiceBase.this.internalRemoveByPSSysActor(pSSysActor2);
                PSSysUCMapNodeServiceBase.this.onAfterRemoveByPSSysActor(pSSysActor2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
    }

    protected void internalRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectByPSSysActor(pSSysActor);
        this.onBeforeRemoveByPSSysActor(pSSysActor, arrayList);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            this.remove(pSSysUCMapNode);
        }
        this.onAfterRemoveByPSSysActor(pSSysActor, arrayList);
    }

    protected void onAfterRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
    }

    protected void onBeforeRemoveByPSSysActor(PSSysActor pSSysActor, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysActor(PSSysActor pSSysActor, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
    }

    public void resetPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectByPSSysUCMap(pSSysUCMap);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            PSSysUCMapNode pSSysUCMapNode2 = (PSSysUCMapNode)this.getDEModel().createEntity();
            pSSysUCMapNode2.setPSSysUCMapNodeId(pSSysUCMapNode.getPSSysUCMapNodeId());
            pSSysUCMapNode2.setPSSysUCMapId(null);
            this.update(pSSysUCMapNode2);
        }
    }

    public void resetTempPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectTempByPSSysUCMap(pSSysUCMap);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            PSSysUCMapNode pSSysUCMapNode2 = (PSSysUCMapNode)this.getDEModel().createEntity();
            pSSysUCMapNode2.setPSSysUCMapNodeId(pSSysUCMapNode.getPSSysUCMapNodeId());
            pSSysUCMapNode2.setPSSysUCMapId(null);
            this.updateTemp(pSSysUCMapNode2);
        }
    }

    public void removeByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapNodeServiceBase.this.onBeforeRemoveByPSSysUCMap(pSSysUCMap2);
                PSSysUCMapNodeServiceBase.this.internalRemoveByPSSysUCMap(pSSysUCMap2);
                PSSysUCMapNodeServiceBase.this.onAfterRemoveByPSSysUCMap(pSSysUCMap2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
    }

    protected void internalRemoveByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectByPSSysUCMap(pSSysUCMap);
        this.onBeforeRemoveByPSSysUCMap(pSSysUCMap, arrayList);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            this.remove(pSSysUCMapNode);
        }
        this.onAfterRemoveByPSSysUCMap(pSSysUCMap, arrayList);
    }

    protected void onAfterRemoveByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUCMap(PSSysUCMap pSSysUCMap, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUCMap(PSSysUCMap pSSysUCMap, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectByPSSysUserCase(pSSysUserCase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERCASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUserCase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUCMAPNODE_PSSYSUSERCASE_PSSYSUSERCASEID", "", iDataEntityModel.getName(), "PSSYSUCMAPNODE", iDataEntityModel.getDataInfo(pSSysUserCase), arrayList.get(0)));
        }
    }

    public void resetPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            PSSysUCMapNode pSSysUCMapNode2 = (PSSysUCMapNode)this.getDEModel().createEntity();
            pSSysUCMapNode2.setPSSysUCMapNodeId(pSSysUCMapNode.getPSSysUCMapNodeId());
            pSSysUCMapNode2.setPSSysUserCaseId(null);
            this.update(pSSysUCMapNode2);
        }
    }

    public void removeByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        final PSSysUserCase pSSysUserCase2 = pSSysUserCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapNodeServiceBase.this.onBeforeRemoveByPSSysUserCase(pSSysUserCase2);
                PSSysUCMapNodeServiceBase.this.internalRemoveByPSSysUserCase(pSSysUserCase2);
                PSSysUCMapNodeServiceBase.this.onAfterRemoveByPSSysUserCase(pSSysUserCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void internalRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        this.onBeforeRemoveByPSSysUserCase(pSSysUserCase, arrayList);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            this.remove(pSSysUCMapNode);
        }
        this.onAfterRemoveByPSSysUserCase(pSSysUserCase, arrayList);
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUCMapNode pSSysUCMapNode) throws Exception {
        super.onBeforeRemove(pSSysUCMapNode);
    }

    public void removeTempByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapNodeServiceBase.this.onBeforeRemoveTempByPSSysUCMap(pSSysUCMap2);
                PSSysUCMapNodeServiceBase.this.internalRemoveTempByPSSysUCMap(pSSysUCMap2);
                PSSysUCMapNodeServiceBase.this.onAfterRemoveTempByPSSysUCMap(pSSysUCMap2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
    }

    protected void internalRemoveTempByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.selectTempByPSSysUCMap(pSSysUCMap);
        this.onBeforeRemoveTempByPSSysUCMap(pSSysUCMap, arrayList);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            this.removeTemp(pSSysUCMapNode);
        }
        this.onAfterRemoveTempByPSSysUCMap(pSSysUCMap, arrayList);
    }

    protected void onAfterRemoveTempByPSSysUCMap(PSSysUCMap pSSysUCMap) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysUCMap(PSSysUCMap pSSysUCMap, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysUCMap(PSSysUCMap pSSysUCMap, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysUCMapNode pSSysUCMapNode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysUCMapNode, cloneSession);
        if (pSSysUCMapNode.getPSSysActorId() != null && (iEntity = cloneSession.getEntity("PSSYSACTOR", (Object)pSSysUCMapNode.getPSSysActorId())) != null) {
            this.onFillParentInfo_PSSysActor(pSSysUCMapNode, (PSSysActor)iEntity);
        }
        if (pSSysUCMapNode.getPSSysUCMapId() != null && (iEntity = cloneSession.getEntity("PSSYSUCMAP", (Object)pSSysUCMapNode.getPSSysUCMapId())) != null) {
            this.onFillParentInfo_PSSysUCMap(pSSysUCMapNode, (PSSysUCMap)iEntity);
        }
        if (pSSysUCMapNode.getPSSysUserCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERCASE", (Object)pSSysUCMapNode.getPSSysUserCaseId())) != null) {
            this.onFillParentInfo_PSSysUserCase(pSSysUCMapNode, (PSSysUserCase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUCMapNode pSSysUCMapNode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysUCMapNode, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LeftPos(bl, pSSysUCMapNode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeType(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysActorId(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUCMapId(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUCMapNodeId(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUCMapNodeName(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserCaseId(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysUCMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysUCMapNode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isLeftPosDirty() : !pSSysUCMapNode.isLeftPosDirty()) {
            return null;
        }
        Integer n = pSSysUCMapNode.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LeftPos_Default(pSSysUCMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isMemoDirty() : !pSSysUCMapNode.isMemoDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysUCMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_NodeType(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isNodeTypeDirty() && !bl2 : !pSSysUCMapNode.isNodeTypeDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getNodeType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeType_Default(pSSysUCMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysActorId(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isPSSysActorIdDirty() : !pSSysUCMapNode.isPSSysActorIdDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getPSSysActorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysActorId_Default(pSSysUCMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSACTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUCMapId(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isPSSysUCMapIdDirty() : !pSSysUCMapNode.isPSSysUCMapIdDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getPSSysUCMapId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUCMapId_Default(pSSysUCMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUCMapNodeId(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isPSSysUCMapNodeIdDirty() && !bl2 : !pSSysUCMapNode.isPSSysUCMapNodeIdDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getPSSysUCMapNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUCMapNodeId_Default(pSSysUCMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUCMapNodeName(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isPSSysUCMapNodeNameDirty() && !bl2 : !pSSysUCMapNode.isPSSysUCMapNodeNameDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getPSSysUCMapNodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPNODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUCMapNodeName_Default(pSSysUCMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserCaseId(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isPSSysUserCaseIdDirty() : !pSSysUCMapNode.isPSSysUserCaseIdDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getPSSysUserCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserCaseId_Default(pSSysUCMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isTopPosDirty() : !pSSysUCMapNode.isTopPosDirty()) {
            return null;
        }
        Integer n = pSSysUCMapNode.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TopPos_Default(pSSysUCMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isUserCatDirty() : !pSSysUCMapNode.isUserCatDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysUCMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isUserTagDirty() : !pSSysUCMapNode.isUserTagDirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysUCMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isUserTag2Dirty() : !pSSysUCMapNode.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysUCMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isUserTag3Dirty() : !pSSysUCMapNode.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysUCMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysUCMapNode pSSysUCMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMapNode.isUserTag4Dirty() : !pSSysUCMapNode.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysUCMapNode.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysUCMapNode, bl2, bl3);
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

    protected void onSyncEntity(PSSysUCMapNode pSSysUCMapNode, boolean bl) throws Exception {
        super.onSyncEntity(pSSysUCMapNode, bl);
    }

    protected void onSyncIndexEntities(PSSysUCMapNode pSSysUCMapNode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysUCMapNode, bl);
    }

    public Object getDataContextValue(PSSysUCMapNode pSSysUCMapNode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysUCMapNode, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysUCMap pSSysUCMap = pSSysUCMapNode.getPSSysUCMap();
        if (pSSysUCMap != null && pSSysUCMap.contains(string)) {
            return pSSysUCMap.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUCMapNode pSSysUCMapNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysUCMapNode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSACTORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysActorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSACTORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysActorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUCMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUCMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUCMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUCMapName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUCMAPNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUCMapNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUCMAPNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUCMapNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_NodeType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysActorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSACTORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysActorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSACTORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUCMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUCMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUCMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUCMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUCMapNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUCMAPNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUCMapNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUCMAPNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysUCMapNode pSSysUCMapNode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysUCMapNode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUCMapNode pSSysUCMapNode) throws Exception {
        super.onUpdateParent(pSSysUCMapNode);
    }

    @Override
    protected void exportCurXmlModel(PSSysUCMapNode pSSysUCMapNode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUCMAPNODE");
        if (!bl) {
            pSSysUCMapNode.setCreateDate(null);
            pSSysUCMapNode.setCreateMan(null);
            pSSysUCMapNode.setPSSysActorName(null);
            pSSysUCMapNode.setPSSysUCMapName(null);
            pSSysUCMapNode.setPSSysUCMapNodeId(null);
            pSSysUCMapNode.setPSSysUserCaseName(null);
            pSSysUCMapNode.setUpdateDate(null);
            pSSysUCMapNode.setUpdateMan(null);
            pSSysUCMapNode.setPSSysUCMapId(null);
            pSSysUCMapNode.setPSSysUCMapName(null);
            super.exportCurXmlModel(pSSysUCMapNode, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysUCMapNode pSSysUCMapNode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysUCMapNode, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSUCMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSUCMAP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSUCMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUCMAPNODE_PSSYSUCMAP_PSSYSUCMAPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSUCMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSUCMAPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSUCMAP", (boolean)true) == 0) {
            iEntity.set("PSSYSUCMAPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSUCMAPID"};
    }

    @Override
    public String getModelV2Tag(PSSysUCMapNode pSSysUCMapNode) {
        return super.getModelV2Tag(pSSysUCMapNode);
    }

    @Override
    public boolean setModelV2Tag(PSSysUCMapNode pSSysUCMapNode, String string) {
        return super.setModelV2Tag(pSSysUCMapNode, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSUCMAPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysUCMapNode pSSysUCMapNode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysUCMapNode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysUCMapNode, true);
        return super.getModelV2Entity(pSSysUCMapNode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysUCMapNode pSSysUCMapNode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysUCMapNode, objectNode, string, string2, n);
    }
}

