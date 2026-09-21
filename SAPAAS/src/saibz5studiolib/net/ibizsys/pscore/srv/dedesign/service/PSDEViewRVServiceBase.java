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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEViewRVDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewRVDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRV;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewRVServiceBase
extends PSCoreSysServiceBase<PSDEViewRV> {
    private static final Log log = LogFactory.getLog(PSDEViewRVServiceBase.class);
    public static final String DATASET_CURVIEWRT = "CurViewRT";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEViewRVDEModel pSDEViewRVDEModel;
    private PSDEViewRVDAO pSDEViewRVDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService";
    }

    public PSDEViewRVDEModel getPSDEViewRVDEModel() {
        if (this.pSDEViewRVDEModel == null) {
            try {
                this.pSDEViewRVDEModel = (PSDEViewRVDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewRVDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewRVDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEViewRVDEModel();
    }

    public PSDEViewRVDAO getPSDEViewRVDAO() {
        if (this.pSDEViewRVDAO == null) {
            try {
                this.pSDEViewRVDAO = (PSDEViewRVDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEViewRVDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewRVDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEViewRVDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURVIEWRT, (boolean)true) == 0) {
            return this.fetchCurViewRT(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURVIEWRT, (boolean)true) == 0) {
            return this.fetchTempCurViewRT(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurViewRT(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVIEWRT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurViewRT(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVIEWRT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEViewRV pSDEViewRV, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWRV_PSDEVIEWBASE_MAJORPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MajorPSDEView(pSDEViewRV, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWRV_PSDEVIEWBASE_MINORPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MinorPSDEView(pSDEViewRV, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWRV_PSLANGUAGERES_TITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TitlePSLanRes(pSDEViewRV, pSLanguageRes);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEViewRV, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEVIEWRV_PSDEVIEWBASE_MAJORPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", string2);
            return this.onSyncDER1NData_MajorPSDEView(pSDEViewBase, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_MajorPSDEView(PSDEViewRV pSDEViewRV, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEViewRV.setMajorPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewRV.setMajorPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
        pSDEViewRV.setPSSystemId(pSDEViewBase.getPSSystemId());
    }

    protected String onSyncDER1NData_MajorPSDEView(PSDEViewBase pSDEViewBase, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByMajorPSDEView(pSDEViewBase);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEViewRV> arrayList = this.selectByMajorPSDEView(pSDEViewBase);
            for (PSDEViewRV pSDEViewRV : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEViewRV, (String)"PSDEVIEWRVID", (String)""))) continue;
                this.remove((IEntity)pSDEViewRV);
            }
        }
        return null;
    }

    protected void onFillParentInfo_MinorPSDEView(PSDEViewRV pSDEViewRV, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEViewRV.setMinorPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewRV.setMinorPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_TitlePSLanRes(PSDEViewRV pSDEViewRV, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEViewRV.setTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEViewRV.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected boolean onFillEntityKeyValue(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEViewRV.get("MAJORPSDEVIEWID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEViewRV.get("PSDEVIEWRVNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEViewRV.set(this.getPSDEViewRVDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEViewRV, bl);
        this.onFillEntityFullInfo_MajorPSDEView(pSDEViewRV, bl);
        this.onFillEntityFullInfo_MinorPSDEView(pSDEViewRV, bl);
        this.onFillEntityFullInfo_TitlePSLanRes(pSDEViewRV, bl);
    }

    protected void onFillEntityFullInfo_MajorPSDEView(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorPSDEView(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TitlePSLanRes(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
        if (pSDEViewRV.isTitlePSLanResIdDirty()) {
            if (pSDEViewRV.getTitlePSLanResId() != null) {
                if (pSDEViewRV.getTitlePSLanResId() == null || pSDEViewRV.getTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEViewRV.getTitlePSLanRes();
                    pSDEViewRV.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEViewRV.setTitlePSLanResName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEViewRV, bl);
    }

    public ArrayList<PSDEViewRV> selectByMajorPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMajorPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEViewRV> selectByMajorPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMajorPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEViewRV> selectByMajorPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewRV> selectTempByMajorPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectTempByMajorPSDEView(pSDEViewBaseBase, "");
    }

    public ArrayList<PSDEViewRV> selectTempByMajorPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByMajorPSDEViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByMajorPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewRV> selectByMinorPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMinorPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEViewRV> selectByMinorPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMinorPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEViewRV> selectByMinorPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewRV> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEViewRV> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEViewRV> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    public void resetMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectByMajorPSDEView(pSDEViewBase);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            PSDEViewRV pSDEViewRV2 = (PSDEViewRV)this.getDEModel().createEntity();
            pSDEViewRV2.setPSDEViewRVId(pSDEViewRV.getPSDEViewRVId());
            pSDEViewRV2.setMajorPSDEViewId(null);
            this.update(pSDEViewRV2);
        }
    }

    public void resetTempMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectTempByMajorPSDEView(pSDEViewBase);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            PSDEViewRV pSDEViewRV2 = (PSDEViewRV)this.getDEModel().createEntity();
            pSDEViewRV2.setPSDEViewRVId(pSDEViewRV.getPSDEViewRVId());
            pSDEViewRV2.setMajorPSDEViewId(null);
            this.updateTemp((IEntity)pSDEViewRV2);
        }
    }

    public void removeByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewRVServiceBase.this.onBeforeRemoveByMajorPSDEView(pSDEViewBase2);
                PSDEViewRVServiceBase.this.internalRemoveByMajorPSDEView(pSDEViewBase2);
                PSDEViewRVServiceBase.this.onAfterRemoveByMajorPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectByMajorPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMajorPSDEView(pSDEViewBase, arrayList);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            this.remove((IEntity)pSDEViewRV);
        }
        this.onAfterRemoveByMajorPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewRV> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectByMinorPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWRV_PSDEVIEWBASE_MINORPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEVIEWRV", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMinorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectByMinorPSDEView(pSDEViewBase);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            PSDEViewRV pSDEViewRV2 = (PSDEViewRV)this.getDEModel().createEntity();
            pSDEViewRV2.setPSDEViewRVId(pSDEViewRV.getPSDEViewRVId());
            pSDEViewRV2.setMinorPSDEViewId(null);
            this.update(pSDEViewRV2);
        }
    }

    public void removeByMinorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewRVServiceBase.this.onBeforeRemoveByMinorPSDEView(pSDEViewBase2);
                PSDEViewRVServiceBase.this.internalRemoveByMinorPSDEView(pSDEViewBase2);
                PSDEViewRVServiceBase.this.onAfterRemoveByMinorPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMinorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectByMinorPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMinorPSDEView(pSDEViewBase, arrayList);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            this.remove((IEntity)pSDEViewRV);
        }
        this.onAfterRemoveByMinorPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMinorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewRV> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectByTitlePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWRV_PSLANGUAGERES_TITLEPSLANRESID", "", iDataEntityModel.getName(), "PSDEVIEWRV", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            PSDEViewRV pSDEViewRV2 = (PSDEViewRV)this.getDEModel().createEntity();
            pSDEViewRV2.setPSDEViewRVId(pSDEViewRV.getPSDEViewRVId());
            pSDEViewRV2.setTitlePSLanResId(null);
            this.update(pSDEViewRV2);
        }
    }

    public void removeByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewRVServiceBase.this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes2);
                PSDEViewRVServiceBase.this.internalRemoveByTitlePSLanRes(pSLanguageRes2);
                PSDEViewRVServiceBase.this.onAfterRemoveByTitlePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            this.remove((IEntity)pSDEViewRV);
        }
        this.onAfterRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewRV> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEViewRV pSDEViewRV) throws Exception {
        super.onBeforeRemove(pSDEViewRV);
    }

    public void removeTempByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewRVServiceBase.this.onBeforeRemoveTempByMajorPSDEView(pSDEViewBase2);
                PSDEViewRVServiceBase.this.internalRemoveTempByMajorPSDEView(pSDEViewBase2);
                PSDEViewRVServiceBase.this.onAfterRemoveTempByMajorPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveTempByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveTempByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewRV> arrayList = this.selectTempByMajorPSDEView(pSDEViewBase);
        this.onBeforeRemoveTempByMajorPSDEView(pSDEViewBase, arrayList);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            this.removeTemp((IEntity)pSDEViewRV);
        }
        this.onAfterRemoveTempByMajorPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveTempByMajorPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveTempByMajorPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByMajorPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewRV> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEViewRV pSDEViewRV, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEViewRV, cloneSession);
        if (pSDEViewRV.getMajorPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEViewRV.getMajorPSDEViewId())) != null) {
            this.onFillParentInfo_MajorPSDEView(pSDEViewRV, (PSDEViewBase)iEntity);
        }
        if (pSDEViewRV.getMinorPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEViewRV.getMinorPSDEViewId())) != null) {
            this.onFillParentInfo_MinorPSDEView(pSDEViewRV, (PSDEViewBase)iEntity);
        }
        if (pSDEViewRV.getTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEViewRV.getTitlePSLanResId())) != null) {
            this.onFillParentInfo_TitlePSLanRes(pSDEViewRV, (PSLanguageRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEViewRV, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DefViewType(bl, pSDEViewRV, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEViewId(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEViewId(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenMode(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewRVId(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewRVName(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMode(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefModeText(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefParam(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefParamDesc(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResId(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResName(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParams(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDEViewRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEViewRV, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DefViewType(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isDefViewTypeDirty() : !pSDEViewRV.isDefViewTypeDirty()) {
            return null;
        }
        String string = pSDEViewRV.getDefViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefViewType_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isDynaModelFlagDirty() : !pSDEViewRV.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewRV.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_Height(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isHeightDirty() : !pSDEViewRV.isHeightDirty()) {
            return null;
        }
        Integer n = pSDEViewRV.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEViewId(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isMajorPSDEViewIdDirty() && !bl2 : !pSDEViewRV.isMajorPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEViewRV.getMajorPSDEViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEViewId_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isMemoDirty() : !pSDEViewRV.isMemoDirty()) {
            return null;
        }
        String string = pSDEViewRV.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSDEViewId(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isMinorPSDEViewIdDirty() : !pSDEViewRV.isMinorPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEViewRV.getMinorPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEViewId_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenMode(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isOpenModeDirty() : !pSDEViewRV.isOpenModeDirty()) {
            return null;
        }
        String string = pSDEViewRV.getOpenMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenMode_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewRVId(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isPSDEViewRVIdDirty() && !bl2 : !pSDEViewRV.isPSDEViewRVIdDirty()) {
            return null;
        }
        String string = pSDEViewRV.getPSDEViewRVId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWRVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewRVId_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWRVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewRVName(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isPSDEViewRVNameDirty() && !bl2 : !pSDEViewRV.isPSDEViewRVNameDirty()) {
            return null;
        }
        String string = pSDEViewRV.getPSDEViewRVName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWRVNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewRVName_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWRVNAME");
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
                string3 = "MAJORPSDEVIEWID";
                String string4 = this.checkFieldDupRule(this.getPSDEViewRVDEModel(), "PSDEVIEWRVNAME", string3, pSDEViewRV, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVIEWRVNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isPSDynaInstIdDirty() : !pSDEViewRV.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEViewRV.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefMode(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isRefModeDirty() : !pSDEViewRV.isRefModeDirty()) {
            return null;
        }
        String string = pSDEViewRV.getRefMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMode_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefModeText(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isRefModeTextDirty() : !pSDEViewRV.isRefModeTextDirty()) {
            return null;
        }
        String string = pSDEViewRV.getRefModeText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefModeText_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefParam(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isRefParamDirty() : !pSDEViewRV.isRefParamDirty()) {
            return null;
        }
        String string = pSDEViewRV.getRefParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefParam_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefParamDesc(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isRefParamDescDirty() : !pSDEViewRV.isRefParamDescDirty()) {
            return null;
        }
        String string = pSDEViewRV.getRefParamDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefParamDesc_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_Title(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isTitleDirty() : !pSDEViewRV.isTitleDirty()) {
            return null;
        }
        String string = pSDEViewRV.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResId(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isTitlePSLanResIdDirty() : !pSDEViewRV.isTitlePSLanResIdDirty()) {
            return null;
        }
        String string = pSDEViewRV.getTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResId_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResName(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isTitlePSLanResNameDirty() : !pSDEViewRV.isTitlePSLanResNameDirty()) {
            return null;
        }
        String string = pSDEViewRV.getTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResName_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isUserTagDirty() : !pSDEViewRV.isUserTagDirty()) {
            return null;
        }
        String string = pSDEViewRV.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isUserTag2Dirty() : !pSDEViewRV.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEViewRV.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewParams(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isViewParamsDirty() : !pSDEViewRV.isViewParamsDirty()) {
            return null;
        }
        String string = pSDEViewRV.getViewParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParams_Default((IEntity)pSDEViewRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_Width(boolean bl, PSDEViewRV pSDEViewRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewRV.isWidthDirty() : !pSDEViewRV.isWidthDirty()) {
            return null;
        }
        Integer n = pSDEViewRV.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default((IEntity)pSDEViewRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEViewRV, bl);
    }

    protected void onSyncIndexEntities(PSDEViewRV pSDEViewRV, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEViewRV, bl);
    }

    public Object getDataContextValue(PSDEViewRV pSDEViewRV, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEViewRV, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEViewBase pSDEViewBase = pSDEViewRV.getMajorPSDEView();
        if (pSDEViewBase != null && pSDEViewBase.contains(string)) {
            return pSDEViewBase.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEViewRV pSDEViewRV, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_TitlePSLanRes(pSDEViewRV, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEViewRV, arrayList, n);
    }

    protected void onExportMajorModel_TitlePSLanRes(PSDEViewRV pSDEViewRV, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEViewRV.getTitlePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEViewRV.getTitlePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWRVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewRVId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWRVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewRVName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFVIEWTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MajorPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_MinorPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewRVId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWRVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewRVName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWRVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEViewRV pSDEViewRV) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEViewRV)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEViewRV pSDEViewRV) throws Exception {
        super.onUpdateParent((IEntity)pSDEViewRV);
    }

    @Override
    protected void exportCurXmlModel(PSDEViewRV pSDEViewRV, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVIEWRV");
        if (!bl) {
            pSDEViewRV.setCreateDate(null);
            pSDEViewRV.setCreateMan(null);
            pSDEViewRV.setPSDEViewRVId(null);
            pSDEViewRV.setUpdateDate(null);
            pSDEViewRV.setUpdateMan(null);
            pSDEViewRV.setMajorPSDEViewId(null);
            pSDEViewRV.setMajorPSDEViewName(null);
            pSDEViewRV.setPSSystemId(null);
            super.exportCurXmlModel(pSDEViewRV, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEViewRV pSDEViewRV, PSSystem pSSystem) throws Exception {
        PSDEViewRV pSDEViewRV2 = new PSDEViewRV();
        pSDEViewRV2.setMajorPSDEViewId(pSDEViewRV.getMajorPSDEViewId());
        pSDEViewRV2.setPSDEViewRVName(pSDEViewRV.getPSDEViewRVName());
        if (this.selectOne((IEntity)pSDEViewRV2, true)) {
            return pSDEViewRV2.getPSDEViewRVId();
        }
        return super.getEntityFolderKeyValue(pSDEViewRV, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEViewRV pSDEViewRV, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEViewRV, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEVIEWRV_PSDEVIEWBASE_MAJORPSDEVIEWID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEVIEWNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASE", (boolean)true) == 0) {
            iEntity.set("MAJORPSDEVIEWID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"MAJORPSDEVIEWID"};
    }

    @Override
    public String getModelV2Tag(PSDEViewRV pSDEViewRV) {
        if (!StringHelper.isNullOrEmpty((String)pSDEViewRV.getPSDEViewRVName())) {
            return pSDEViewRV.getPSDEViewRVName();
        }
        return super.getModelV2Tag(pSDEViewRV);
    }

    @Override
    public boolean setModelV2Tag(PSDEViewRV pSDEViewRV, String string) {
        pSDEViewRV.setPSDEViewRVName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEVIEWRVNAME", "");
        map.put("MAJORPSDEVIEWID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEViewRV pSDEViewRV, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEViewRV.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEViewRV, true);
        pSDEViewRV.set("PSDEVIEWRVNAME", string);
        if (this.select(pSDEViewRV, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEViewRV, true);
        return super.getModelV2Entity(pSDEViewRV, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEViewRV pSDEViewRV, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEViewRV, objectNode, string, string2, n);
    }
}

