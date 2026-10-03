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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEMapDQDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapDQDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDQ;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapDQServiceBase
extends PSCoreSysServiceBase<PSDEMapDQ> {
    private static final Log log = LogFactory.getLog(PSDEMapDQServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEMapDQDEModel pSDEMapDQDEModel;
    private PSDEMapDQDAO pSDEMapDQDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEMapDQService";
    }

    public PSDEMapDQDEModel getPSDEMapDQDEModel() {
        if (this.pSDEMapDQDEModel == null) {
            try {
                this.pSDEMapDQDEModel = (PSDEMapDQDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapDQDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapDQDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEMapDQDEModel();
    }

    public PSDEMapDQDAO getPSDEMapDQDAO() {
        if (this.pSDEMapDQDAO == null) {
            try {
                this.pSDEMapDQDAO = (PSDEMapDQDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEMapDQDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapDQDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEMapDQDAO();
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

    protected void onFillParentInfo(PSDEMapDQ pSDEMapDQ, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDQ_PSDEDATAQUERY_DSTPSDEDATAQUERYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataQuery);
            } else {
                iService.get(pSDEDataQuery);
            }
            this.onFillParentInfo_DstPSDEDataQuery(pSDEMapDQ, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDQ_PSDEDATAQUERY_PSDEDATAQUERYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataQuery);
            } else {
                iService.get(pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDataQuery(pSDEMapDQ, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapService", (SessionFactory)this.getSessionFactory());
            PSDEMap pSDEMap = (PSDEMap)iService.getDEModel().createEntity();
            pSDEMap.set("PSDEMAPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEMap);
            } else {
                iService.get(pSDEMap);
            }
            this.onFillParentInfo_PSDEMap(pSDEMapDQ, pSDEMap);
            return;
        }
        super.onFillParentInfo(pSDEMapDQ, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDEDataQuery(PSDEMapDQ pSDEMapDQ, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEMapDQ.setDstPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEMapDQ.setDstPSDEDataQueryName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_PSDEDataQuery(PSDEMapDQ pSDEMapDQ, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEMapDQ.setPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEMapDQ.setPSDEDataQueryName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_PSDEMap(PSDEMapDQ pSDEMapDQ, PSDEMap pSDEMap) throws Exception {
        pSDEMapDQ.setDstPSDEId(pSDEMap.getDSTPSDEId());
        pSDEMapDQ.setPSDEId(pSDEMap.getPSDEId());
        pSDEMapDQ.setPSDEMapId(pSDEMap.getPSDEMapId());
        pSDEMapDQ.setPSDEMapName(pSDEMap.getPSDEMapName());
    }

    protected void onFillEntityFullInfo(PSDEMapDQ pSDEMapDQ, boolean bl) throws Exception {
        if (bl && pSDEMapDQ.getValidFlag() == null) {
            pSDEMapDQ.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDEMapDQ, bl);
        this.onFillEntityFullInfo_DstPSDEDataQuery(pSDEMapDQ, bl);
        this.onFillEntityFullInfo_PSDEDataQuery(pSDEMapDQ, bl);
        this.onFillEntityFullInfo_PSDEMap(pSDEMapDQ, bl);
    }

    protected void onFillEntityFullInfo_DstPSDEDataQuery(PSDEMapDQ pSDEMapDQ, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataQuery(PSDEMapDQ pSDEMapDQ, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEMap(PSDEMapDQ pSDEMapDQ, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEMapDQ pSDEMapDQ, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEMapDQ, bl);
    }

    public ArrayList<PSDEMapDQ> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByDstPSDEDataQuery(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEMapDQ> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByDstPSDEDataQuery(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEMapDQ> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATAQUERYID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataQueryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataQueryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapDQ> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDataQuery(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEMapDQ> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDataQuery(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEMapDQ> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATAQUERYID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataQueryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataQueryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapDQ> selectByPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectByPSDEMap(pSDEMapBase, "", -1);
    }

    public ArrayList<PSDEMapDQ> selectByPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        return this.selectByPSDEMap(pSDEMapBase, string, -1);
    }

    public ArrayList<PSDEMapDQ> selectByPSDEMap(PSDEMapBase pSDEMapBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMapDQ> selectTempByPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectTempByPSDEMap(pSDEMapBase, "");
    }

    public ArrayList<PSDEMapDQ> selectTempByPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAPID", (Object)pSDEMapBase.getPSDEMapId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEMapCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEMapCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAPDQ_PSDEDATAQUERY_DSTPSDEDATAQUERYID", "", iDataEntityModel.getName(), "PSDEMAPDQ", iDataEntityModel.getDataInfo(pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            PSDEMapDQ pSDEMapDQ2 = (PSDEMapDQ)this.getDEModel().createEntity();
            pSDEMapDQ2.setPSDEMapDQId(pSDEMapDQ.getPSDEMapDQId());
            pSDEMapDQ2.setDstPSDEDataQueryId(null);
            this.update(pSDEMapDQ2);
        }
    }

    public void removeByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDQServiceBase.this.onBeforeRemoveByDstPSDEDataQuery(pSDEDataQuery2);
                PSDEMapDQServiceBase.this.internalRemoveByDstPSDEDataQuery(pSDEDataQuery2);
                PSDEMapDQServiceBase.this.onAfterRemoveByDstPSDEDataQuery(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery);
        this.onBeforeRemoveByDstPSDEDataQuery(pSDEDataQuery, arrayList);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            this.remove(pSDEMapDQ);
        }
        this.onAfterRemoveByDstPSDEDataQuery(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEMapDQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEMapDQ> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAPDQ_PSDEDATAQUERY_PSDEDATAQUERYID", "", iDataEntityModel.getName(), "PSDEMAPDQ", iDataEntityModel.getDataInfo(pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            PSDEMapDQ pSDEMapDQ2 = (PSDEMapDQ)this.getDEModel().createEntity();
            pSDEMapDQ2.setPSDEMapDQId(pSDEMapDQ.getPSDEMapDQId());
            pSDEMapDQ2.setPSDEDataQueryId(null);
            this.update(pSDEMapDQ2);
        }
    }

    public void removeByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDQServiceBase.this.onBeforeRemoveByPSDEDataQuery(pSDEDataQuery2);
                PSDEMapDQServiceBase.this.internalRemoveByPSDEDataQuery(pSDEDataQuery2);
                PSDEMapDQServiceBase.this.onAfterRemoveByPSDEDataQuery(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDataQuery(pSDEDataQuery, arrayList);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            this.remove(pSDEMapDQ);
        }
        this.onAfterRemoveByPSDEDataQuery(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEMapDQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEMapDQ> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    public void resetPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectByPSDEMap(pSDEMap);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            PSDEMapDQ pSDEMapDQ2 = (PSDEMapDQ)this.getDEModel().createEntity();
            pSDEMapDQ2.setPSDEMapDQId(pSDEMapDQ.getPSDEMapDQId());
            pSDEMapDQ2.setPSDEMapId(null);
            this.update(pSDEMapDQ2);
        }
    }

    public void resetTempPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectTempByPSDEMap(pSDEMap);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            PSDEMapDQ pSDEMapDQ2 = (PSDEMapDQ)this.getDEModel().createEntity();
            pSDEMapDQ2.setPSDEMapDQId(pSDEMapDQ.getPSDEMapDQId());
            pSDEMapDQ2.setPSDEMapId(null);
            this.updateTemp(pSDEMapDQ2);
        }
    }

    public void removeByPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDQServiceBase.this.onBeforeRemoveByPSDEMap(pSDEMap2);
                PSDEMapDQServiceBase.this.internalRemoveByPSDEMap(pSDEMap2);
                PSDEMapDQServiceBase.this.onAfterRemoveByPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectByPSDEMap(pSDEMap);
        this.onBeforeRemoveByPSDEMap(pSDEMap, arrayList);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            this.remove(pSDEMapDQ);
        }
        this.onAfterRemoveByPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDQ> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEMapDQ pSDEMapDQ) throws Exception {
        super.onBeforeRemove(pSDEMapDQ);
    }

    public void removeTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDQServiceBase.this.onBeforeRemoveTempByPSDEMap(pSDEMap2);
                PSDEMapDQServiceBase.this.internalRemoveTempByPSDEMap(pSDEMap2);
                PSDEMapDQServiceBase.this.onAfterRemoveTempByPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDQ> arrayList = this.selectTempByPSDEMap(pSDEMap);
        this.onBeforeRemoveTempByPSDEMap(pSDEMap, arrayList);
        for (PSDEMapDQ pSDEMapDQ : arrayList) {
            this.removeTemp(pSDEMapDQ);
        }
        this.onAfterRemoveTempByPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDQ> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEMapDQ pSDEMapDQ, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEMapDQ, cloneSession);
        if (pSDEMapDQ.getDstPSDEDataQueryId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEMapDQ.getDstPSDEDataQueryId())) != null) {
            this.onFillParentInfo_DstPSDEDataQuery(pSDEMapDQ, (PSDEDataQuery)iEntity);
        }
        if (pSDEMapDQ.getPSDEDataQueryId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEMapDQ.getPSDEDataQueryId())) != null) {
            this.onFillParentInfo_PSDEDataQuery(pSDEMapDQ, (PSDEDataQuery)iEntity);
        }
        if (pSDEMapDQ.getPSDEMapId() != null && (iEntity = cloneSession.getEntity("PSDEMAP", (Object)pSDEMapDQ.getPSDEMapId())) != null) {
            this.onFillParentInfo_PSDEMap(pSDEMapDQ, (PSDEMap)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEMapDQ pSDEMapDQ, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEMapDQ, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DstPSDEDataQueryId(bl, pSDEMapDQ, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDQCond(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapMode(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PropertyMap(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataQueryId(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapDQId(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapDQName(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapId(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEMapDQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEMapDQ, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DstPSDEDataQueryId(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isDstPSDEDataQueryIdDirty() && !bl2 : !pSDEMapDQ.isDstPSDEDataQueryIdDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getDstPSDEDataQueryId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATAQUERYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataQueryId_Default(pSDEMapDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATAQUERYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDQCond(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isEnableDQCondDirty() : !pSDEMapDQ.isEnableDQCondDirty()) {
            return null;
        }
        Integer n = pSDEMapDQ.getEnableDQCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDQCond_Default(pSDEMapDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDQCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapMode(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isMapModeDirty() : !pSDEMapDQ.isMapModeDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getMapMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapMode_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isMemoDirty() : !pSDEMapDQ.isMemoDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_PropertyMap(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isPropertyMapDirty() : !pSDEMapDQ.isPropertyMapDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getPropertyMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PropertyMap_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataQueryId(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isPSDEDataQueryIdDirty() && !bl2 : !pSDEMapDQ.isPSDEDataQueryIdDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getPSDEDataQueryId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAQUERYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataQueryId_Default(pSDEMapDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAQUERYID");
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
                String string4 = this.checkFieldDupRule(this.getPSDEMapDQDEModel(), "PSDEDATAQUERYID", string3, pSDEMapDQ, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDATAQUERYID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapDQId(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isPSDEMapDQIdDirty() && !bl2 : !pSDEMapDQ.isPSDEMapDQIdDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getPSDEMapDQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapDQId_Default(pSDEMapDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapDQName(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isPSDEMapDQNameDirty() && !bl2 : !pSDEMapDQ.isPSDEMapDQNameDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getPSDEMapDQName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDQNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapDQName_Default(pSDEMapDQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDQNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapId(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isPSDEMapIdDirty() : !pSDEMapDQ.isPSDEMapIdDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getPSDEMapId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapId_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isUserCatDirty() : !pSDEMapDQ.isUserCatDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isUserTagDirty() : !pSDEMapDQ.isUserTagDirty()) {
            return null;
        }
        String string = pSDEMapDQ.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isUserTag2Dirty() : !pSDEMapDQ.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEMapDQ.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isUserTag3Dirty() : !pSDEMapDQ.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEMapDQ.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isUserTag4Dirty() : !pSDEMapDQ.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEMapDQ.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEMapDQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEMapDQ pSDEMapDQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDQ.isValidFlagDirty() : !pSDEMapDQ.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEMapDQ.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEMapDQ, bl2, bl3);
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

    protected void onSyncEntity(PSDEMapDQ pSDEMapDQ, boolean bl) throws Exception {
        super.onSyncEntity(pSDEMapDQ, bl);
    }

    protected void onSyncIndexEntities(PSDEMapDQ pSDEMapDQ, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEMapDQ, bl);
    }

    public Object getDataContextValue(PSDEMapDQ pSDEMapDQ, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEMapDQ, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEMap pSDEMap = pSDEMapDQ.getPSDEMap();
        if (pSDEMap != null && pSDEMap.contains(string)) {
            return pSDEMap.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEMapDQ pSDEMapDQ, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEMapDQ, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAQUERYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataQueryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAQUERYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataQueryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDQCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDQCond_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataQueryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataQueryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapDQName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DstPSDEDataQueryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAQUERYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataQueryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAQUERYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_EnableDQCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEDataQueryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAQUERYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataQueryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAQUERYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEMapDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEMapDQ pSDEMapDQ) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEMapDQ)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEMapDQ pSDEMapDQ) throws Exception {
        super.onUpdateParent(pSDEMapDQ);
    }

    @Override
    protected void exportCurXmlModel(PSDEMapDQ pSDEMapDQ, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMAPDQ");
        if (!bl) {
            pSDEMapDQ.setCreateDate(null);
            pSDEMapDQ.setCreateMan(null);
            pSDEMapDQ.setPSDEMapDQId(null);
            pSDEMapDQ.setPSDEMapName(null);
            pSDEMapDQ.setUpdateDate(null);
            pSDEMapDQ.setUpdateMan(null);
            pSDEMapDQ.setDstPSDEId(null);
            pSDEMapDQ.setPSDEId(null);
            pSDEMapDQ.setPSDEMapId(null);
            pSDEMapDQ.setPSDEMapName(null);
            super.exportCurXmlModel(pSDEMapDQ, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEMapDQ pSDEMapDQ, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEMapDQ, string);
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
            return "DER1N_PSDEMAPDQ_PSDEMAP_PSDEMAPID";
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
    public String getModelV2Tag(PSDEMapDQ pSDEMapDQ) {
        return super.getModelV2Tag(pSDEMapDQ);
    }

    @Override
    public boolean setModelV2Tag(PSDEMapDQ pSDEMapDQ, String string) {
        return super.setModelV2Tag(pSDEMapDQ, string);
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
    public boolean getModelV2Entity(PSDEMapDQ pSDEMapDQ, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEMapDQ.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEMapDQ, true);
        return super.getModelV2Entity(pSDEMapDQ, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEMapDQ pSDEMapDQ, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEMapDQ, objectNode, string, string2, n);
    }
}

