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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEMapActionDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapActionDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapActionServiceBase
extends PSCoreSysServiceBase<PSDEMapAction> {
    private static final Log log = LogFactory.getLog(PSDEMapActionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEMapActionDEModel pSDEMapActionDEModel;
    private PSDEMapActionDAO pSDEMapActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEMapActionService";
    }

    public PSDEMapActionDEModel getPSDEMapActionDEModel() {
        if (this.pSDEMapActionDEModel == null) {
            try {
                this.pSDEMapActionDEModel = (PSDEMapActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEMapActionDEModel();
    }

    public PSDEMapActionDAO getPSDEMapActionDAO() {
        if (this.pSDEMapActionDAO == null) {
            try {
                this.pSDEMapActionDAO = (PSDEMapActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEMapActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEMapActionDAO();
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

    protected void onFillParentInfo(PSDEMapAction pSDEMapAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPACTION_PSDEACTION_DSTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_DstPSDEAction(pSDEMapAction, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPACTION_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEMapAction, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapService", (SessionFactory)this.getSessionFactory());
            PSDEMap pSDEMap = (PSDEMap)iService.getDEModel().createEntity();
            pSDEMap.set("PSDEMAPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEMap);
            } else {
                iService.get((IEntity)pSDEMap);
            }
            this.onFillParentInfo_PSDEMap(pSDEMapAction, pSDEMap);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEMapAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDEAction(PSDEMapAction pSDEMapAction, PSDEAction pSDEAction) throws Exception {
        pSDEMapAction.setDstPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEMapAction.setDstPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEAction(PSDEMapAction pSDEMapAction, PSDEAction pSDEAction) throws Exception {
        pSDEMapAction.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEMapAction.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEMap(PSDEMapAction pSDEMapAction, PSDEMap pSDEMap) throws Exception {
        pSDEMapAction.setDstPSDEId(pSDEMap.getDSTPSDEId());
        pSDEMapAction.setPSDEId(pSDEMap.getPSDEId());
        pSDEMapAction.setPSDEMapId(pSDEMap.getPSDEMapId());
        pSDEMapAction.setPSDEMapName(pSDEMap.getPSDEMapName());
    }

    protected void onFillEntityFullInfo(PSDEMapAction pSDEMapAction, boolean bl) throws Exception {
        if (bl && pSDEMapAction.getValidFlag() == null) {
            pSDEMapAction.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEMapAction, bl);
        this.onFillEntityFullInfo_DstPSDEAction(pSDEMapAction, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEMapAction, bl);
        this.onFillEntityFullInfo_PSDEMap(pSDEMapAction, bl);
    }

    protected void onFillEntityFullInfo_DstPSDEAction(PSDEMapAction pSDEMapAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEMapAction pSDEMapAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEMap(PSDEMapAction pSDEMapAction, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEMapAction pSDEMapAction, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEMapAction, bl);
    }

    public ArrayList<PSDEMapAction> selectByDstPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByDstPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEMapAction> selectByDstPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByDstPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEMapAction> selectByDstPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapAction> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEMapAction> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEMapAction> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapAction> selectByPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectByPSDEMap(pSDEMapBase, "", -1);
    }

    public ArrayList<PSDEMapAction> selectByPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        return this.selectByPSDEMap(pSDEMapBase, string, -1);
    }

    public ArrayList<PSDEMapAction> selectByPSDEMap(PSDEMapBase pSDEMapBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAPID", (Object)pSDEMapBase.getPSDEMapId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMapCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMapCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapAction> selectTempByPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectTempByPSDEMap(pSDEMapBase, "");
    }

    public ArrayList<PSDEMapAction> selectTempByPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAPID", (Object)pSDEMapBase.getPSDEMapId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEMapCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEMapCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectByDstPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAPACTION_PSDEACTION_DSTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEMAPACTION", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectByDstPSDEAction(pSDEAction);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            PSDEMapAction pSDEMapAction2 = (PSDEMapAction)this.getDEModel().createEntity();
            pSDEMapAction2.setPSDEMapActionId(pSDEMapAction.getPSDEMapActionId());
            pSDEMapAction2.setDstPSDEActionId(null);
            this.update(pSDEMapAction2);
        }
    }

    public void removeByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapActionServiceBase.this.onBeforeRemoveByDstPSDEAction(pSDEAction2);
                PSDEMapActionServiceBase.this.internalRemoveByDstPSDEAction(pSDEAction2);
                PSDEMapActionServiceBase.this.onAfterRemoveByDstPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectByDstPSDEAction(pSDEAction);
        this.onBeforeRemoveByDstPSDEAction(pSDEAction, arrayList);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            this.remove((IEntity)pSDEMapAction);
        }
        this.onAfterRemoveByDstPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEMapAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEMapAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAPACTION_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDEMAPACTION", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            PSDEMapAction pSDEMapAction2 = (PSDEMapAction)this.getDEModel().createEntity();
            pSDEMapAction2.setPSDEMapActionId(pSDEMapAction.getPSDEMapActionId());
            pSDEMapAction2.setPSDEActionId(null);
            this.update(pSDEMapAction2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapActionServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEMapActionServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEMapActionServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            this.remove((IEntity)pSDEMapAction);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEMapAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEMapAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    public void resetPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectByPSDEMap(pSDEMap);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            PSDEMapAction pSDEMapAction2 = (PSDEMapAction)this.getDEModel().createEntity();
            pSDEMapAction2.setPSDEMapActionId(pSDEMapAction.getPSDEMapActionId());
            pSDEMapAction2.setPSDEMapId(null);
            this.update(pSDEMapAction2);
        }
    }

    public void resetTempPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectTempByPSDEMap(pSDEMap);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            PSDEMapAction pSDEMapAction2 = (PSDEMapAction)this.getDEModel().createEntity();
            pSDEMapAction2.setPSDEMapActionId(pSDEMapAction.getPSDEMapActionId());
            pSDEMapAction2.setPSDEMapId(null);
            this.updateTemp((IEntity)pSDEMapAction2);
        }
    }

    public void removeByPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapActionServiceBase.this.onBeforeRemoveByPSDEMap(pSDEMap2);
                PSDEMapActionServiceBase.this.internalRemoveByPSDEMap(pSDEMap2);
                PSDEMapActionServiceBase.this.onAfterRemoveByPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectByPSDEMap(pSDEMap);
        this.onBeforeRemoveByPSDEMap(pSDEMap, arrayList);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            this.remove((IEntity)pSDEMapAction);
        }
        this.onAfterRemoveByPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEMapAction pSDEMapAction) throws Exception {
        super.onBeforeRemove(pSDEMapAction);
    }

    public void removeTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapActionServiceBase.this.onBeforeRemoveTempByPSDEMap(pSDEMap2);
                PSDEMapActionServiceBase.this.internalRemoveTempByPSDEMap(pSDEMap2);
                PSDEMapActionServiceBase.this.onAfterRemoveTempByPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapAction> arrayList = this.selectTempByPSDEMap(pSDEMap);
        this.onBeforeRemoveTempByPSDEMap(pSDEMap, arrayList);
        for (PSDEMapAction pSDEMapAction : arrayList) {
            this.removeTemp((IEntity)pSDEMapAction);
        }
        this.onAfterRemoveTempByPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapAction> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEMapAction pSDEMapAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEMapAction, cloneSession);
        if (pSDEMapAction.getDstPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEMapAction.getDstPSDEActionId())) != null) {
            this.onFillParentInfo_DstPSDEAction(pSDEMapAction, (PSDEAction)iEntity);
        }
        if (pSDEMapAction.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEMapAction.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEMapAction, (PSDEAction)iEntity);
        }
        if (pSDEMapAction.getPSDEMapId() != null && (iEntity = cloneSession.getEntity("PSDEMAP", (Object)pSDEMapAction.getPSDEMapId())) != null) {
            this.onFillParentInfo_PSDEMap(pSDEMapAction, (PSDEMap)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEMapAction pSDEMapAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEMapAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DstPSDEActionId(bl, pSDEMapAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapMode(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PropertyMap(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapActionId(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapActionName(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapId(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEMapAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEMapAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DstPSDEActionId(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isDstPSDEActionIdDirty() : !pSDEMapAction.isDstPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEMapAction.getDstPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEActionId_Default((IEntity)pSDEMapAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapMode(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isMapModeDirty() : !pSDEMapAction.isMapModeDirty()) {
            return null;
        }
        String string = pSDEMapAction.getMapMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapMode_Default((IEntity)pSDEMapAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isMemoDirty() : !pSDEMapAction.isMemoDirty()) {
            return null;
        }
        String string = pSDEMapAction.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEMapAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PropertyMap(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isPropertyMapDirty() : !pSDEMapAction.isPropertyMapDirty()) {
            return null;
        }
        String string = pSDEMapAction.getPropertyMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PropertyMap_Default((IEntity)pSDEMapAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROPERTYMAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isPSDEActionIdDirty() : !pSDEMapAction.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEMapAction.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default((IEntity)pSDEMapAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
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
                string3 = "PSDEMAPID";
                String string4 = this.checkFieldDupRule(this.getPSDEMapActionDEModel(), "PSDEACTIONID", string3, pSDEMapAction, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEACTIONID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapActionId(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isPSDEMapActionIdDirty() && !bl2 : !pSDEMapAction.isPSDEMapActionIdDirty()) {
            return null;
        }
        String string = pSDEMapAction.getPSDEMapActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapActionId_Default((IEntity)pSDEMapAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapActionName(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isPSDEMapActionNameDirty() && !bl2 : !pSDEMapAction.isPSDEMapActionNameDirty()) {
            return null;
        }
        String string = pSDEMapAction.getPSDEMapActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapActionName_Default((IEntity)pSDEMapAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapId(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isPSDEMapIdDirty() : !pSDEMapAction.isPSDEMapIdDirty()) {
            return null;
        }
        String string = pSDEMapAction.getPSDEMapId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapId_Default((IEntity)pSDEMapAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isUserCatDirty() : !pSDEMapAction.isUserCatDirty()) {
            return null;
        }
        String string = pSDEMapAction.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEMapAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isUserTagDirty() : !pSDEMapAction.isUserTagDirty()) {
            return null;
        }
        String string = pSDEMapAction.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEMapAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isUserTag2Dirty() : !pSDEMapAction.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEMapAction.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEMapAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isUserTag3Dirty() : !pSDEMapAction.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEMapAction.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEMapAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isUserTag4Dirty() : !pSDEMapAction.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEMapAction.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEMapAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEMapAction pSDEMapAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapAction.isValidFlagDirty() : !pSDEMapAction.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEMapAction.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEMapAction, bl2, bl3);
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

    protected void onSyncEntity(PSDEMapAction pSDEMapAction, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEMapAction, bl);
    }

    protected void onSyncIndexEntities(PSDEMapAction pSDEMapAction, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEMapAction, bl);
    }

    public Object getDataContextValue(PSDEMapAction pSDEMapAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEMapAction, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEMap pSDEMap = pSDEMapAction.getPSDEMap();
        if (pSDEMap != null && pSDEMap.contains(string)) {
            return pSDEMap.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEMapAction pSDEMapAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEMapAction, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROPERTYMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PropertyMap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DstPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PropertyMap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROPERTYMAP", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDEMapActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEMapAction pSDEMapAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEMapAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEMapAction pSDEMapAction) throws Exception {
        super.onUpdateParent((IEntity)pSDEMapAction);
    }

    @Override
    protected void exportCurXmlModel(PSDEMapAction pSDEMapAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMAPACTION");
        if (!bl) {
            pSDEMapAction.setCreateDate(null);
            pSDEMapAction.setCreateMan(null);
            pSDEMapAction.setPSDEMapActionId(null);
            pSDEMapAction.setPSDEMapName(null);
            pSDEMapAction.setUpdateDate(null);
            pSDEMapAction.setUpdateMan(null);
            pSDEMapAction.setDstPSDEId(null);
            pSDEMapAction.setPSDEId(null);
            pSDEMapAction.setPSDEMapId(null);
            pSDEMapAction.setPSDEMapName(null);
            super.exportCurXmlModel(pSDEMapAction, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEMapAction pSDEMapAction, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEMapAction, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEMAP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEMAPACTION_PSDEMAP_PSDEMAPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEMAP", (boolean)true) == 0) {
            iEntity.set("PSDEMAPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEMAPID"};
    }

    @Override
    public String getModelV2Tag(PSDEMapAction pSDEMapAction) {
        return super.getModelV2Tag(pSDEMapAction);
    }

    @Override
    public boolean setModelV2Tag(PSDEMapAction pSDEMapAction, String string) {
        return super.setModelV2Tag(pSDEMapAction, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEMAPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEMapAction pSDEMapAction, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEMapAction.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEMapAction, true);
        return super.getModelV2Entity(pSDEMapAction, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEMapAction pSDEMapAction, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEMapAction, objectNode, string, string2, n);
    }
}

