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
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.search.service;

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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.search.dao.PSSysSearchDEFieldDAO;
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchDEFieldDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDEBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDEField;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchField;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchFieldBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchDEFieldServiceBase
extends PSCoreSysServiceBase<PSSysSearchDEField> {
    private static final Log log = LogFactory.getLog(PSSysSearchDEFieldServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCSEARCHDE = "CalcSearchDE";
    public static final String ACTION_CALCSEARCHDOC = "CalcSearchDoc";
    private PSSysSearchDEFieldDEModel pSSysSearchDEFieldDEModel;
    private PSSysSearchDEFieldDAO pSSysSearchDEFieldDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldService";
    }

    public PSSysSearchDEFieldDEModel getPSSysSearchDEFieldDEModel() {
        if (this.pSSysSearchDEFieldDEModel == null) {
            try {
                this.pSSysSearchDEFieldDEModel = (PSSysSearchDEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchDEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDEFieldDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSearchDEFieldDEModel();
    }

    public PSSysSearchDEFieldDAO getPSSysSearchDEFieldDAO() {
        if (this.pSSysSearchDEFieldDAO == null) {
            try {
                this.pSSysSearchDEFieldDAO = (PSSysSearchDEFieldDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.search.dao.PSSysSearchDEFieldDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDEFieldDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSearchDEFieldDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCSEARCHDE, (boolean)true) == 0) {
            this.calcSearchDE((PSSysSearchDEField)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CALCSEARCHDOC, (boolean)true) == 0) {
            this.calcSearchDoc((PSSysSearchDEField)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcSearchDE(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCSEARCHDE, 0, pSSysSearchDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysSearchDEField, ACTION_CALCSEARCHDE);
        final PSSysSearchDEField pSSysSearchDEField2 = pSSysSearchDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysSearchDEFieldServiceBase.this.getService(), PSSysSearchDEFieldServiceBase.ACTION_CALCSEARCHDE, 40, pSSysSearchDEField2, null).getResult() != 1) {
                    PSSysSearchDEFieldServiceBase.this.onCalcSearchDE(pSSysSearchDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCSEARCHDE, 99, pSSysSearchDEField, null);
        }
    }

    protected void onCalcSearchDE(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcSearchDE]");
    }

    public void calcSearchDoc(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCSEARCHDOC, 0, pSSysSearchDEField, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysSearchDEField, ACTION_CALCSEARCHDOC);
        final PSSysSearchDEField pSSysSearchDEField2 = pSSysSearchDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysSearchDEFieldServiceBase.this.getService(), PSSysSearchDEFieldServiceBase.ACTION_CALCSEARCHDOC, 40, pSSysSearchDEField2, null).getResult() != 1) {
                    PSSysSearchDEFieldServiceBase.this.onCalcSearchDoc(pSSysSearchDEField2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCSEARCHDOC, 99, pSSysSearchDEField, null);
        }
    }

    protected void onCalcSearchDoc(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcSearchDoc]");
    }

    protected void onFillParentInfo(PSSysSearchDEField pSSysSearchDEField, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHDEFIELD_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysSearchDEField, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchDEService", (SessionFactory)this.getSessionFactory());
            PSSysSearchDE pSSysSearchDE = (PSSysSearchDE)iService.getDEModel().createEntity();
            pSSysSearchDE.set("PSSYSSEARCHDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSearchDE);
            } else {
                iService.get(pSSysSearchDE);
            }
            this.onFillParentInfo_PSSysSearchDE(pSSysSearchDEField, pSSysSearchDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHFIELD_PSSYSSEARCHFIELDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchFieldService", (SessionFactory)this.getSessionFactory());
            PSSysSearchField pSSysSearchField = (PSSysSearchField)iService.getDEModel().createEntity();
            pSSysSearchField.set("PSSYSSEARCHFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSearchField);
            } else {
                iService.get(pSSysSearchField);
            }
            this.onFillParentInfo_PSSysSearchField(pSSysSearchDEField, pSSysSearchField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHDEFIELD_PSSYSTRANSLATOR_PSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTranslator);
            } else {
                iService.get(pSSysTranslator);
            }
            this.onFillParentInfo_PSSysTranslator(pSSysSearchDEField, pSSysTranslator);
            return;
        }
        super.onFillParentInfo(pSSysSearchDEField, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEF(PSSysSearchDEField pSSysSearchDEField, PSDEField pSDEField) throws Exception {
        pSSysSearchDEField.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysSearchDEField.setPSDEFName(pSDEField.getPSDEFieldName());
        pSSysSearchDEField.setPSDEId(pSDEField.getPSDEId());
    }

    protected void onFillParentInfo_PSSysSearchDE(PSSysSearchDEField pSSysSearchDEField, PSSysSearchDE pSSysSearchDE) throws Exception {
        pSSysSearchDEField.setPSSysSearchDEId(pSSysSearchDE.getPSSysSearchDEId());
        pSSysSearchDEField.setPSSysSearchDEName(pSSysSearchDE.getPSSysSearchDEName());
        pSSysSearchDEField.setPSSysSearchDocId(pSSysSearchDE.getPSSysSearchDocId());
    }

    protected void onFillParentInfo_PSSysSearchField(PSSysSearchDEField pSSysSearchDEField, PSSysSearchField pSSysSearchField) throws Exception {
        pSSysSearchDEField.setPSSysSearchFieldId(pSSysSearchField.getPSSysSearchFieldId());
        pSSysSearchDEField.setPSSysSearchFieldName(pSSysSearchField.getPSSysSearchFieldName());
    }

    protected void onFillParentInfo_PSSysTranslator(PSSysSearchDEField pSSysSearchDEField, PSSysTranslator pSSysTranslator) throws Exception {
        pSSysSearchDEField.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSSysSearchDEField.setPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillEntityFullInfo(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
        if (bl && pSSysSearchDEField.getValidFlag() == null) {
            pSSysSearchDEField.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysSearchDEField, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysSearchDEField, bl);
        this.onFillEntityFullInfo_PSSysSearchDE(pSSysSearchDEField, bl);
        this.onFillEntityFullInfo_PSSysSearchField(pSSysSearchDEField, bl);
        this.onFillEntityFullInfo_PSSysTranslator(pSSysSearchDEField, bl);
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSearchDE(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSearchField(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTranslator(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysSearchDEField, bl);
    }

    public ArrayList<PSSysSearchDEField> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysSearchDEField> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysSearchDEField> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysSearchDE(PSSysSearchDEBase pSSysSearchDEBase) throws Exception {
        return this.selectByPSSysSearchDE(pSSysSearchDEBase, "", -1);
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysSearchDE(PSSysSearchDEBase pSSysSearchDEBase, String string) throws Exception {
        return this.selectByPSSysSearchDE(pSSysSearchDEBase, string, -1);
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysSearchDE(PSSysSearchDEBase pSSysSearchDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHDEID", (Object)pSSysSearchDEBase.getPSSysSearchDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysSearchField(PSSysSearchFieldBase pSSysSearchFieldBase) throws Exception {
        return this.selectByPSSysSearchField(pSSysSearchFieldBase, "", -1);
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysSearchField(PSSysSearchFieldBase pSSysSearchFieldBase, String string) throws Exception {
        return this.selectByPSSysSearchField(pSSysSearchFieldBase, string, -1);
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysSearchField(PSSysSearchFieldBase pSSysSearchFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHFIELDID", (Object)pSSysSearchFieldBase.getPSSysSearchFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchFieldCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchFieldCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSSysSearchDEField> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHDEFIELD_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSSEARCHDEFIELD", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysSearchDEField pSSysSearchDEField : arrayList) {
            PSSysSearchDEField pSSysSearchDEField2 = (PSSysSearchDEField)this.getDEModel().createEntity();
            pSSysSearchDEField2.setPSSysSearchDEFieldId(pSSysSearchDEField.getPSSysSearchDEFieldId());
            pSSysSearchDEField2.setPSDEFId(null);
            this.update(pSSysSearchDEField2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchDEFieldServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysSearchDEFieldServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysSearchDEFieldServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysSearchDEField pSSysSearchDEField : arrayList) {
            this.remove(pSSysSearchDEField);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysSearchDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysSearchDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchDE(PSSysSearchDE pSSysSearchDE) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysSearchDE(pSSysSearchDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSearchDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID", "", iDataEntityModel.getName(), "PSSYSSEARCHDEFIELD", iDataEntityModel.getDataInfo(pSSysSearchDE), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchDE(PSSysSearchDE pSSysSearchDE) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysSearchDE(pSSysSearchDE);
        for (PSSysSearchDEField pSSysSearchDEField : arrayList) {
            PSSysSearchDEField pSSysSearchDEField2 = (PSSysSearchDEField)this.getDEModel().createEntity();
            pSSysSearchDEField2.setPSSysSearchDEFieldId(pSSysSearchDEField.getPSSysSearchDEFieldId());
            pSSysSearchDEField2.setPSSysSearchDEId(null);
            this.update(pSSysSearchDEField2);
        }
    }

    public void removeByPSSysSearchDE(PSSysSearchDE pSSysSearchDE) throws Exception {
        final PSSysSearchDE pSSysSearchDE2 = pSSysSearchDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchDEFieldServiceBase.this.onBeforeRemoveByPSSysSearchDE(pSSysSearchDE2);
                PSSysSearchDEFieldServiceBase.this.internalRemoveByPSSysSearchDE(pSSysSearchDE2);
                PSSysSearchDEFieldServiceBase.this.onAfterRemoveByPSSysSearchDE(pSSysSearchDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchDE(PSSysSearchDE pSSysSearchDE) throws Exception {
    }

    protected void internalRemoveByPSSysSearchDE(PSSysSearchDE pSSysSearchDE) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysSearchDE(pSSysSearchDE);
        this.onBeforeRemoveByPSSysSearchDE(pSSysSearchDE, arrayList);
        for (PSSysSearchDEField pSSysSearchDEField : arrayList) {
            this.remove(pSSysSearchDEField);
        }
        this.onAfterRemoveByPSSysSearchDE(pSSysSearchDE, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchDE(PSSysSearchDE pSSysSearchDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchDE(PSSysSearchDE pSSysSearchDE, ArrayList<PSSysSearchDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchDE(PSSysSearchDE pSSysSearchDE, ArrayList<PSSysSearchDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchField(PSSysSearchField pSSysSearchField) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysSearchField(pSSysSearchField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSearchField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHFIELD_PSSYSSEARCHFIELDID", "", iDataEntityModel.getName(), "PSSYSSEARCHDEFIELD", iDataEntityModel.getDataInfo(pSSysSearchField), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchField(PSSysSearchField pSSysSearchField) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysSearchField(pSSysSearchField);
        for (PSSysSearchDEField pSSysSearchDEField : arrayList) {
            PSSysSearchDEField pSSysSearchDEField2 = (PSSysSearchDEField)this.getDEModel().createEntity();
            pSSysSearchDEField2.setPSSysSearchDEFieldId(pSSysSearchDEField.getPSSysSearchDEFieldId());
            pSSysSearchDEField2.setPSSysSearchFieldId(null);
            this.update(pSSysSearchDEField2);
        }
    }

    public void removeByPSSysSearchField(PSSysSearchField pSSysSearchField) throws Exception {
        final PSSysSearchField pSSysSearchField2 = pSSysSearchField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchDEFieldServiceBase.this.onBeforeRemoveByPSSysSearchField(pSSysSearchField2);
                PSSysSearchDEFieldServiceBase.this.internalRemoveByPSSysSearchField(pSSysSearchField2);
                PSSysSearchDEFieldServiceBase.this.onAfterRemoveByPSSysSearchField(pSSysSearchField2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchField(PSSysSearchField pSSysSearchField) throws Exception {
    }

    protected void internalRemoveByPSSysSearchField(PSSysSearchField pSSysSearchField) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysSearchField(pSSysSearchField);
        this.onBeforeRemoveByPSSysSearchField(pSSysSearchField, arrayList);
        for (PSSysSearchDEField pSSysSearchDEField : arrayList) {
            this.remove(pSSysSearchDEField);
        }
        this.onAfterRemoveByPSSysSearchField(pSSysSearchField, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchField(PSSysSearchField pSSysSearchField) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchField(PSSysSearchField pSSysSearchField, ArrayList<PSSysSearchDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchField(PSSysSearchField pSSysSearchField, ArrayList<PSSysSearchDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHDEFIELD_PSSYSTRANSLATOR_PSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSSYSSEARCHDEFIELD", iDataEntityModel.getDataInfo(pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        for (PSSysSearchDEField pSSysSearchDEField : arrayList) {
            PSSysSearchDEField pSSysSearchDEField2 = (PSSysSearchDEField)this.getDEModel().createEntity();
            pSSysSearchDEField2.setPSSysSearchDEFieldId(pSSysSearchDEField.getPSSysSearchDEFieldId());
            pSSysSearchDEField2.setPSSysTranslatorId(null);
            this.update(pSSysSearchDEField2);
        }
    }

    public void removeByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchDEFieldServiceBase.this.onBeforeRemoveByPSSysTranslator(pSSysTranslator2);
                PSSysSearchDEFieldServiceBase.this.internalRemoveByPSSysTranslator(pSSysTranslator2);
                PSSysSearchDEFieldServiceBase.this.onAfterRemoveByPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysSearchDEField> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByPSSysTranslator(pSSysTranslator, arrayList);
        for (PSSysSearchDEField pSSysSearchDEField : arrayList) {
            this.remove(pSSysSearchDEField);
        }
        this.onAfterRemoveByPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSSysSearchDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSSysSearchDEField> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        super.onBeforeRemove(pSSysSearchDEField);
    }

    protected void replaceParentInfo(PSSysSearchDEField pSSysSearchDEField, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysSearchDEField, cloneSession);
        if (pSSysSearchDEField.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysSearchDEField.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysSearchDEField, (PSDEField)iEntity);
        }
        if (pSSysSearchDEField.getPSSysSearchDEId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHDE", (Object)pSSysSearchDEField.getPSSysSearchDEId())) != null) {
            this.onFillParentInfo_PSSysSearchDE(pSSysSearchDEField, (PSSysSearchDE)iEntity);
        }
        if (pSSysSearchDEField.getPSSysSearchFieldId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHFIELD", (Object)pSSysSearchDEField.getPSSysSearchFieldId())) != null) {
            this.onFillParentInfo_PSSysSearchField(pSSysSearchDEField, (PSSysSearchField)iEntity);
        }
        if (pSSysSearchDEField.getPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSSysSearchDEField.getPSSysTranslatorId())) != null) {
            this.onFillParentInfo_PSSysTranslator(pSSysSearchDEField, (PSSysTranslator)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysSearchDEField, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysSearchDEField, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValueType(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldParams(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Fields(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldTag(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldTag2(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDEFieldId(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDEFieldName(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDEId(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchFieldId(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorId(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysSearchDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysSearchDEField, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isCodeNameDirty() : !pSSysSearchDEField.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysSearchDEField, bl2, bl3);
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
                string3 = "PSSYSSEARCHDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchDEFieldDEModel(), "CODENAME", string3, pSSysSearchDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isDefaultValueDirty() : !pSSysSearchDEField.isDefaultValueDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValueType(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isDefaultValueTypeDirty() : !pSSysSearchDEField.isDefaultValueTypeDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getDefaultValueType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValueType_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldParams(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isFieldParamsDirty() : !pSSysSearchDEField.isFieldParamsDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getFieldParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldParams_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Fields(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isFieldsDirty() : !pSSysSearchDEField.isFieldsDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Fields_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldTag(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isFieldTagDirty() : !pSSysSearchDEField.isFieldTagDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getFieldTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldTag_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldTag2(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isFieldTag2Dirty() : !pSSysSearchDEField.isFieldTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getFieldTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldTag2_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isMemoDirty() : !pSSysSearchDEField.isMemoDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysSearchDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isOrderValueDirty() : !pSSysSearchDEField.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysSearchDEField.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysSearchDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isPSDEFIdDirty() : !pSSysSearchDEField.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
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
                string3 = "PSSYSSEARCHDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchDEFieldDEModel(), "PSDEFID", string3, pSSysSearchDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDEFieldId(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isPSSysSearchDEFieldIdDirty() && !bl2 : !pSSysSearchDEField.isPSSysSearchDEFieldIdDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getPSSysSearchDEFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDEFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDEFieldId_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDEFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDEFieldName(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isPSSysSearchDEFieldNameDirty() && !bl2 : !pSSysSearchDEField.isPSSysSearchDEFieldNameDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getPSSysSearchDEFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDEFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDEFieldName_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDEFIELDNAME");
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
                string3 = "PSSYSSEARCHDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchDEFieldDEModel(), "PSSYSSEARCHDEFIELDNAME", string3, pSSysSearchDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSEARCHDEFIELDNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDEId(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isPSSysSearchDEIdDirty() : !pSSysSearchDEField.isPSSysSearchDEIdDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getPSSysSearchDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDEId_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchFieldId(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isPSSysSearchFieldIdDirty() && !bl2 : !pSSysSearchDEField.isPSSysSearchFieldIdDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getPSSysSearchFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchFieldId_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHFIELDID");
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
                string3 = "PSSYSSEARCHDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchDEFieldDEModel(), "PSSYSSEARCHFIELDID", string3, pSSysSearchDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSEARCHFIELDID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTranslatorId(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isPSSysTranslatorIdDirty() : !pSSysSearchDEField.isPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorId_Default(pSSysSearchDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isUserCatDirty() : !pSSysSearchDEField.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysSearchDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isUserTagDirty() : !pSSysSearchDEField.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysSearchDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isUserTag2Dirty() : !pSSysSearchDEField.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysSearchDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isUserTag3Dirty() : !pSSysSearchDEField.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysSearchDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isUserTag4Dirty() : !pSSysSearchDEField.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSearchDEField.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysSearchDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysSearchDEField pSSysSearchDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchDEField.isValidFlagDirty() && !bl2 : !pSSysSearchDEField.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchDEField.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysSearchDEField, bl2, bl3);
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

    protected void onSyncEntity(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
        super.onSyncEntity(pSSysSearchDEField, bl);
    }

    protected void onSyncIndexEntities(PSSysSearchDEField pSSysSearchDEField, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysSearchDEField, bl);
    }

    public Object getDataContextValue(PSSysSearchDEField pSSysSearchDEField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysSearchDEField, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysSearchDE pSSysSearchDE = pSSysSearchDEField.getPSSysSearchDE();
        if (pSSysSearchDE != null && pSSysSearchDE.contains(string)) {
            return pSSysSearchDE.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSearchDEField pSSysSearchDEField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysSearchDEField, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValueType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Fields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDEFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDEFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDEFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDEFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUETYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Fields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysSearchDEFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDEFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDEFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDEFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHFIELDNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysSearchDEField pSSysSearchDEField) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysSearchDEField)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        super.onUpdateParent(pSSysSearchDEField);
    }

    @Override
    protected void exportCurXmlModel(PSSysSearchDEField pSSysSearchDEField, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSEARCHDEFIELD");
        if (!bl) {
            pSSysSearchDEField.setCreateDate(null);
            pSSysSearchDEField.setCreateMan(null);
            pSSysSearchDEField.setPSSysSearchDEFieldId(null);
            pSSysSearchDEField.setUpdateDate(null);
            pSSysSearchDEField.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSearchDEField, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSearchDEField pSSysSearchDEField, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSearchDEField, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSEARCHDE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEARCHDEFIELD_PSSYSSEARCHDE_PSSYSSEARCHDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDE", (boolean)true) == 0) {
            iEntity.set("PSSYSSEARCHDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSEARCHDEID"};
    }

    @Override
    public String getModelV2Tag(PSSysSearchDEField pSSysSearchDEField) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchDEField.getPSSysSearchDEFieldName())) {
            return pSSysSearchDEField.getPSSysSearchDEFieldName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchDEField.getCodeName())) {
            return pSSysSearchDEField.getCodeName();
        }
        return super.getModelV2Tag(pSSysSearchDEField);
    }

    @Override
    public boolean setModelV2Tag(PSSysSearchDEField pSSysSearchDEField, String string) {
        pSSysSearchDEField.setPSSysSearchDEFieldName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSSEARCHDEFIELDNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSSEARCHDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSearchDEField pSSysSearchDEField, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSearchDEField.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSearchDEField, true);
        pSSysSearchDEField.set("PSSYSSEARCHDEFIELDNAME", string);
        if (this.select(pSSysSearchDEField, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSearchDEField, true);
        return super.getModelV2Entity(pSSysSearchDEField, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSearchDEField pSSysSearchDEField, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysSearchDEField, objectNode, string, string2, n);
    }
}

