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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDSDQDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDSDQDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDSDQServiceBase
extends PSCoreSysServiceBase<PSDEDSDQ> {
    private static final Log log = LogFactory.getLog(PSDEDSDQServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEDSDQDEModel pSDEDSDQDEModel;
    private PSDEDSDQDAO pSDEDSDQDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService";
    }

    public PSDEDSDQDEModel getPSDEDSDQDEModel() {
        if (this.pSDEDSDQDEModel == null) {
            try {
                this.pSDEDSDQDEModel = (PSDEDSDQDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDSDQDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDSDQDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDSDQDEModel();
    }

    public PSDEDSDQDAO getPSDEDSDQDAO() {
        if (this.pSDEDSDQDAO == null) {
            try {
                this.pSDEDSDQDAO = (PSDEDSDQDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDSDQDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDSDQDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDSDQDAO();
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

    protected void onFillParentInfo(PSDEDSDQ pSDEDSDQ, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDSDQ_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataQuery);
            } else {
                iService.get(pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDEDSDQ, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEDSDQ, pSDEDataSet);
            return;
        }
        super.onFillParentInfo(pSDEDSDQ, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", string2);
            return this.onSyncDER1NData_PSDEDataSet(pSDEDataSet, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEDQ(PSDEDSDQ pSDEDSDQ, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEDSDQ.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEDSDQ.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
        pSDEDSDQ.setViewColLevel(pSDEDataQuery.getViewColLevel());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEDSDQ pSDEDSDQ, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEDSDQ.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEDSDQ.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
        pSDEDSDQ.setPSDEId(pSDEDataSet.getPSDEId());
    }

    protected String onSyncDER1NData_PSDEDataSet(PSDEDataSet pSDEDataSet, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEDataSet(pSDEDataSet);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEDSDQ> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
            for (PSDEDSDQ pSDEDSDQ : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEDSDQ, (String)"PSDEDSDQID", (String)""))) continue;
                this.remove(pSDEDSDQ);
            }
        }
        return null;
    }

    protected boolean onFillEntityKeyValue(PSDEDSDQ pSDEDSDQ, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEDSDQ.get("PSDEDATASETID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEDSDQ.get("PSDEDQID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEDSDQ.set(this.getPSDEDSDQDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEDSDQ pSDEDSDQ, boolean bl) throws Exception {
        if (bl && pSDEDSDQ.getOrderValue() == null) {
            pSDEDSDQ.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "100", 9));
        }
        super.onFillEntityFullInfo(pSDEDSDQ, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDEDSDQ, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEDSDQ, bl);
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDEDSDQ pSDEDSDQ, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEDSDQ pSDEDSDQ, boolean bl) throws Exception {
        if (pSDEDSDQ.isPSDEDataSetIdDirty()) {
            if (pSDEDSDQ.getPSDEDataSetId() != null) {
                if (pSDEDSDQ.getPSDEDataSetId() == null || pSDEDSDQ.getPSDEId() == null) {
                    PSDEDataSet pSDEDataSet = pSDEDSDQ.getPSDEDataSet();
                    pSDEDSDQ.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
                    pSDEDSDQ.setPSDEId(pSDEDataSet.getPSDEId());
                }
            } else {
                pSDEDSDQ.setPSDEDataSetName(null);
                pSDEDSDQ.setPSDEId(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEDSDQ pSDEDSDQ, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEDSDQ, bl);
    }

    public ArrayList<PSDEDSDQ> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEDSDQ> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEDSDQ> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDSDQ> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEDSDQ> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEDSDQ> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDSDQ> selectTempByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectTempByPSDEDataSet(pSDEDataSetBase, "");
    }

    public ArrayList<PSDEDSDQ> selectTempByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEDataSetCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDSDQ> arrayList = this.selectByPSDEDQ(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDSDQ_PSDEDATAQUERY_PSDEDQID", "", iDataEntityModel.getName(), "PSDEDSDQ", iDataEntityModel.getDataInfo(pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDSDQ> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            PSDEDSDQ pSDEDSDQ2 = (PSDEDSDQ)this.getDEModel().createEntity();
            pSDEDSDQ2.setPSDEDSDQId(pSDEDSDQ.getPSDEDSDQId());
            pSDEDSDQ2.setPSDEDQId(null);
            this.update(pSDEDSDQ2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDSDQServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEDSDQServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEDSDQServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDSDQ> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            this.remove(pSDEDSDQ);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDSDQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDSDQ> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDSDQ> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            PSDEDSDQ pSDEDSDQ2 = (PSDEDSDQ)this.getDEModel().createEntity();
            pSDEDSDQ2.setPSDEDSDQId(pSDEDSDQ.getPSDEDSDQId());
            pSDEDSDQ2.setPSDEDataSetId(null);
            this.update(pSDEDSDQ2);
        }
    }

    public void resetTempPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDSDQ> arrayList = this.selectTempByPSDEDataSet(pSDEDataSet);
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            PSDEDSDQ pSDEDSDQ2 = (PSDEDSDQ)this.getDEModel().createEntity();
            pSDEDSDQ2.setPSDEDSDQId(pSDEDSDQ.getPSDEDSDQId());
            pSDEDSDQ2.setPSDEDataSetId(null);
            this.updateTemp(pSDEDSDQ2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDSDQServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEDSDQServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEDSDQServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDSDQ> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            this.remove(pSDEDSDQ);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDSDQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDSDQ> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDSDQ pSDEDSDQ) throws Exception {
        super.onBeforeRemove(pSDEDSDQ);
    }

    public void removeTempByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDSDQServiceBase.this.onBeforeRemoveTempByPSDEDataSet(pSDEDataSet2);
                PSDEDSDQServiceBase.this.internalRemoveTempByPSDEDataSet(pSDEDataSet2);
                PSDEDSDQServiceBase.this.onAfterRemoveTempByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveTempByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDSDQ> arrayList = this.selectTempByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveTempByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            this.removeTemp(pSDEDSDQ);
        }
        this.onAfterRemoveTempByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveTempByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDSDQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDSDQ> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEDSDQ pSDEDSDQ, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEDSDQ, cloneSession);
        if (pSDEDSDQ.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEDSDQ.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDEDSDQ, (PSDEDataQuery)iEntity);
        }
        if (pSDEDSDQ.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEDSDQ.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEDSDQ, (PSDEDataSet)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDSDQ pSDEDSDQ, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEDSDQ, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDSDQ, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDSDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDSDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEDSDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDEDSDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSDQId(bl, pSDEDSDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSDQName(bl, pSDEDSDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDSDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDSDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEDSDQ, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isDynaModelFlagDirty() : !pSDEDSDQ.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDSDQ.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEDSDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isMemoDirty() : !pSDEDSDQ.isMemoDirty()) {
            return null;
        }
        String string = pSDEDSDQ.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEDSDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isOrderValueDirty() : !pSDEDSDQ.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDSDQ.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEDSDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isPSDEDataSetIdDirty() && !bl2 : !pSDEDSDQ.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEDSDQ.getPSDEDataSetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default(pSDEDSDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isPSDEDQIdDirty() && !bl2 : !pSDEDSDQ.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDEDSDQ.getPSDEDQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_Default(pSDEDSDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSDQId(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isPSDEDSDQIdDirty() && !bl2 : !pSDEDSDQ.isPSDEDSDQIdDirty()) {
            return null;
        }
        String string = pSDEDSDQ.getPSDEDSDQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSDQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSDQId_Default(pSDEDSDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSDQName(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isPSDEDSDQNameDirty() : !pSDEDSDQ.isPSDEDSDQNameDirty()) {
            return null;
        }
        String string = pSDEDSDQ.getPSDEDSDQName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSDQName_Default(pSDEDSDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSDQNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isPSDEIdDirty() : !pSDEDSDQ.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDSDQ.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEDSDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDSDQ pSDEDSDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDSDQ.isPSDynaInstIdDirty() : !pSDEDSDQ.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDSDQ.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEDSDQ, bl2, bl3);
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

    protected void onSyncEntity(PSDEDSDQ pSDEDSDQ, boolean bl) throws Exception {
        super.onSyncEntity(pSDEDSDQ, bl);
    }

    protected void onSyncIndexEntities(PSDEDSDQ pSDEDSDQ, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEDSDQ, bl);
    }

    public Object getDataContextValue(PSDEDSDQ pSDEDSDQ, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEDSDQ, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEDataQuery pSDEDataQuery = pSDEDSDQ.getPSDEDQ();
        if (pSDEDataQuery != null && pSDEDataQuery.contains(string)) {
            return pSDEDataQuery.get(string);
        }
        PSDEDataSet pSDEDataSet = pSDEDSDQ.getPSDEDataSet();
        if (pSDEDataSet != null && pSDEDataSet.contains(string)) {
            return pSDEDataSet.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDSDQ pSDEDSDQ, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEDSDQ, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSDQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWCOLLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewColLevel_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ViewColLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDSDQ pSDEDSDQ) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEDSDQ)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDSDQ pSDEDSDQ) throws Exception {
        super.onUpdateParent(pSDEDSDQ);
    }

    @Override
    protected void exportCurXmlModel(PSDEDSDQ pSDEDSDQ, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDSDQ");
        if (!bl) {
            pSDEDSDQ.setCreateDate(null);
            pSDEDSDQ.setCreateMan(null);
            pSDEDSDQ.setPSDEDataSetId(null);
            pSDEDSDQ.setPSDEDSDQId(null);
            pSDEDSDQ.setPSDEId(null);
            pSDEDSDQ.setUpdateDate(null);
            pSDEDSDQ.setUpdateMan(null);
            pSDEDSDQ.setPSDEDataSetId(null);
            pSDEDSDQ.setPSDEDataSetName(null);
            pSDEDSDQ.setPSDEId(null);
            super.exportCurXmlModel(pSDEDSDQ, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEDSDQ pSDEDSDQ, PSSystem pSSystem) throws Exception {
        PSDEDSDQ pSDEDSDQ2 = new PSDEDSDQ();
        pSDEDSDQ2.setPSDEDataSetId(pSDEDSDQ.getPSDEDataSetId());
        pSDEDSDQ2.setPSDEDQId(pSDEDSDQ.getPSDEDQId());
        if (this.selectOne(pSDEDSDQ2, true)) {
            return pSDEDSDQ2.getPSDEDSDQId();
        }
        return super.getEntityFolderKeyValue(pSDEDSDQ, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDSDQ pSDEDSDQ, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDSDQ, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDATASETID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDATASET#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDATASETID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDATASETID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDATASETNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEDATASET", (boolean)true) == 0) {
            iEntity.set("PSDEDATASETID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEDATASETID"};
    }

    @Override
    public String getModelV2Tag(PSDEDSDQ pSDEDSDQ) {
        return super.getModelV2Tag(pSDEDSDQ);
    }

    @Override
    public boolean setModelV2Tag(PSDEDSDQ pSDEDSDQ, String string) {
        return super.setModelV2Tag(pSDEDSDQ, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEDATASETID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDSDQ pSDEDSDQ, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDSDQ.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDSDQ, true);
        return super.getModelV2Entity(pSDEDSDQ, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDSDQ pSDEDSDQ, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEDSDQ, objectNode, string, string2, n);
    }
}

