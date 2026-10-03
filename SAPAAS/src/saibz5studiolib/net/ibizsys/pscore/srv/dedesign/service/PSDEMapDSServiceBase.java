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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEMapDSDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapDSDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDS;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapDSServiceBase
extends PSCoreSysServiceBase<PSDEMapDS> {
    private static final Log log = LogFactory.getLog(PSDEMapDSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEMapDSDEModel pSDEMapDSDEModel;
    private PSDEMapDSDAO pSDEMapDSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEMapDSService";
    }

    public PSDEMapDSDEModel getPSDEMapDSDEModel() {
        if (this.pSDEMapDSDEModel == null) {
            try {
                this.pSDEMapDSDEModel = (PSDEMapDSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapDSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapDSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEMapDSDEModel();
    }

    public PSDEMapDSDAO getPSDEMapDSDAO() {
        if (this.pSDEMapDSDAO == null) {
            try {
                this.pSDEMapDSDAO = (PSDEMapDSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEMapDSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapDSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEMapDSDAO();
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

    protected void onFillParentInfo(PSDEMapDS pSDEMapDS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDS_PSDEDATASET_DSTPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_DstPSDEDataSet(pSDEMapDS, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDS_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEMapDS, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapService", (SessionFactory)this.getSessionFactory());
            PSDEMap pSDEMap = (PSDEMap)iService.getDEModel().createEntity();
            pSDEMap.set("PSDEMAPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEMap);
            } else {
                iService.get(pSDEMap);
            }
            this.onFillParentInfo_PSDEMap(pSDEMapDS, pSDEMap);
            return;
        }
        super.onFillParentInfo(pSDEMapDS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDEDataSet(PSDEMapDS pSDEMapDS, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEMapDS.setDstPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEMapDS.setDstPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEMapDS pSDEMapDS, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEMapDS.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEMapDS.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEMap(PSDEMapDS pSDEMapDS, PSDEMap pSDEMap) throws Exception {
        pSDEMapDS.setDstPSDEId(pSDEMap.getDSTPSDEId());
        pSDEMapDS.setPSDEId(pSDEMap.getPSDEId());
        pSDEMapDS.setPSDEMapId(pSDEMap.getPSDEMapId());
        pSDEMapDS.setPSDEMapName(pSDEMap.getPSDEMapName());
    }

    protected void onFillEntityFullInfo(PSDEMapDS pSDEMapDS, boolean bl) throws Exception {
        if (bl && pSDEMapDS.getValidFlag() == null) {
            pSDEMapDS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDEMapDS, bl);
        this.onFillEntityFullInfo_DstPSDEDataSet(pSDEMapDS, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEMapDS, bl);
        this.onFillEntityFullInfo_PSDEMap(pSDEMapDS, bl);
    }

    protected void onFillEntityFullInfo_DstPSDEDataSet(PSDEMapDS pSDEMapDS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEMapDS pSDEMapDS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEMap(PSDEMapDS pSDEMapDS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEMapDS pSDEMapDS, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEMapDS, bl);
    }

    public ArrayList<PSDEMapDS> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByDstPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEMapDS> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByDstPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEMapDS> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapDS> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEMapDS> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEMapDS> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMapDS> selectByPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectByPSDEMap(pSDEMapBase, "", -1);
    }

    public ArrayList<PSDEMapDS> selectByPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        return this.selectByPSDEMap(pSDEMapBase, string, -1);
    }

    public ArrayList<PSDEMapDS> selectByPSDEMap(PSDEMapBase pSDEMapBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMapDS> selectTempByPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectTempByPSDEMap(pSDEMapBase, "");
    }

    public ArrayList<PSDEMapDS> selectTempByPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAPID", (Object)pSDEMapBase.getPSDEMapId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEMapCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEMapCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAPDS_PSDEDATASET_DSTPSDEDATASETID", "", iDataEntityModel.getName(), "PSDEMAPDS", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            PSDEMapDS pSDEMapDS2 = (PSDEMapDS)this.getDEModel().createEntity();
            pSDEMapDS2.setPSDEMapDSId(pSDEMapDS.getPSDEMapDSId());
            pSDEMapDS2.setDstPSDEDataSetId(null);
            this.update(pSDEMapDS2);
        }
    }

    public void removeByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDSServiceBase.this.onBeforeRemoveByDstPSDEDataSet(pSDEDataSet2);
                PSDEMapDSServiceBase.this.internalRemoveByDstPSDEDataSet(pSDEDataSet2);
                PSDEMapDSServiceBase.this.onAfterRemoveByDstPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByDstPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            this.remove(pSDEMapDS);
        }
        this.onAfterRemoveByDstPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEMapDS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEMapDS> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAPDS_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDEMAPDS", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            PSDEMapDS pSDEMapDS2 = (PSDEMapDS)this.getDEModel().createEntity();
            pSDEMapDS2.setPSDEMapDSId(pSDEMapDS.getPSDEMapDSId());
            pSDEMapDS2.setPSDEDataSetId(null);
            this.update(pSDEMapDS2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDSServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEMapDSServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEMapDSServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            this.remove(pSDEMapDS);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEMapDS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEMapDS> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    public void resetPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectByPSDEMap(pSDEMap);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            PSDEMapDS pSDEMapDS2 = (PSDEMapDS)this.getDEModel().createEntity();
            pSDEMapDS2.setPSDEMapDSId(pSDEMapDS.getPSDEMapDSId());
            pSDEMapDS2.setPSDEMapId(null);
            this.update(pSDEMapDS2);
        }
    }

    public void resetTempPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectTempByPSDEMap(pSDEMap);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            PSDEMapDS pSDEMapDS2 = (PSDEMapDS)this.getDEModel().createEntity();
            pSDEMapDS2.setPSDEMapDSId(pSDEMapDS.getPSDEMapDSId());
            pSDEMapDS2.setPSDEMapId(null);
            this.updateTemp(pSDEMapDS2);
        }
    }

    public void removeByPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDSServiceBase.this.onBeforeRemoveByPSDEMap(pSDEMap2);
                PSDEMapDSServiceBase.this.internalRemoveByPSDEMap(pSDEMap2);
                PSDEMapDSServiceBase.this.onAfterRemoveByPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectByPSDEMap(pSDEMap);
        this.onBeforeRemoveByPSDEMap(pSDEMap, arrayList);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            this.remove(pSDEMapDS);
        }
        this.onAfterRemoveByPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEMapDS pSDEMapDS) throws Exception {
        super.onBeforeRemove(pSDEMapDS);
    }

    public void removeTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDSServiceBase.this.onBeforeRemoveTempByPSDEMap(pSDEMap2);
                PSDEMapDSServiceBase.this.internalRemoveTempByPSDEMap(pSDEMap2);
                PSDEMapDSServiceBase.this.onAfterRemoveTempByPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDS> arrayList = this.selectTempByPSDEMap(pSDEMap);
        this.onBeforeRemoveTempByPSDEMap(pSDEMap, arrayList);
        for (PSDEMapDS pSDEMapDS : arrayList) {
            this.removeTemp(pSDEMapDS);
        }
        this.onAfterRemoveTempByPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDS> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDS> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEMapDS pSDEMapDS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEMapDS, cloneSession);
        if (pSDEMapDS.getDstPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEMapDS.getDstPSDEDataSetId())) != null) {
            this.onFillParentInfo_DstPSDEDataSet(pSDEMapDS, (PSDEDataSet)iEntity);
        }
        if (pSDEMapDS.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEMapDS.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEMapDS, (PSDEDataSet)iEntity);
        }
        if (pSDEMapDS.getPSDEMapId() != null && (iEntity = cloneSession.getEntity("PSDEMAP", (Object)pSDEMapDS.getPSDEMapId())) != null) {
            this.onFillParentInfo_PSDEMap(pSDEMapDS, (PSDEMap)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEMapDS pSDEMapDS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEMapDS, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DstPSDEDataSetId(bl, pSDEMapDS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDQCond(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapMode(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PropertyMap(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapDSId(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapDSName(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapId(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEMapDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEMapDS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DstPSDEDataSetId(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isDstPSDEDataSetIdDirty() : !pSDEMapDS.isDstPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEMapDS.getDstPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataSetId_Default(pSDEMapDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDQCond(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isEnableDQCondDirty() : !pSDEMapDS.isEnableDQCondDirty()) {
            return null;
        }
        Integer n = pSDEMapDS.getEnableDQCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDQCond_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_MapMode(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isMapModeDirty() : !pSDEMapDS.isMapModeDirty()) {
            return null;
        }
        String string = pSDEMapDS.getMapMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapMode_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isMemoDirty() : !pSDEMapDS.isMemoDirty()) {
            return null;
        }
        String string = pSDEMapDS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PropertyMap(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isPropertyMapDirty() : !pSDEMapDS.isPropertyMapDirty()) {
            return null;
        }
        String string = pSDEMapDS.getPropertyMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PropertyMap_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isPSDEDataSetIdDirty() && !bl2 : !pSDEMapDS.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEMapDS.getPSDEDataSetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default(pSDEMapDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
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
                String string4 = this.checkFieldDupRule(this.getPSDEMapDSDEModel(), "PSDEDATASETID", string3, pSDEMapDS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDATASETID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapDSId(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isPSDEMapDSIdDirty() && !bl2 : !pSDEMapDS.isPSDEMapDSIdDirty()) {
            return null;
        }
        String string = pSDEMapDS.getPSDEMapDSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapDSId_Default(pSDEMapDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapDSName(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isPSDEMapDSNameDirty() && !bl2 : !pSDEMapDS.isPSDEMapDSNameDirty()) {
            return null;
        }
        String string = pSDEMapDS.getPSDEMapDSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapDSName_Default(pSDEMapDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapId(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isPSDEMapIdDirty() : !pSDEMapDS.isPSDEMapIdDirty()) {
            return null;
        }
        String string = pSDEMapDS.getPSDEMapId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapId_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isUserCatDirty() : !pSDEMapDS.isUserCatDirty()) {
            return null;
        }
        String string = pSDEMapDS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isUserTagDirty() : !pSDEMapDS.isUserTagDirty()) {
            return null;
        }
        String string = pSDEMapDS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isUserTag2Dirty() : !pSDEMapDS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEMapDS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isUserTag3Dirty() : !pSDEMapDS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEMapDS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isUserTag4Dirty() : !pSDEMapDS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEMapDS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEMapDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEMapDS pSDEMapDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDS.isValidFlagDirty() : !pSDEMapDS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEMapDS.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEMapDS, bl2, bl3);
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

    protected void onSyncEntity(PSDEMapDS pSDEMapDS, boolean bl) throws Exception {
        super.onSyncEntity(pSDEMapDS, bl);
    }

    protected void onSyncIndexEntities(PSDEMapDS pSDEMapDS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEMapDS, bl);
    }

    public Object getDataContextValue(PSDEMapDS pSDEMapDS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEMapDS, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEMapDS pSDEMapDS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEMapDS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataSetName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapDSName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DstPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEMapDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEMapDS pSDEMapDS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEMapDS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEMapDS pSDEMapDS) throws Exception {
        super.onUpdateParent(pSDEMapDS);
    }

    @Override
    protected void exportCurXmlModel(PSDEMapDS pSDEMapDS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMAPDS");
        if (!bl) {
            pSDEMapDS.setCreateDate(null);
            pSDEMapDS.setCreateMan(null);
            pSDEMapDS.setPSDEMapDSId(null);
            pSDEMapDS.setPSDEMapName(null);
            pSDEMapDS.setUpdateDate(null);
            pSDEMapDS.setUpdateMan(null);
            pSDEMapDS.setDstPSDEId(null);
            pSDEMapDS.setPSDEId(null);
            pSDEMapDS.setPSDEMapId(null);
            pSDEMapDS.setPSDEMapName(null);
            super.exportCurXmlModel(pSDEMapDS, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEMapDS pSDEMapDS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEMapDS, string);
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
            return "DER1N_PSDEMAPDS_PSDEMAP_PSDEMAPID";
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
    public String getModelV2Tag(PSDEMapDS pSDEMapDS) {
        return super.getModelV2Tag(pSDEMapDS);
    }

    @Override
    public boolean setModelV2Tag(PSDEMapDS pSDEMapDS, String string) {
        return super.setModelV2Tag(pSDEMapDS, string);
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
    public boolean getModelV2Entity(PSDEMapDS pSDEMapDS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEMapDS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEMapDS, true);
        return super.getModelV2Entity(pSDEMapDS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEMapDS pSDEMapDS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEMapDS, objectNode, string, string2, n);
    }
}

