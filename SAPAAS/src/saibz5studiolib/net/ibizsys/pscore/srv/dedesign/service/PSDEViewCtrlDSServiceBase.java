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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEViewCtrlDSDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewCtrlDSDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrlBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrlDS;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewCtrlDSServiceBase
extends PSCoreSysServiceBase<PSDEViewCtrlDS> {
    private static final Log log = LogFactory.getLog(PSDEViewCtrlDSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEViewCtrlDSDEModel pSDEViewCtrlDSDEModel;
    private PSDEViewCtrlDSDAO pSDEViewCtrlDSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSService";
    }

    public PSDEViewCtrlDSDEModel getPSDEViewCtrlDSDEModel() {
        if (this.pSDEViewCtrlDSDEModel == null) {
            try {
                this.pSDEViewCtrlDSDEModel = (PSDEViewCtrlDSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewCtrlDSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewCtrlDSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEViewCtrlDSDEModel();
    }

    public PSDEViewCtrlDSDAO getPSDEViewCtrlDSDAO() {
        if (this.pSDEViewCtrlDSDAO == null) {
            try {
                this.pSDEViewCtrlDSDAO = (PSDEViewCtrlDSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEViewCtrlDSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewCtrlDSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEViewCtrlDSDAO();
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

    protected void onFillParentInfo(PSDEViewCtrlDS pSDEViewCtrlDS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRLDS_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_Psdedataset(pSDEViewCtrlDS, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRLDS_PSDEFIELD_MINORSORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Minorsortpsdef(pSDEViewCtrlDS, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRLDS_PSDEVIEWCTRL_PSDEVIEWCTRLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService", (SessionFactory)this.getSessionFactory());
            PSDEViewCtrl pSDEViewCtrl = (PSDEViewCtrl)iService.getDEModel().createEntity();
            pSDEViewCtrl.set("PSDEVIEWCTRLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewCtrl);
            } else {
                iService.get((IEntity)pSDEViewCtrl);
            }
            this.onFillParentInfo_Psdeviewctrl(pSDEViewCtrlDS, pSDEViewCtrl);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEViewCtrlDS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psdedataset(PSDEViewCtrlDS pSDEViewCtrlDS, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEViewCtrlDS.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEViewCtrlDS.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_Minorsortpsdef(PSDEViewCtrlDS pSDEViewCtrlDS, PSDEField pSDEField) throws Exception {
        pSDEViewCtrlDS.setMinorSortPSDEFId(pSDEField.getPSDEFieldId());
        pSDEViewCtrlDS.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Psdeviewctrl(PSDEViewCtrlDS pSDEViewCtrlDS, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        pSDEViewCtrlDS.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
        pSDEViewCtrlDS.setPSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
    }

    protected void onFillEntityFullInfo(PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEViewCtrlDS, bl);
        this.onFillEntityFullInfo_Psdedataset(pSDEViewCtrlDS, bl);
        this.onFillEntityFullInfo_Minorsortpsdef(pSDEViewCtrlDS, bl);
        this.onFillEntityFullInfo_Psdeviewctrl(pSDEViewCtrlDS, bl);
    }

    protected void onFillEntityFullInfo_Psdedataset(PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Minorsortpsdef(PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl) throws Exception {
        if (pSDEViewCtrlDS.isMinorSortPSDEFIdDirty()) {
            if (pSDEViewCtrlDS.getMinorSortPSDEFId() != null) {
                if (pSDEViewCtrlDS.getMinorSortPSDEFId() == null || pSDEViewCtrlDS.getMinorSortPSDEFName() == null) {
                    PSDEField pSDEField = pSDEViewCtrlDS.getMinorsortpsdef();
                    pSDEViewCtrlDS.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEViewCtrlDS.setMinorSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Psdeviewctrl(PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl) throws Exception {
        if (pSDEViewCtrlDS.isPSDEViewCtrlIdDirty()) {
            if (pSDEViewCtrlDS.getPSDEViewCtrlId() != null) {
                if (pSDEViewCtrlDS.getPSDEViewCtrlId() == null || pSDEViewCtrlDS.getPSDEViewCtrlName() == null) {
                    PSDEViewCtrl pSDEViewCtrl = pSDEViewCtrlDS.getPsdeviewctrl();
                    pSDEViewCtrlDS.setPSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
                }
            } else {
                pSDEViewCtrlDS.setPSDEViewCtrlName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEViewCtrlDS, bl);
    }

    public ArrayList<PSDEViewCtrlDS> selectByPsdedataset(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPsdedataset(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEViewCtrlDS> selectByPsdedataset(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPsdedataset(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEViewCtrlDS> selectByPsdedataset(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsdedatasetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsdedatasetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrlDS> selectByMinorsortpsdef(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorsortpsdef(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEViewCtrlDS> selectByMinorsortpsdef(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorsortpsdef(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEViewCtrlDS> selectByMinorsortpsdef(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORSORTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorsortpsdefCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorsortpsdefCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrlDS> selectByPsdeviewctrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectByPsdeviewctrl(pSDEViewCtrlBase, "", -1);
    }

    public ArrayList<PSDEViewCtrlDS> selectByPsdeviewctrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        return this.selectByPsdeviewctrl(pSDEViewCtrlBase, string, -1);
    }

    public ArrayList<PSDEViewCtrlDS> selectByPsdeviewctrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsdeviewctrlCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsdeviewctrlCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsdedataset(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEViewCtrlDS> arrayList = this.selectByPsdedataset(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRLDS_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDEVIEWCTRLDS", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPsdedataset(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEViewCtrlDS> arrayList = this.selectByPsdedataset(pSDEDataSet);
        for (PSDEViewCtrlDS pSDEViewCtrlDS : arrayList) {
            PSDEViewCtrlDS pSDEViewCtrlDS2 = (PSDEViewCtrlDS)this.getDEModel().createEntity();
            pSDEViewCtrlDS2.setPSDEViewCtrlDSId(pSDEViewCtrlDS.getPSDEViewCtrlDSId());
            pSDEViewCtrlDS2.setPSDEDataSetId(null);
            this.update(pSDEViewCtrlDS2);
        }
    }

    public void removeByPsdedataset(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlDSServiceBase.this.onBeforeRemoveByPsdedataset(pSDEDataSet2);
                PSDEViewCtrlDSServiceBase.this.internalRemoveByPsdedataset(pSDEDataSet2);
                PSDEViewCtrlDSServiceBase.this.onAfterRemoveByPsdedataset(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPsdedataset(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPsdedataset(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEViewCtrlDS> arrayList = this.selectByPsdedataset(pSDEDataSet);
        this.onBeforeRemoveByPsdedataset(pSDEDataSet, arrayList);
        for (PSDEViewCtrlDS pSDEViewCtrlDS : arrayList) {
            this.remove((IEntity)pSDEViewCtrlDS);
        }
        this.onAfterRemoveByPsdedataset(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPsdedataset(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPsdedataset(PSDEDataSet pSDEDataSet, ArrayList<PSDEViewCtrlDS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdedataset(PSDEDataSet pSDEDataSet, ArrayList<PSDEViewCtrlDS> arrayList) throws Exception {
    }

    public void testRemoveByMinorsortpsdef(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEViewCtrlDS> arrayList = this.selectByMinorsortpsdef(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRLDS_PSDEFIELD_MINORSORTPSDEFID", "", iDataEntityModel.getName(), "PSDEVIEWCTRLDS", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorsortpsdef(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEViewCtrlDS> arrayList = this.selectByMinorsortpsdef(pSDEField);
        for (PSDEViewCtrlDS pSDEViewCtrlDS : arrayList) {
            PSDEViewCtrlDS pSDEViewCtrlDS2 = (PSDEViewCtrlDS)this.getDEModel().createEntity();
            pSDEViewCtrlDS2.setPSDEViewCtrlDSId(pSDEViewCtrlDS.getPSDEViewCtrlDSId());
            pSDEViewCtrlDS2.setMinorSortPSDEFId(null);
            this.update(pSDEViewCtrlDS2);
        }
    }

    public void removeByMinorsortpsdef(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlDSServiceBase.this.onBeforeRemoveByMinorsortpsdef(pSDEField2);
                PSDEViewCtrlDSServiceBase.this.internalRemoveByMinorsortpsdef(pSDEField2);
                PSDEViewCtrlDSServiceBase.this.onAfterRemoveByMinorsortpsdef(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorsortpsdef(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorsortpsdef(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEViewCtrlDS> arrayList = this.selectByMinorsortpsdef(pSDEField);
        this.onBeforeRemoveByMinorsortpsdef(pSDEField, arrayList);
        for (PSDEViewCtrlDS pSDEViewCtrlDS : arrayList) {
            this.remove((IEntity)pSDEViewCtrlDS);
        }
        this.onAfterRemoveByMinorsortpsdef(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorsortpsdef(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorsortpsdef(PSDEField pSDEField, ArrayList<PSDEViewCtrlDS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorsortpsdef(PSDEField pSDEField, ArrayList<PSDEViewCtrlDS> arrayList) throws Exception {
    }

    public void testRemoveByPsdeviewctrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    public void resetPsdeviewctrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewCtrlDS> arrayList = this.selectByPsdeviewctrl(pSDEViewCtrl);
        for (PSDEViewCtrlDS pSDEViewCtrlDS : arrayList) {
            PSDEViewCtrlDS pSDEViewCtrlDS2 = (PSDEViewCtrlDS)this.getDEModel().createEntity();
            pSDEViewCtrlDS2.setPSDEViewCtrlDSId(pSDEViewCtrlDS.getPSDEViewCtrlDSId());
            pSDEViewCtrlDS2.setPSDEViewCtrlId(null);
            this.update(pSDEViewCtrlDS2);
        }
    }

    public void removeByPsdeviewctrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlDSServiceBase.this.onBeforeRemoveByPsdeviewctrl(pSDEViewCtrl2);
                PSDEViewCtrlDSServiceBase.this.internalRemoveByPsdeviewctrl(pSDEViewCtrl2);
                PSDEViewCtrlDSServiceBase.this.onAfterRemoveByPsdeviewctrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveByPsdeviewctrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveByPsdeviewctrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewCtrlDS> arrayList = this.selectByPsdeviewctrl(pSDEViewCtrl);
        this.onBeforeRemoveByPsdeviewctrl(pSDEViewCtrl, arrayList);
        for (PSDEViewCtrlDS pSDEViewCtrlDS : arrayList) {
            this.remove((IEntity)pSDEViewCtrlDS);
        }
        this.onAfterRemoveByPsdeviewctrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveByPsdeviewctrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveByPsdeviewctrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewCtrlDS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsdeviewctrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewCtrlDS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEViewCtrlDS pSDEViewCtrlDS) throws Exception {
        super.onBeforeRemove(pSDEViewCtrlDS);
    }

    protected void replaceParentInfo(PSDEViewCtrlDS pSDEViewCtrlDS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEViewCtrlDS, cloneSession);
        if (pSDEViewCtrlDS.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEViewCtrlDS.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_Psdedataset(pSDEViewCtrlDS, (PSDEDataSet)iEntity);
        }
        if (pSDEViewCtrlDS.getMinorSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEViewCtrlDS.getMinorSortPSDEFId())) != null) {
            this.onFillParentInfo_Minorsortpsdef(pSDEViewCtrlDS, (PSDEField)iEntity);
        }
        if (pSDEViewCtrlDS.getPSDEViewCtrlId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWCTRL", (Object)pSDEViewCtrlDS.getPSDEViewCtrlId())) != null) {
            this.onFillParentInfo_Psdeviewctrl(pSDEViewCtrlDS, (PSDEViewCtrl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEViewCtrlDS, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDEViewCtrlDS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortDir(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFId(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFName(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlDSId(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlDSName(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlId(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlName(bl, pSDEViewCtrlDS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEViewCtrlDS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isMemoDirty() : !pSDEViewCtrlDS.isMemoDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortDir(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isMinorSortDirDirty() : !pSDEViewCtrlDS.isMinorSortDirDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getMinorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortDir_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFId(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isMinorSortPSDEFIdDirty() : !pSDEViewCtrlDS.isMinorSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getMinorSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFId_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFName(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isMinorSortPSDEFNameDirty() : !pSDEViewCtrlDS.isMinorSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getMinorSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFName_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isOrderValueDirty() : !pSDEViewCtrlDS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrlDS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isPSDEDataSetIdDirty() : !pSDEViewCtrlDS.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewCtrlDSId(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isPSDEViewCtrlDSIdDirty() && !bl2 : !pSDEViewCtrlDS.isPSDEViewCtrlDSIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getPSDEViewCtrlDSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLDSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlDSId_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewCtrlDSName(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isPSDEViewCtrlDSNameDirty() && !bl2 : !pSDEViewCtrlDS.isPSDEViewCtrlDSNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getPSDEViewCtrlDSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLDSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlDSName_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLDSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewCtrlId(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isPSDEViewCtrlIdDirty() : !pSDEViewCtrlDS.isPSDEViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getPSDEViewCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlId_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewCtrlName(boolean bl, PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrlDS.isPSDEViewCtrlNameDirty() : !pSDEViewCtrlDS.isPSDEViewCtrlNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrlDS.getPSDEViewCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlName_Default((IEntity)pSDEViewCtrlDS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEViewCtrlDS, bl);
    }

    protected void onSyncIndexEntities(PSDEViewCtrlDS pSDEViewCtrlDS, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEViewCtrlDS, bl);
    }

    public Object getDataContextValue(PSDEViewCtrlDS pSDEViewCtrlDS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEViewCtrlDS, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEViewCtrlDS pSDEViewCtrlDS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEViewCtrlDS, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MINORSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDEViewCtrlDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewCtrlDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSDEViewCtrlDS pSDEViewCtrlDS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEViewCtrlDS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEViewCtrlDS pSDEViewCtrlDS) throws Exception {
        super.onUpdateParent((IEntity)pSDEViewCtrlDS);
    }

    @Override
    protected void exportCurXmlModel(PSDEViewCtrlDS pSDEViewCtrlDS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVIEWCTRLDS");
        if (!bl) {
            pSDEViewCtrlDS.setCreateDate(null);
            pSDEViewCtrlDS.setCreateMan(null);
            pSDEViewCtrlDS.setPSDEDataSetName(null);
            pSDEViewCtrlDS.setPSDEViewCtrlDSId(null);
            pSDEViewCtrlDS.setUpdateDate(null);
            pSDEViewCtrlDS.setUpdateMan(null);
            super.exportCurXmlModel(pSDEViewCtrlDS, xmlNode, bl);
        }
    }
}

