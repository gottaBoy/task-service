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
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBILevelDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBILevelDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchy;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchyBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBILevel;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBILevelServiceBase
extends PSCoreSysServiceBase<PSSysBILevel> {
    private static final Log log = LogFactory.getLog(PSSysBILevelServiceBase.class);
    public static final String DATASET_CURHIERARCHY = "CurHierarchy";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBILevelDEModel pSSysBILevelDEModel;
    private PSSysBILevelDAO pSSysBILevelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelService";
    }

    public PSSysBILevelDEModel getPSSysBILevelDEModel() {
        if (this.pSSysBILevelDEModel == null) {
            try {
                this.pSSysBILevelDEModel = (PSSysBILevelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBILevelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBILevelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBILevelDEModel();
    }

    public PSSysBILevelDAO getPSSysBILevelDAO() {
        if (this.pSSysBILevelDAO == null) {
            try {
                this.pSSysBILevelDAO = (PSSysBILevelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBILevelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBILevelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBILevelDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURHIERARCHY, (boolean)true) == 0) {
            return this.fetchCurHierarchy(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurHierarchy(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURHIERARCHY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBILevel pSSysBILevel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBILEVEL_PSDEFIELD_TEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TextPSDEF(pSSysBILevel, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBILEVEL_PSDEFIELD_VALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ValuePSDEF(pSSysBILevel, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBILEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService", (SessionFactory)this.getSessionFactory());
            PSSysBIHierarchy pSSysBIHierarchy = (PSSysBIHierarchy)iService.getDEModel().createEntity();
            pSSysBIHierarchy.set("PSSYSBIHIERARCHYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBIHierarchy);
            } else {
                iService.get(pSSysBIHierarchy);
            }
            this.onFillParentInfo_PSSysBIHierarchy(pSSysBILevel, pSSysBIHierarchy);
            return;
        }
        super.onFillParentInfo(pSSysBILevel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_TextPSDEF(PSSysBILevel pSSysBILevel, PSDEField pSDEField) throws Exception {
        pSSysBILevel.setTextPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBILevel.setTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ValuePSDEF(PSSysBILevel pSSysBILevel, PSDEField pSDEField) throws Exception {
        pSSysBILevel.setValuePSDEFId(pSDEField.getPSDEFieldId());
        pSSysBILevel.setValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysBIHierarchy(PSSysBILevel pSSysBILevel, PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        pSSysBILevel.setPSDEId(pSSysBIHierarchy.getPSDEId());
        pSSysBILevel.setPSSysBIHierarchyId(pSSysBIHierarchy.getPSSysBIHierarchyId());
        pSSysBILevel.setPSSysBIHierarchyName(pSSysBIHierarchy.getPSSysBIHierarchyName());
    }

    protected void onFillEntityFullInfo(PSSysBILevel pSSysBILevel, boolean bl) throws Exception {
        if (bl && pSSysBILevel.getCodeName() == null) {
            pSSysBILevel.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Level", 25));
        }
        super.onFillEntityFullInfo(pSSysBILevel, bl);
        this.onFillEntityFullInfo_TextPSDEF(pSSysBILevel, bl);
        this.onFillEntityFullInfo_ValuePSDEF(pSSysBILevel, bl);
        this.onFillEntityFullInfo_PSSysBIHierarchy(pSSysBILevel, bl);
    }

    protected void onFillEntityFullInfo_TextPSDEF(PSSysBILevel pSSysBILevel, boolean bl) throws Exception {
        if (pSSysBILevel.isTextPSDEFIdDirty()) {
            if (pSSysBILevel.getTextPSDEFId() != null) {
                if (pSSysBILevel.getTextPSDEFId() == null || pSSysBILevel.getTextPSDEFName() == null) {
                    PSDEField pSDEField = pSSysBILevel.getTextPSDEF();
                    pSSysBILevel.setTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysBILevel.setTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ValuePSDEF(PSSysBILevel pSSysBILevel, boolean bl) throws Exception {
        if (pSSysBILevel.isValuePSDEFIdDirty()) {
            if (pSSysBILevel.getValuePSDEFId() != null) {
                if (pSSysBILevel.getValuePSDEFId() == null || pSSysBILevel.getValuePSDEFName() == null) {
                    PSDEField pSDEField = pSSysBILevel.getValuePSDEF();
                    pSSysBILevel.setValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysBILevel.setValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysBIHierarchy(PSSysBILevel pSSysBILevel, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBILevel pSSysBILevel, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBILevel, bl);
    }

    public ArrayList<PSSysBILevel> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBILevel> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBILevel> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEXTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTextPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTextPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBILevel> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBILevel> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBILevel> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("VALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBILevel> selectByPSSysBIHierarchy(PSSysBIHierarchyBase pSSysBIHierarchyBase) throws Exception {
        return this.selectByPSSysBIHierarchy(pSSysBIHierarchyBase, "", -1);
    }

    public ArrayList<PSSysBILevel> selectByPSSysBIHierarchy(PSSysBIHierarchyBase pSSysBIHierarchyBase, String string) throws Exception {
        return this.selectByPSSysBIHierarchy(pSSysBIHierarchyBase, string, -1);
    }

    public ArrayList<PSSysBILevel> selectByPSSysBIHierarchy(PSSysBIHierarchyBase pSSysBIHierarchyBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIHIERARCHYID", (Object)pSSysBIHierarchyBase.getPSSysBIHierarchyId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBIHierarchyCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBIHierarchyCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBILevel> arrayList = this.selectByTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBILEVEL_PSDEFIELD_TEXTPSDEFID", "", iDataEntityModel.getName(), "PSSYSBILEVEL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBILevel> arrayList = this.selectByTextPSDEF(pSDEField);
        for (PSSysBILevel pSSysBILevel : arrayList) {
            PSSysBILevel pSSysBILevel2 = (PSSysBILevel)this.getDEModel().createEntity();
            pSSysBILevel2.setPSSysBILevelId(pSSysBILevel.getPSSysBILevelId());
            pSSysBILevel2.setTextPSDEFId(null);
            this.update(pSSysBILevel2);
        }
    }

    public void removeByTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBILevelServiceBase.this.onBeforeRemoveByTextPSDEF(pSDEField2);
                PSSysBILevelServiceBase.this.internalRemoveByTextPSDEF(pSDEField2);
                PSSysBILevelServiceBase.this.onAfterRemoveByTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBILevel> arrayList = this.selectByTextPSDEF(pSDEField);
        this.onBeforeRemoveByTextPSDEF(pSDEField, arrayList);
        for (PSSysBILevel pSSysBILevel : arrayList) {
            this.remove(pSSysBILevel);
        }
        this.onAfterRemoveByTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSSysBILevel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSSysBILevel> arrayList) throws Exception {
    }

    public void testRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBILevel> arrayList = this.selectByValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBILEVEL_PSDEFIELD_VALUEPSDEFID", "", iDataEntityModel.getName(), "PSSYSBILEVEL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBILevel> arrayList = this.selectByValuePSDEF(pSDEField);
        for (PSSysBILevel pSSysBILevel : arrayList) {
            PSSysBILevel pSSysBILevel2 = (PSSysBILevel)this.getDEModel().createEntity();
            pSSysBILevel2.setPSSysBILevelId(pSSysBILevel.getPSSysBILevelId());
            pSSysBILevel2.setValuePSDEFId(null);
            this.update(pSSysBILevel2);
        }
    }

    public void removeByValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBILevelServiceBase.this.onBeforeRemoveByValuePSDEF(pSDEField2);
                PSSysBILevelServiceBase.this.internalRemoveByValuePSDEF(pSDEField2);
                PSSysBILevelServiceBase.this.onAfterRemoveByValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBILevel> arrayList = this.selectByValuePSDEF(pSDEField);
        this.onBeforeRemoveByValuePSDEF(pSDEField, arrayList);
        for (PSSysBILevel pSSysBILevel : arrayList) {
            this.remove(pSSysBILevel);
        }
        this.onAfterRemoveByValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSSysBILevel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSSysBILevel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
    }

    public void resetPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        ArrayList<PSSysBILevel> arrayList = this.selectByPSSysBIHierarchy(pSSysBIHierarchy);
        for (PSSysBILevel pSSysBILevel : arrayList) {
            PSSysBILevel pSSysBILevel2 = (PSSysBILevel)this.getDEModel().createEntity();
            pSSysBILevel2.setPSSysBILevelId(pSSysBILevel.getPSSysBILevelId());
            pSSysBILevel2.setPSSysBIHierarchyId(null);
            this.update(pSSysBILevel2);
        }
    }

    public void removeByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        final PSSysBIHierarchy pSSysBIHierarchy2 = pSSysBIHierarchy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBILevelServiceBase.this.onBeforeRemoveByPSSysBIHierarchy(pSSysBIHierarchy2);
                PSSysBILevelServiceBase.this.internalRemoveByPSSysBIHierarchy(pSSysBIHierarchy2);
                PSSysBILevelServiceBase.this.onAfterRemoveByPSSysBIHierarchy(pSSysBIHierarchy2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
    }

    protected void internalRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        ArrayList<PSSysBILevel> arrayList = this.selectByPSSysBIHierarchy(pSSysBIHierarchy);
        this.onBeforeRemoveByPSSysBIHierarchy(pSSysBIHierarchy, arrayList);
        for (PSSysBILevel pSSysBILevel : arrayList) {
            this.remove(pSSysBILevel);
        }
        this.onAfterRemoveByPSSysBIHierarchy(pSSysBIHierarchy, arrayList);
    }

    protected void onAfterRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy, ArrayList<PSSysBILevel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy, ArrayList<PSSysBILevel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBILevel pSSysBILevel) throws Exception {
        PSSysBICubeLevelService pSSysBICubeLevelService = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
        pSSysBICubeLevelService.testRemoveByPSSysBILevel(pSSysBILevel);
        super.onBeforeRemove(pSSysBILevel);
    }

    protected void replaceParentInfo(PSSysBILevel pSSysBILevel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBILevel, cloneSession);
        if (pSSysBILevel.getTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBILevel.getTextPSDEFId())) != null) {
            this.onFillParentInfo_TextPSDEF(pSSysBILevel, (PSDEField)iEntity);
        }
        if (pSSysBILevel.getValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBILevel.getValuePSDEFId())) != null) {
            this.onFillParentInfo_ValuePSDEF(pSSysBILevel, (PSDEField)iEntity);
        }
        if (pSSysBILevel.getPSSysBIHierarchyId() != null && (iEntity = cloneSession.getEntity("PSSYSBIHIERARCHY", (Object)pSSysBILevel.getPSSysBIHierarchyId())) != null) {
            this.onFillParentInfo_PSSysBIHierarchy(pSSysBILevel, (PSSysBIHierarchy)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBILevel pSSysBILevel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBILevel, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AggCaption(bl, pSSysBILevel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BILevelTag(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BILevelTag2(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BILevelType(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIHierarchyId(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBILevelId(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBILevelName(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFId(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFName(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueMembers(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFId(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFName(bl, pSSysBILevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBILevel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AggCaption(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isAggCaptionDirty() : !pSSysBILevel.isAggCaptionDirty()) {
            return null;
        }
        String string = pSSysBILevel.getAggCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggCaption_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BILevelTag(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isBILevelTagDirty() : !pSSysBILevel.isBILevelTagDirty()) {
            return null;
        }
        String string = pSSysBILevel.getBILevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BILevelTag_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BILEVELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BILevelTag2(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isBILevelTag2Dirty() : !pSSysBILevel.isBILevelTag2Dirty()) {
            return null;
        }
        String string = pSSysBILevel.getBILevelTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BILevelTag2_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BILEVELTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BILevelType(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isBILevelTypeDirty() && !bl2 : !pSSysBILevel.isBILevelTypeDirty()) {
            return null;
        }
        String string = pSSysBILevel.getBILevelType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BILEVELTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BILevelType_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BILEVELTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isCodeNameDirty() && !bl2 : !pSSysBILevel.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBILevel.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBILevel, bl2, bl3);
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
                string3 = "PSSYSBIHIERARCHYID";
                String string4 = this.checkFieldDupRule(this.getPSSysBILevelDEModel(), "CODENAME", string3, pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isMemoDirty() : !pSSysBILevel.isMemoDirty()) {
            return null;
        }
        String string = pSSysBILevel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isOrderValueDirty() : !pSSysBILevel.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBILevel.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBIHierarchyId(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isPSSysBIHierarchyIdDirty() : !pSSysBILevel.isPSSysBIHierarchyIdDirty()) {
            return null;
        }
        String string = pSSysBILevel.getPSSysBIHierarchyId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIHierarchyId_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIHIERARCHYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBILevelId(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isPSSysBILevelIdDirty() && !bl2 : !pSSysBILevel.isPSSysBILevelIdDirty()) {
            return null;
        }
        String string = pSSysBILevel.getPSSysBILevelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBILEVELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBILevelId_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBILEVELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBILevelName(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isPSSysBILevelNameDirty() && !bl2 : !pSSysBILevel.isPSSysBILevelNameDirty()) {
            return null;
        }
        String string = pSSysBILevel.getPSSysBILevelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBILEVELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBILevelName_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBILEVELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFId(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isTextPSDEFIdDirty() : !pSSysBILevel.isTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBILevel.getTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFId_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFName(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isTextPSDEFNameDirty() : !pSSysBILevel.isTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysBILevel.getTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFName_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniqueMembers(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isUniqueMembersDirty() : !pSSysBILevel.isUniqueMembersDirty()) {
            return null;
        }
        Integer n = pSSysBILevel.getUniqueMembers();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UniqueMembers_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUEMEMBERS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isUserCatDirty() : !pSSysBILevel.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBILevel.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isUserTagDirty() : !pSSysBILevel.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBILevel.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isUserTag2Dirty() : !pSSysBILevel.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBILevel.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isUserTag3Dirty() : !pSSysBILevel.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBILevel.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isUserTag4Dirty() : !pSSysBILevel.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBILevel.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isValidFlagDirty() && !bl2 : !pSSysBILevel.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBILevel.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysBILevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValuePSDEFId(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isValuePSDEFIdDirty() : !pSSysBILevel.isValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBILevel.getValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFId_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValuePSDEFName(boolean bl, PSSysBILevel pSSysBILevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBILevel.isValuePSDEFNameDirty() : !pSSysBILevel.isValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysBILevel.getValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFName_Default(pSSysBILevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysBILevel pSSysBILevel, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBILevel, bl);
    }

    protected void onSyncIndexEntities(PSSysBILevel pSSysBILevel, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBILevel, bl);
    }

    public Object getDataContextValue(PSSysBILevel pSSysBILevel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBILevel, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBIHierarchy pSSysBIHierarchy = pSSysBILevel.getPSSysBIHierarchy();
        if (pSSysBIHierarchy != null && pSSysBIHierarchy.contains(string)) {
            return pSSysBIHierarchy.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBILevel pSSysBILevel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBILevel, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGGCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BILEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BILevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BILEVELTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BILevelTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BILEVELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BILevelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIHIERARCHYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIHierarchyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIHIERARCHYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIHierarchyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBILEVELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBILevelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBILEVELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBILevelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIQUEMEMBERS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniqueMembers_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AggCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGCAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BILevelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BILEVELTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BILevelTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BILEVELTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BILevelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BILEVELTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSSysBIHierarchyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIHIERARCHYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIHierarchyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIHIERARCHYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBILevelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBILEVELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBILevelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBILEVELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniqueMembers_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBILevel pSSysBILevel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBILevel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBILevel pSSysBILevel) throws Exception {
        super.onUpdateParent(pSSysBILevel);
    }

    @Override
    protected void exportCurXmlModel(PSSysBILevel pSSysBILevel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBILEVEL");
        if (!bl) {
            pSSysBILevel.setCreateDate(null);
            pSSysBILevel.setCreateMan(null);
            pSSysBILevel.setPSSysBILevelId(null);
            pSSysBILevel.setUpdateDate(null);
            pSSysBILevel.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBILevel, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBILevel pSSysBILevel, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBILevel, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIHIERARCHYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBIHIERARCHY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIHIERARCHYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBILEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIHIERARCHYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIHIERARCHYNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBIHIERARCHY", (boolean)true) == 0) {
            iEntity.set("PSSYSBIHIERARCHYID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBIHIERARCHYID"};
    }

    @Override
    public String getModelV2Tag(PSSysBILevel pSSysBILevel) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBILevel.getCodeName())) {
            return pSSysBILevel.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBILevel.getCodeName())) {
            return pSSysBILevel.getCodeName();
        }
        return super.getModelV2Tag(pSSysBILevel);
    }

    @Override
    public boolean setModelV2Tag(PSSysBILevel pSSysBILevel, String string) {
        pSSysBILevel.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBIHIERARCHYID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBILevel pSSysBILevel, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBILevel.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBILevel, true);
        pSSysBILevel.set("CODENAME", string);
        if (this.select(pSSysBILevel, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBILevel, true);
        return super.getModelV2Entity(pSSysBILevel, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBILevel pSSysBILevel, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBILevel, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBILevel pSSysBILevel, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Level");
    }
}

