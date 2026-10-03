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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFormRFDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormRFDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormRF;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFormRFServiceBase
extends PSCoreSysServiceBase<PSDEFormRF> {
    private static final Log log = LogFactory.getLog(PSDEFormRFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFormRFDEModel pSDEFormRFDEModel;
    private PSDEFormRFDAO pSDEFormRFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFormRFService";
    }

    public PSDEFormRFDEModel getPSDEFormRFDEModel() {
        if (this.pSDEFormRFDEModel == null) {
            try {
                this.pSDEFormRFDEModel = (PSDEFormRFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormRFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormRFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFormRFDEModel();
    }

    public PSDEFormRFDAO getPSDEFormRFDAO() {
        if (this.pSDEFormRFDAO == null) {
            try {
                this.pSDEFormRFDAO = (PSDEFormRFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFormRFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormRFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFormRFDAO();
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

    protected void onFillParentInfo(PSDEFormRF pSDEFormRF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMRF_PSDEFORM_MAJORPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MajorPSDEForm(pSDEFormRF, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMRF_PSDEFORM_MINORPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MinorPSDEForm(pSDEFormRF, pSDEForm);
            return;
        }
        super.onFillParentInfo(pSDEFormRF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFORMRF_PSDEFORM_MAJORPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", string2);
            return this.onSyncDER1NData_MajorPSDEForm(pSDEForm, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_MajorPSDEForm(PSDEFormRF pSDEFormRF, PSDEForm pSDEForm) throws Exception {
        pSDEFormRF.setMajorPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFormRF.setMajorPSDEFormName(pSDEForm.getPSDEFormName());
        pSDEFormRF.setPSDEId(pSDEForm.getPSDEId());
    }

    protected String onSyncDER1NData_MajorPSDEForm(PSDEForm pSDEForm, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByMajorPSDEForm(pSDEForm);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEFormRF> arrayList = this.selectByMajorPSDEForm(pSDEForm);
            for (PSDEFormRF pSDEFormRF : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEFormRF, (String)"PSDEFORMRFID", (String)""))) continue;
                this.remove(pSDEFormRF);
            }
        }
        return null;
    }

    protected void onFillParentInfo_MinorPSDEForm(PSDEFormRF pSDEFormRF, PSDEForm pSDEForm) throws Exception {
        pSDEFormRF.setMinorPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFormRF.setMinorPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillEntityFullInfo(PSDEFormRF pSDEFormRF, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEFormRF, bl);
        this.onFillEntityFullInfo_MajorPSDEForm(pSDEFormRF, bl);
        this.onFillEntityFullInfo_MinorPSDEForm(pSDEFormRF, bl);
    }

    protected void onFillEntityFullInfo_MajorPSDEForm(PSDEFormRF pSDEFormRF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorPSDEForm(PSDEFormRF pSDEFormRF, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFormRF pSDEFormRF, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFormRF, bl);
    }

    public ArrayList<PSDEFormRF> selectByMajorPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMajorPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFormRF> selectByMajorPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMajorPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFormRF> selectByMajorPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormRF> selectTempByMajorPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectTempByMajorPSDEForm(pSDEFormBase, "");
    }

    public ArrayList<PSDEFormRF> selectTempByMajorPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByMajorPSDEFormCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByMajorPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormRF> selectByMinorPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMinorPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFormRF> selectByMinorPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMinorPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFormRF> selectByMinorPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    public void resetMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormRF> arrayList = this.selectByMajorPSDEForm(pSDEForm);
        for (PSDEFormRF pSDEFormRF : arrayList) {
            PSDEFormRF pSDEFormRF2 = (PSDEFormRF)this.getDEModel().createEntity();
            pSDEFormRF2.setPSDEFormRFId(pSDEFormRF.getPSDEFormRFId());
            pSDEFormRF2.setMajorPSDEFormId(null);
            this.update(pSDEFormRF2);
        }
    }

    public void resetTempMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormRF> arrayList = this.selectTempByMajorPSDEForm(pSDEForm);
        for (PSDEFormRF pSDEFormRF : arrayList) {
            PSDEFormRF pSDEFormRF2 = (PSDEFormRF)this.getDEModel().createEntity();
            pSDEFormRF2.setPSDEFormRFId(pSDEFormRF.getPSDEFormRFId());
            pSDEFormRF2.setMajorPSDEFormId(null);
            this.updateTemp(pSDEFormRF2);
        }
    }

    public void removeByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormRFServiceBase.this.onBeforeRemoveByMajorPSDEForm(pSDEForm2);
                PSDEFormRFServiceBase.this.internalRemoveByMajorPSDEForm(pSDEForm2);
                PSDEFormRFServiceBase.this.onAfterRemoveByMajorPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormRF> arrayList = this.selectByMajorPSDEForm(pSDEForm);
        this.onBeforeRemoveByMajorPSDEForm(pSDEForm, arrayList);
        for (PSDEFormRF pSDEFormRF : arrayList) {
            this.remove(pSDEFormRF);
        }
        this.onAfterRemoveByMajorPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormRF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormRF> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormRF> arrayList = this.selectByMinorPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMRF_PSDEFORM_MINORPSDEFORMID", "", iDataEntityModel.getName(), "PSDEFORMRF", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMinorPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormRF> arrayList = this.selectByMinorPSDEForm(pSDEForm);
        for (PSDEFormRF pSDEFormRF : arrayList) {
            PSDEFormRF pSDEFormRF2 = (PSDEFormRF)this.getDEModel().createEntity();
            pSDEFormRF2.setPSDEFormRFId(pSDEFormRF.getPSDEFormRFId());
            pSDEFormRF2.setMinorPSDEFormId(null);
            this.update(pSDEFormRF2);
        }
    }

    public void removeByMinorPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormRFServiceBase.this.onBeforeRemoveByMinorPSDEForm(pSDEForm2);
                PSDEFormRFServiceBase.this.internalRemoveByMinorPSDEForm(pSDEForm2);
                PSDEFormRFServiceBase.this.onAfterRemoveByMinorPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMinorPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormRF> arrayList = this.selectByMinorPSDEForm(pSDEForm);
        this.onBeforeRemoveByMinorPSDEForm(pSDEForm, arrayList);
        for (PSDEFormRF pSDEFormRF : arrayList) {
            this.remove(pSDEFormRF);
        }
        this.onAfterRemoveByMinorPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMinorPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormRF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormRF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFormRF pSDEFormRF) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEFormDetailService.testRemoveByPSDEFormRF(pSDEFormRF);
        pSDEFormDetailService.resetPSDEFormRF(pSDEFormRF);
        super.onBeforeRemove(pSDEFormRF);
    }

    protected void onBeforeRemoveTemp(PSDEFormRF pSDEFormRF) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEFormDetailService.resetTempPSDEFormRF(pSDEFormRF);
        super.onBeforeRemoveTemp(pSDEFormRF);
    }

    public void removeTempByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormRFServiceBase.this.onBeforeRemoveTempByMajorPSDEForm(pSDEForm2);
                PSDEFormRFServiceBase.this.internalRemoveTempByMajorPSDEForm(pSDEForm2);
                PSDEFormRFServiceBase.this.onAfterRemoveTempByMajorPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveTempByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveTempByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormRF> arrayList = this.selectTempByMajorPSDEForm(pSDEForm);
        this.onBeforeRemoveTempByMajorPSDEForm(pSDEForm, arrayList);
        for (PSDEFormRF pSDEFormRF : arrayList) {
            this.removeTemp(pSDEFormRF);
        }
        this.onAfterRemoveTempByMajorPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveTempByMajorPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveTempByMajorPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormRF> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByMajorPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormRF> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEFormRF pSDEFormRF) throws Exception {
        super.getRelatedDataTempMajor(pSDEFormRF);
    }

    protected void updateRelatedDataTempMajor(PSDEFormRF pSDEFormRF, PSDEFormRF pSDEFormRF2) throws Exception {
        super.updateRelatedDataTempMajor(pSDEFormRF, pSDEFormRF2);
    }

    protected void replaceParentInfo(PSDEFormRF pSDEFormRF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFormRF, cloneSession);
        if (pSDEFormRF.getMajorPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFormRF.getMajorPSDEFormId())) != null) {
            this.onFillParentInfo_MajorPSDEForm(pSDEFormRF, (PSDEForm)iEntity);
        }
        if (pSDEFormRF.getMinorPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFormRF.getMinorPSDEFormId())) != null) {
            this.onFillParentInfo_MinorPSDEForm(pSDEFormRF, (PSDEForm)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFormRF pSDEFormRF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFormRF, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFormRF pSDEFormRF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_MajorPSDEFormId(bl, pSDEFormRF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFormRF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEFormId(bl, pSDEFormRF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormRFId(bl, pSDEFormRF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormRFName(bl, pSDEFormRF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFormRF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_MajorPSDEFormId(boolean bl, PSDEFormRF pSDEFormRF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormRF.isMajorPSDEFormIdDirty() && !bl2 : !pSDEFormRF.isMajorPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFormRF.getMajorPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEFormId_Default(pSDEFormRF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFormRF pSDEFormRF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormRF.isMemoDirty() : !pSDEFormRF.isMemoDirty()) {
            return null;
        }
        String string = pSDEFormRF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFormRF, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSDEFormId(boolean bl, PSDEFormRF pSDEFormRF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormRF.isMinorPSDEFormIdDirty() && !bl2 : !pSDEFormRF.isMinorPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFormRF.getMinorPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEFormId_Default(pSDEFormRF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEFORMID");
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
                string3 = "MAJORPSDEFORMID";
                String string4 = this.checkFieldDupRule(this.getPSDEFormRFDEModel(), "MINORPSDEFORMID", string3, pSDEFormRF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MINORPSDEFORMID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormRFId(boolean bl, PSDEFormRF pSDEFormRF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormRF.isPSDEFormRFIdDirty() && !bl2 : !pSDEFormRF.isPSDEFormRFIdDirty()) {
            return null;
        }
        String string = pSDEFormRF.getPSDEFormRFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMRFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormRFId_Default(pSDEFormRF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMRFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormRFName(boolean bl, PSDEFormRF pSDEFormRF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormRF.isPSDEFormRFNameDirty() && !bl2 : !pSDEFormRF.isPSDEFormRFNameDirty()) {
            return null;
        }
        String string = pSDEFormRF.getPSDEFormRFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMRFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormRFName_Default(pSDEFormRF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMRFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "MAJORPSDEFORMID";
                String string4 = this.checkFieldDupRule(this.getPSDEFormRFDEModel(), "PSDEFORMRFNAME", string3, pSDEFormRF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFORMRFNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFormRF pSDEFormRF, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFormRF, bl);
    }

    protected void onSyncIndexEntities(PSDEFormRF pSDEFormRF, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFormRF, bl);
    }

    public Object getDataContextValue(PSDEFormRF pSDEFormRF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFormRF, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEForm pSDEForm = pSDEFormRF.getMajorPSDEForm();
        if (pSDEForm != null && pSDEForm.contains(string)) {
            return pSDEForm.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFormRF pSDEFormRF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFormRF, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMRFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormRFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMRFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormRFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MajorPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_MinorPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormRFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMRFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormRFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMRFNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEFormRF pSDEFormRF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFormRF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFormRF pSDEFormRF) throws Exception {
        super.onUpdateParent(pSDEFormRF);
    }

    @Override
    protected void exportCurXmlModel(PSDEFormRF pSDEFormRF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFORMRF");
        if (!bl) {
            pSDEFormRF.setMajorPSDEFormId(null);
            pSDEFormRF.setMajorPSDEFormName(null);
            pSDEFormRF.setPSDEId(null);
            super.exportCurXmlModel(pSDEFormRF, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEFormRF pSDEFormRF, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEFormRF, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEFormRF pSDEFormRF, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEFormRF, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFormRF pSDEFormRF, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFormRF, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFORM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFORMRF_PSDEFORM_MAJORPSDEFORMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEFORMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFORM", (boolean)true) == 0) {
            iEntity.set("MAJORPSDEFORMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"MAJORPSDEFORMID"};
    }

    @Override
    public String getModelV2Tag(PSDEFormRF pSDEFormRF) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFormRF.getPSDEFormRFName())) {
            return pSDEFormRF.getPSDEFormRFName();
        }
        return super.getModelV2Tag(pSDEFormRF);
    }

    @Override
    public boolean setModelV2Tag(PSDEFormRF pSDEFormRF, String string) {
        pSDEFormRF.setPSDEFormRFName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEFORMRFNAME", "");
        map.put("MAJORPSDEFORMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFormRF pSDEFormRF, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFormRF.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFormRF, true);
        pSDEFormRF.set("PSDEFORMRFNAME", string);
        if (this.select(pSDEFormRF, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFormRF, true);
        return super.getModelV2Entity(pSDEFormRF, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFormRF pSDEFormRF, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEFormRF, objectNode, string, string2, n);
    }
}

