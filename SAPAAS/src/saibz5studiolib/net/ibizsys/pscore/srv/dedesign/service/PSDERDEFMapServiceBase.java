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
import net.ibizsys.pscore.srv.dedesign.dao.PSDERDEFMapDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEFMapDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERDEFMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERDEFMapServiceBase
extends PSCoreSysServiceBase<PSDERDEFMap> {
    private static final Log log = LogFactory.getLog(PSDERDEFMapServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDERDEFMapDEModel pSDERDEFMapDEModel;
    private PSDERDEFMapDAO pSDERDEFMapDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService";
    }

    public PSDERDEFMapDEModel getPSDERDEFMapDEModel() {
        if (this.pSDERDEFMapDEModel == null) {
            try {
                this.pSDERDEFMapDEModel = (PSDERDEFMapDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEFMapDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERDEFMapDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDERDEFMapDEModel();
    }

    public PSDERDEFMapDAO getPSDERDEFMapDAO() {
        if (this.pSDERDEFMapDAO == null) {
            try {
                this.pSDERDEFMapDAO = (PSDERDEFMapDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDERDEFMapDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERDEFMapDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDERDEFMapDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDERDEFMap pSDERDEFMap, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERDEFMAP_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataQuery);
            } else {
                iService.get(pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDERDEFMap, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERDEFMAP_PSDEFIELD_MAJORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_MajorPSDEF(pSDERDEFMap, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERDEFMAP_PSDEFIELD_MINORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_MinorPSDEF(pSDERDEFMap, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERDEFMAP_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSDERDEFMap, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERDEFMAP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDERDEFMap, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo(pSDERDEFMap, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEDQ(PSDERDEFMap pSDERDEFMap, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDERDEFMap.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDERDEFMap.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_MajorPSDEF(PSDERDEFMap pSDERDEFMap, PSDEField pSDEField) throws Exception {
        pSDERDEFMap.setMajorPSDEFId(pSDEField.getPSDEFieldId());
        pSDERDEFMap.setMajorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MinorPSDEF(PSDERDEFMap pSDERDEFMap, PSDEField pSDEField) throws Exception {
        pSDERDEFMap.setMinorPSDEFId(pSDEField.getPSDEFieldId());
        pSDERDEFMap.setMinorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDER(PSDERDEFMap pSDERDEFMap, PSDER pSDER) throws Exception {
        pSDERDEFMap.setMajorPSDEId(pSDER.getMajorPSDEId());
        pSDERDEFMap.setMinorPSDEId(pSDER.getMinorPSDEId());
        pSDERDEFMap.setPSDERId(pSDER.getPSDERId());
        pSDERDEFMap.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDERDEFMap pSDERDEFMap, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDERDEFMap.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDERDEFMap.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDERDEFMap, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDERDEFMap, bl);
        this.onFillEntityFullInfo_MajorPSDEF(pSDERDEFMap, bl);
        this.onFillEntityFullInfo_MinorPSDEF(pSDERDEFMap, bl);
        this.onFillEntityFullInfo_PSDER(pSDERDEFMap, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDERDEFMap, bl);
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MajorPSDEF(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
        if (pSDERDEFMap.isMajorPSDEFIdDirty()) {
            if (pSDERDEFMap.getMajorPSDEFId() != null) {
                if (pSDERDEFMap.getMajorPSDEFId() == null || pSDERDEFMap.getMajorPSDEFName() == null) {
                    PSDEField pSDEField = pSDERDEFMap.getMajorPSDEF();
                    pSDERDEFMap.setMajorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDERDEFMap.setMajorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorPSDEF(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
        if (pSDERDEFMap.isMinorPSDEFIdDirty()) {
            if (pSDERDEFMap.getMinorPSDEFId() != null) {
                if (pSDERDEFMap.getMinorPSDEFId() == null || pSDERDEFMap.getMinorPSDEFName() == null) {
                    PSDEField pSDEField = pSDERDEFMap.getMinorPSDEF();
                    pSDERDEFMap.setMinorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDERDEFMap.setMinorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDER(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
        super.onWriteBackParent(pSDERDEFMap, bl);
    }

    public ArrayList<PSDERDEFMap> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDERDEFMap> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDERDEFMap> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
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

    public ArrayList<PSDERDEFMap> selectByMajorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMajorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDERDEFMap> selectByMajorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMajorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDERDEFMap> selectByMajorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERDEFMap> selectByMinorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDERDEFMap> selectByMinorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDERDEFMap> selectByMinorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERDEFMap> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDERDEFMap> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDERDEFMap> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERDEFMap> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDERDEFMap> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDERDEFMap> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByPSDEDQ(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDERDEFMAP_PSDEDATAQUERY_PSDEDQID", "", iDataEntityModel.getName(), "PSDERDEFMAP", iDataEntityModel.getDataInfo(pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            PSDERDEFMap pSDERDEFMap2 = (PSDERDEFMap)this.getDEModel().createEntity();
            pSDERDEFMap2.setPSDERDEFMapId(pSDERDEFMap.getPSDERDEFMapId());
            pSDERDEFMap2.setPSDEDQId(null);
            this.update(pSDERDEFMap2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERDEFMapServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDERDEFMapServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDERDEFMapServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            this.remove(pSDERDEFMap);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    public void testRemoveByMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByMajorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDERDEFMAP_PSDEFIELD_MAJORPSDEFID", "", iDataEntityModel.getName(), "PSDERDEFMAP", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByMajorPSDEF(pSDEField);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            PSDERDEFMap pSDERDEFMap2 = (PSDERDEFMap)this.getDEModel().createEntity();
            pSDERDEFMap2.setPSDERDEFMapId(pSDERDEFMap.getPSDERDEFMapId());
            pSDERDEFMap2.setMajorPSDEFId(null);
            this.update(pSDERDEFMap2);
        }
    }

    public void removeByMajorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERDEFMapServiceBase.this.onBeforeRemoveByMajorPSDEF(pSDEField2);
                PSDERDEFMapServiceBase.this.internalRemoveByMajorPSDEF(pSDEField2);
                PSDERDEFMapServiceBase.this.onAfterRemoveByMajorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByMajorPSDEF(pSDEField);
        this.onBeforeRemoveByMajorPSDEF(pSDEField, arrayList);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            this.remove(pSDERDEFMap);
        }
        this.onAfterRemoveByMajorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMajorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDEF(PSDEField pSDEField, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDEF(PSDEField pSDEField, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByMinorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDERDEFMAP_PSDEFIELD_MINORPSDEFID", "", iDataEntityModel.getName(), "PSDERDEFMAP", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByMinorPSDEF(pSDEField);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            PSDERDEFMap pSDERDEFMap2 = (PSDERDEFMap)this.getDEModel().createEntity();
            pSDERDEFMap2.setPSDERDEFMapId(pSDERDEFMap.getPSDERDEFMapId());
            pSDERDEFMap2.setMinorPSDEFId(null);
            this.update(pSDERDEFMap2);
        }
    }

    public void removeByMinorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERDEFMapServiceBase.this.onBeforeRemoveByMinorPSDEF(pSDEField2);
                PSDERDEFMapServiceBase.this.internalRemoveByMinorPSDEF(pSDEField2);
                PSDERDEFMapServiceBase.this.onAfterRemoveByMinorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByMinorPSDEF(pSDEField);
        this.onBeforeRemoveByMinorPSDEF(pSDEField, arrayList);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            this.remove(pSDERDEFMap);
        }
        this.onAfterRemoveByMinorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDEF(PSDEField pSDEField, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDEF(PSDEField pSDEField, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByPSDER(pSDER);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            PSDERDEFMap pSDERDEFMap2 = (PSDERDEFMap)this.getDEModel().createEntity();
            pSDERDEFMap2.setPSDERDEFMapId(pSDERDEFMap.getPSDERDEFMapId());
            pSDERDEFMap2.setPSDERId(null);
            this.update(pSDERDEFMap2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERDEFMapServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDERDEFMapServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDERDEFMapServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            this.remove(pSDERDEFMap);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDERDEFMAP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDERDEFMAP", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            PSDERDEFMap pSDERDEFMap2 = (PSDERDEFMap)this.getDEModel().createEntity();
            pSDERDEFMap2.setPSDERDEFMapId(pSDERDEFMap.getPSDERDEFMapId());
            pSDERDEFMap2.setPSSysSFPluginId(null);
            this.update(pSDERDEFMap2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERDEFMapServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDERDEFMapServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDERDEFMapServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDERDEFMap> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDERDEFMap pSDERDEFMap : arrayList) {
            this.remove(pSDERDEFMap);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDERDEFMap> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDERDEFMap pSDERDEFMap) throws Exception {
        super.onBeforeRemove(pSDERDEFMap);
    }

    protected void replaceParentInfo(PSDERDEFMap pSDERDEFMap, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDERDEFMap, cloneSession);
        if (pSDERDEFMap.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDERDEFMap.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDERDEFMap, (PSDEDataQuery)iEntity);
        }
        if (pSDERDEFMap.getMajorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDERDEFMap.getMajorPSDEFId())) != null) {
            this.onFillParentInfo_MajorPSDEF(pSDERDEFMap, (PSDEField)iEntity);
        }
        if (pSDERDEFMap.getMinorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDERDEFMap.getMinorPSDEFId())) != null) {
            this.onFillParentInfo_MinorPSDEF(pSDERDEFMap, (PSDEField)iEntity);
        }
        if (pSDERDEFMap.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDERDEFMap.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDERDEFMap, (PSDER)iEntity);
        }
        if (pSDERDEFMap.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDERDEFMap.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDERDEFMap, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDERDEFMap, bl);
    }

    protected void onCheckEntity(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDERDEFMap, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormulaFormat(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEFId(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEFName(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapType(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEFId(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEFName(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERDEFMapId(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERDEFMapName(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValue(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValueStdDataType(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValueType(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDERDEFMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDERDEFMap, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isCodeNameDirty() : !pSDERDEFMap.isCodeNameDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSDERID";
                String string4 = this.checkFieldDupRule(this.getPSDERDEFMapDEModel(), "CODENAME", string3, pSDERDEFMap, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormulaFormat(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isFormulaFormatDirty() : !pSDERDEFMap.isFormulaFormatDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getFormulaFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormulaFormat_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEFId(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isMajorPSDEFIdDirty() : !pSDERDEFMap.isMajorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getMajorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEFId_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEFName(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isMajorPSDEFNameDirty() && !bl2 : !pSDERDEFMap.isMajorPSDEFNameDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getMajorPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEFName_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapType(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isMapTypeDirty() && !bl2 : !pSDERDEFMap.isMapTypeDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getMapType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapType_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isMemoDirty() : !pSDERDEFMap.isMemoDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDERDEFMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSDEFId(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isMinorPSDEFIdDirty() : !pSDERDEFMap.isMinorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getMinorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEFId_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSDEFName(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isMinorPSDEFNameDirty() : !pSDERDEFMap.isMinorPSDEFNameDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getMinorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEFName_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isPSDEDQIdDirty() : !pSDERDEFMap.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getPSDEDQId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_Default(pSDERDEFMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERDEFMapId(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isPSDERDEFMapIdDirty() && !bl2 : !pSDERDEFMap.isPSDERDEFMapIdDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getPSDERDEFMapId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERDEFMAPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERDEFMapId_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERDEFMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERDEFMapName(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isPSDERDEFMapNameDirty() && !bl2 : !pSDERDEFMap.isPSDERDEFMapNameDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getPSDERDEFMapName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERDEFMAPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERDEFMapName_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERDEFMAPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isPSDERIdDirty() && !bl2 : !pSDERDEFMap.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getPSDERId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isPSSysSFPluginIdDirty() : !pSDERDEFMap.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValue(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isSrcValueDirty() : !pSDERDEFMap.isSrcValueDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getSrcValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcValue_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValueStdDataType(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isSrcValueStdDataTypeDirty() : !pSDERDEFMap.isSrcValueStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSDERDEFMap.getSrcValueStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SrcValueStdDataType_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUESTDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValueType(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isSrcValueTypeDirty() : !pSDERDEFMap.isSrcValueTypeDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getSrcValueType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcValueType_Default(pSDERDEFMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isUserCatDirty() : !pSDERDEFMap.isUserCatDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDERDEFMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isUserTagDirty() : !pSDERDEFMap.isUserTagDirty()) {
            return null;
        }
        String string = pSDERDEFMap.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDERDEFMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isUserTag2Dirty() : !pSDERDEFMap.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDERDEFMap.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDERDEFMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isUserTag3Dirty() : !pSDERDEFMap.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDERDEFMap.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDERDEFMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDERDEFMap pSDERDEFMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERDEFMap.isUserTag4Dirty() : !pSDERDEFMap.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDERDEFMap.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDERDEFMap, bl2, bl3);
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

    protected void onSyncEntity(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
        super.onSyncEntity(pSDERDEFMap, bl);
    }

    protected void onSyncIndexEntities(PSDERDEFMap pSDERDEFMap, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDERDEFMap, bl);
    }

    public Object getDataContextValue(PSDERDEFMap pSDERDEFMap, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDERDEFMap, string, iDataContextParam)) != null) {
            return object;
        }
        PSDER pSDER = pSDERDEFMap.getPSDER();
        if (pSDER != null && pSDER.contains(string)) {
            return pSDER.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDERDEFMap pSDERDEFMap, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDERDEFMap, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMULAFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormulaFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERDEFMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERDEFMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERDEFMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERDEFMapName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUESTDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValueStdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValueType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_FormulaFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMULAFORMAT", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    protected String onTestValueRule_MinorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDERDEFMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERDEFMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERDEFMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERDEFMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcValueStdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SrcValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCVALUETYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDERDEFMap pSDERDEFMap) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDERDEFMap)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDERDEFMap pSDERDEFMap) throws Exception {
        Object object = pSDERDEFMap.get("PSDERID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDERDEFMAP_PSDER_PSDERID", object);
        }
        super.onUpdateParent(pSDERDEFMap);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDERDEFMap pSDERDEFMap, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDERDEFMAP");
        if (!bl) {
            pSDERDEFMap.setCreateDate(null);
            pSDERDEFMap.setCreateMan(null);
            pSDERDEFMap.setPSDERDEFMapId(null);
            pSDERDEFMap.setUpdateDate(null);
            pSDERDEFMap.setUpdateMan(null);
            super.exportCurXmlModel(pSDERDEFMap, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDERDEFMap pSDERDEFMap, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDERDEFMap, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDER#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDERDEFMAP_PSDER_PSDERID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDER", (boolean)true) == 0) {
            iEntity.set("PSDERID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDERID"};
    }

    @Override
    public String getModelV2Tag(PSDERDEFMap pSDERDEFMap) {
        if (!StringHelper.isNullOrEmpty((String)pSDERDEFMap.getCodeName())) {
            return pSDERDEFMap.getCodeName();
        }
        return super.getModelV2Tag(pSDERDEFMap);
    }

    @Override
    public boolean setModelV2Tag(PSDERDEFMap pSDERDEFMap, String string) {
        pSDERDEFMap.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDERID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDERDEFMap pSDERDEFMap, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDERDEFMap.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDERDEFMap, true);
        pSDERDEFMap.set("CODENAME", string);
        if (this.select(pSDERDEFMap, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDERDEFMap, true);
        return super.getModelV2Entity(pSDERDEFMap, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDERDEFMap pSDERDEFMap, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDERDEFMap, objectNode, string, string2, n);
    }
}

