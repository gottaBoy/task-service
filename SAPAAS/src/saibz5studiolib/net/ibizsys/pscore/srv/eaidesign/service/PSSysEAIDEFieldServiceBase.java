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
package net.ibizsys.pscore.srv.eaidesign.service;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDEFieldDAO;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDEFieldDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDEBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDEField;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementAttr;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementAttrBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementRE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementREBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDEFieldServiceBase
extends PSCoreSysServiceBase<PSSysEAIDEField> {
    private static final Log log = LogFactory.getLog(PSSysEAIDEFieldServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysEAIDEFieldDEModel pSSysEAIDEFieldDEModel;
    private PSSysEAIDEFieldDAO pSSysEAIDEFieldDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldService";
    }

    public PSSysEAIDEFieldDEModel getPSSysEAIDEFieldDEModel() {
        if (this.pSSysEAIDEFieldDEModel == null) {
            try {
                this.pSSysEAIDEFieldDEModel = (PSSysEAIDEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDEFieldDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEAIDEFieldDEModel();
    }

    public PSSysEAIDEFieldDAO getPSSysEAIDEFieldDAO() {
        if (this.pSSysEAIDEFieldDAO == null) {
            try {
                this.pSSysEAIDEFieldDAO = (PSSysEAIDEFieldDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDEFieldDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDEFieldDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEAIDEFieldDAO();
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

    protected void onFillParentInfo(PSSysEAIDEField pSSysEAIDEField, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDEFIELD_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysEAIDEField, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDEFIELD_PSSYSEAIDE_PSSYSEAIDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService", (SessionFactory)this.getSessionFactory());
            PSSysEAIDE pSSysEAIDE = (PSSysEAIDE)iService.getDEModel().createEntity();
            pSSysEAIDE.set("PSSYSEAIDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIDE);
            } else {
                iService.get((IEntity)pSSysEAIDE);
            }
            this.onFillParentInfo_PSSysEAIDE(pSSysEAIDEField, pSSysEAIDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDEFIELD_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENTATTRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElementAttr pSSysEAIElementAttr = (PSSysEAIElementAttr)iService.getDEModel().createEntity();
            pSSysEAIElementAttr.set("PSSYSEAIELEMENTATTRID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIElementAttr);
            } else {
                iService.get((IEntity)pSSysEAIElementAttr);
            }
            this.onFillParentInfo_PSSysEAIElementAttr(pSSysEAIDEField, pSSysEAIElementAttr);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDEFIELD_PSSYSEAIELEMENTRE_PSSYSEAIELEMENTREID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElementRE pSSysEAIElementRE = (PSSysEAIElementRE)iService.getDEModel().createEntity();
            pSSysEAIElementRE.set("PSSYSEAIELEMENTREID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIElementRE);
            } else {
                iService.get((IEntity)pSSysEAIElementRE);
            }
            this.onFillParentInfo_PSSysEAIElementRE(pSSysEAIDEField, pSSysEAIElementRE);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysEAIDEField, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEF(PSSysEAIDEField pSSysEAIDEField, PSDEField pSDEField) throws Exception {
        pSSysEAIDEField.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysEAIDEField.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysEAIDE(PSSysEAIDEField pSSysEAIDEField, PSSysEAIDE pSSysEAIDE) throws Exception {
        pSSysEAIDEField.setPSDEId(pSSysEAIDE.getPSDEId());
        pSSysEAIDEField.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
        pSSysEAIDEField.setPSSysEAIDEName(pSSysEAIDE.getPSSysEAIDEName());
        pSSysEAIDEField.setPSSysEAIElementId(pSSysEAIDE.getPSSysEAIElementId());
    }

    protected void onFillParentInfo_PSSysEAIElementAttr(PSSysEAIDEField pSSysEAIDEField, PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
        pSSysEAIDEField.setPSSysEAIElementAttrId(pSSysEAIElementAttr.getPSSysEAIElementAttrId());
        pSSysEAIDEField.setPSSysEAIElementAttrName(pSSysEAIElementAttr.getPSSysEAIElementAttrName());
    }

    protected void onFillParentInfo_PSSysEAIElementRE(PSSysEAIDEField pSSysEAIDEField, PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        pSSysEAIDEField.setPSSysEAIElementREId(pSSysEAIElementRE.getPSSysEAIElementREId());
        pSSysEAIDEField.setPSSysEAIElementREName(pSSysEAIElementRE.getPSSysEAIElementREName());
    }

    protected void onFillEntityFullInfo(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
        if (bl) {
            if (pSSysEAIDEField.getCodeName() == null) {
                pSSysEAIDEField.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "EAIDEField", 25));
            }
            if (pSSysEAIDEField.getPSSysEAIDEFieldName() == null) {
                pSSysEAIDEField.setPSSysEAIDEFieldName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5c5e\u6027\u6620\u5c04", 25));
            }
            if (pSSysEAIDEField.getValidFlag() == null) {
                pSSysEAIDEField.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysEAIDEField, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysEAIDEField, bl);
        this.onFillEntityFullInfo_PSSysEAIDE(pSSysEAIDEField, bl);
        this.onFillEntityFullInfo_PSSysEAIElementAttr(pSSysEAIDEField, bl);
        this.onFillEntityFullInfo_PSSysEAIElementRE(pSSysEAIDEField, bl);
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIDE(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIElementAttr(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIElementRE(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysEAIDEField, bl);
    }

    public ArrayList<PSSysEAIDEField> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysEAIDEField> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysEAIDEField> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase) throws Exception {
        return this.selectByPSSysEAIDE(pSSysEAIDEBase, "", -1);
    }

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase, String string) throws Exception {
        return this.selectByPSSysEAIDE(pSSysEAIDEBase, string, -1);
    }

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIDEID", (Object)pSSysEAIDEBase.getPSSysEAIDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIDEField> selectTempByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase) throws Exception {
        return this.selectTempByPSSysEAIDE(pSSysEAIDEBase, "");
    }

    public ArrayList<PSSysEAIDEField> selectTempByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIDEID", (Object)pSSysEAIDEBase.getPSSysEAIDEId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysEAIDECond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysEAIDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIElementAttr(PSSysEAIElementAttrBase pSSysEAIElementAttrBase) throws Exception {
        return this.selectByPSSysEAIElementAttr(pSSysEAIElementAttrBase, "", -1);
    }

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIElementAttr(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, String string) throws Exception {
        return this.selectByPSSysEAIElementAttr(pSSysEAIElementAttrBase, string, -1);
    }

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIElementAttr(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIELEMENTATTRID", (Object)pSSysEAIElementAttrBase.getPSSysEAIElementAttrId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIElementAttrCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIElementAttrCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIElementRE(PSSysEAIElementREBase pSSysEAIElementREBase) throws Exception {
        return this.selectByPSSysEAIElementRE(pSSysEAIElementREBase, "", -1);
    }

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIElementRE(PSSysEAIElementREBase pSSysEAIElementREBase, String string) throws Exception {
        return this.selectByPSSysEAIElementRE(pSSysEAIElementREBase, string, -1);
    }

    public ArrayList<PSSysEAIDEField> selectByPSSysEAIElementRE(PSSysEAIElementREBase pSSysEAIElementREBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIELEMENTREID", (Object)pSSysEAIElementREBase.getPSSysEAIElementREId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIElementRECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIElementRECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDEFIELD_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSEAIDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            PSSysEAIDEField pSSysEAIDEField2 = (PSSysEAIDEField)this.getDEModel().createEntity();
            pSSysEAIDEField2.setPSSysEAIDEFieldId(pSSysEAIDEField.getPSSysEAIDEFieldId());
            pSSysEAIDEField2.setPSDEFId(null);
            this.update(pSSysEAIDEField2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDEFieldServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysEAIDEFieldServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysEAIDEFieldServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            this.remove((IEntity)pSSysEAIDEField);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    public void resetPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSSysEAIDE(pSSysEAIDE);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            PSSysEAIDEField pSSysEAIDEField2 = (PSSysEAIDEField)this.getDEModel().createEntity();
            pSSysEAIDEField2.setPSSysEAIDEFieldId(pSSysEAIDEField.getPSSysEAIDEFieldId());
            pSSysEAIDEField2.setPSSysEAIDEId(null);
            this.update(pSSysEAIDEField2);
        }
    }

    public void resetTempPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectTempByPSSysEAIDE(pSSysEAIDE);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            PSSysEAIDEField pSSysEAIDEField2 = (PSSysEAIDEField)this.getDEModel().createEntity();
            pSSysEAIDEField2.setPSSysEAIDEFieldId(pSSysEAIDEField.getPSSysEAIDEFieldId());
            pSSysEAIDEField2.setPSSysEAIDEId(null);
            this.updateTemp((IEntity)pSSysEAIDEField2);
        }
    }

    public void removeByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        final PSSysEAIDE pSSysEAIDE2 = pSSysEAIDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDEFieldServiceBase.this.onBeforeRemoveByPSSysEAIDE(pSSysEAIDE2);
                PSSysEAIDEFieldServiceBase.this.internalRemoveByPSSysEAIDE(pSSysEAIDE2);
                PSSysEAIDEFieldServiceBase.this.onAfterRemoveByPSSysEAIDE(pSSysEAIDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    protected void internalRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSSysEAIDE(pSSysEAIDE);
        this.onBeforeRemoveByPSSysEAIDE(pSSysEAIDE, arrayList);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            this.remove((IEntity)pSSysEAIDEField);
        }
        this.onAfterRemoveByPSSysEAIDE(pSSysEAIDE, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIElementAttr(PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSSysEAIElementAttr(pSSysEAIElementAttr, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIELEMENTATTR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIElementAttr);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDEFIELD_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENTATTRID", "", iDataEntityModel.getName(), "PSSYSEAIDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysEAIElementAttr), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIElementAttr(PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSSysEAIElementAttr(pSSysEAIElementAttr);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            PSSysEAIDEField pSSysEAIDEField2 = (PSSysEAIDEField)this.getDEModel().createEntity();
            pSSysEAIDEField2.setPSSysEAIDEFieldId(pSSysEAIDEField.getPSSysEAIDEFieldId());
            pSSysEAIDEField2.setPSSysEAIElementAttrId(null);
            this.update(pSSysEAIDEField2);
        }
    }

    public void removeByPSSysEAIElementAttr(PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
        final PSSysEAIElementAttr pSSysEAIElementAttr2 = pSSysEAIElementAttr;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDEFieldServiceBase.this.onBeforeRemoveByPSSysEAIElementAttr(pSSysEAIElementAttr2);
                PSSysEAIDEFieldServiceBase.this.internalRemoveByPSSysEAIElementAttr(pSSysEAIElementAttr2);
                PSSysEAIDEFieldServiceBase.this.onAfterRemoveByPSSysEAIElementAttr(pSSysEAIElementAttr2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIElementAttr(PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
    }

    protected void internalRemoveByPSSysEAIElementAttr(PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSSysEAIElementAttr(pSSysEAIElementAttr);
        this.onBeforeRemoveByPSSysEAIElementAttr(pSSysEAIElementAttr, arrayList);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            this.remove((IEntity)pSSysEAIDEField);
        }
        this.onAfterRemoveByPSSysEAIElementAttr(pSSysEAIElementAttr, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIElementAttr(PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIElementAttr(PSSysEAIElementAttr pSSysEAIElementAttr, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIElementAttr(PSSysEAIElementAttr pSSysEAIElementAttr, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSSysEAIElementRE(pSSysEAIElementRE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIELEMENTRE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIElementRE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDEFIELD_PSSYSEAIELEMENTRE_PSSYSEAIELEMENTREID", "", iDataEntityModel.getName(), "PSSYSEAIDEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysEAIElementRE), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSSysEAIElementRE(pSSysEAIElementRE);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            PSSysEAIDEField pSSysEAIDEField2 = (PSSysEAIDEField)this.getDEModel().createEntity();
            pSSysEAIDEField2.setPSSysEAIDEFieldId(pSSysEAIDEField.getPSSysEAIDEFieldId());
            pSSysEAIDEField2.setPSSysEAIElementREId(null);
            this.update(pSSysEAIDEField2);
        }
    }

    public void removeByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        final PSSysEAIElementRE pSSysEAIElementRE2 = pSSysEAIElementRE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDEFieldServiceBase.this.onBeforeRemoveByPSSysEAIElementRE(pSSysEAIElementRE2);
                PSSysEAIDEFieldServiceBase.this.internalRemoveByPSSysEAIElementRE(pSSysEAIElementRE2);
                PSSysEAIDEFieldServiceBase.this.onAfterRemoveByPSSysEAIElementRE(pSSysEAIElementRE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
    }

    protected void internalRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectByPSSysEAIElementRE(pSSysEAIElementRE);
        this.onBeforeRemoveByPSSysEAIElementRE(pSSysEAIElementRE, arrayList);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            this.remove((IEntity)pSSysEAIDEField);
        }
        this.onAfterRemoveByPSSysEAIElementRE(pSSysEAIElementRE, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEAIDEField pSSysEAIDEField) throws Exception {
        super.onBeforeRemove(pSSysEAIDEField);
    }

    public void removeTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        final PSSysEAIDE pSSysEAIDE2 = pSSysEAIDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDEFieldServiceBase.this.onBeforeRemoveTempByPSSysEAIDE(pSSysEAIDE2);
                PSSysEAIDEFieldServiceBase.this.internalRemoveTempByPSSysEAIDE(pSSysEAIDE2);
                PSSysEAIDEFieldServiceBase.this.onAfterRemoveTempByPSSysEAIDE(pSSysEAIDE2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    protected void internalRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        ArrayList<PSSysEAIDEField> arrayList = this.selectTempByPSSysEAIDE(pSSysEAIDE);
        this.onBeforeRemoveTempByPSSysEAIDE(pSSysEAIDE, arrayList);
        for (PSSysEAIDEField pSSysEAIDEField : arrayList) {
            this.removeTemp((IEntity)pSSysEAIDEField);
        }
        this.onAfterRemoveTempByPSSysEAIDE(pSSysEAIDE, arrayList);
    }

    protected void onAfterRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE, ArrayList<PSSysEAIDEField> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysEAIDEField pSSysEAIDEField, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysEAIDEField, cloneSession);
        if (pSSysEAIDEField.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysEAIDEField.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysEAIDEField, (PSDEField)iEntity);
        }
        if (pSSysEAIDEField.getPSSysEAIDEId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIDE", (Object)pSSysEAIDEField.getPSSysEAIDEId())) != null) {
            this.onFillParentInfo_PSSysEAIDE(pSSysEAIDEField, (PSSysEAIDE)iEntity);
        }
        if (pSSysEAIDEField.getPSSysEAIElementAttrId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENTATTR", (Object)pSSysEAIDEField.getPSSysEAIElementAttrId())) != null) {
            this.onFillParentInfo_PSSysEAIElementAttr(pSSysEAIDEField, (PSSysEAIElementAttr)iEntity);
        }
        if (pSSysEAIDEField.getPSSysEAIElementREId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENTRE", (Object)pSSysEAIDEField.getPSSysEAIElementREId())) != null) {
            this.onFillParentInfo_PSSysEAIElementRE(pSSysEAIDEField, (PSSysEAIElementRE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysEAIDEField, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysEAIDEField, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDEFTag(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDEFTag2(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapType(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDEFieldId(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDEFieldName(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDEId(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementAttrId(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementREId(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEAIDEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysEAIDEField, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isCodeNameDirty() && !bl2 : !pSSysEAIDEField.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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
                string3 = "PSSYSEAIDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDEFieldDEModel(), "CODENAME", string3, pSSysEAIDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_EAIDEFTag(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isEAIDEFTagDirty() : !pSSysEAIDEField.isEAIDEFTagDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getEAIDEFTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDEFTag_Default((IEntity)pSSysEAIDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDEFTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIDEFTag2(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isEAIDEFTag2Dirty() : !pSSysEAIDEField.isEAIDEFTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getEAIDEFTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDEFTag2_Default((IEntity)pSSysEAIDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDEFTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapType(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isMapTypeDirty() && !bl2 : !pSSysEAIDEField.isMapTypeDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getMapType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapType_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isMemoDirty() : !pSSysEAIDEField.isMemoDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isPSDEFIdDirty() && !bl2 : !pSSysEAIDEField.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSSysEAIDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDEFieldId(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isPSSysEAIDEFieldIdDirty() && !bl2 : !pSSysEAIDEField.isPSSysEAIDEFieldIdDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getPSSysEAIDEFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDEFieldId_Default((IEntity)pSSysEAIDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDEFieldName(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isPSSysEAIDEFieldNameDirty() && !bl2 : !pSSysEAIDEField.isPSSysEAIDEFieldNameDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getPSSysEAIDEFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDEFieldName_Default((IEntity)pSSysEAIDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEFIELDNAME");
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
                string3 = "PSSYSEAIDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDEFieldDEModel(), "PSSYSEAIDEFIELDNAME", string3, pSSysEAIDEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSEAIDEFIELDNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDEId(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isPSSysEAIDEIdDirty() : !pSSysEAIDEField.isPSSysEAIDEIdDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getPSSysEAIDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDEId_Default((IEntity)pSSysEAIDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementAttrId(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isPSSysEAIElementAttrIdDirty() : !pSSysEAIDEField.isPSSysEAIElementAttrIdDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getPSSysEAIElementAttrId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementAttrId_Default((IEntity)pSSysEAIDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTATTRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementREId(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isPSSysEAIElementREIdDirty() : !pSSysEAIDEField.isPSSysEAIElementREIdDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getPSSysEAIElementREId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementREId_Default((IEntity)pSSysEAIDEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTREID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isUserCatDirty() : !pSSysEAIDEField.isUserCatDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isUserTagDirty() : !pSSysEAIDEField.isUserTagDirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isUserTag2Dirty() : !pSSysEAIDEField.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isUserTag3Dirty() : !pSSysEAIDEField.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isUserTag4Dirty() : !pSSysEAIDEField.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysEAIDEField.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEAIDEField pSSysEAIDEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDEField.isValidFlagDirty() && !bl2 : !pSSysEAIDEField.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEAIDEField.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysEAIDEField, bl2, bl3);
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

    protected void onSyncEntity(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysEAIDEField, bl);
    }

    protected void onSyncIndexEntities(PSSysEAIDEField pSSysEAIDEField, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysEAIDEField, bl);
    }

    public Object getDataContextValue(PSSysEAIDEField pSSysEAIDEField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysEAIDEField, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysEAIDE pSSysEAIDE = pSSysEAIDEField.getPSSysEAIDE();
        if (pSSysEAIDE != null && pSSysEAIDE.contains(string)) {
            return pSSysEAIDE.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEAIDEField pSSysEAIDEField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysEAIDEField, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"EAIDEFTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDEFTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIDEFTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDEFTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDEFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDEFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDEFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDEFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTATTRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementAttrId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTATTRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementAttrName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTREID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementREId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTRENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementREName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_EAIDEFTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDEFTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIDEFTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDEFTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_PSSysEAIDEFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDEFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDEFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDEFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementAttrId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTATTRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementAttrName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTATTRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementREId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTREID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementREName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTRENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysEAIDEField pSSysEAIDEField) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysEAIDEField)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEAIDEField pSSysEAIDEField) throws Exception {
        super.onUpdateParent((IEntity)pSSysEAIDEField);
    }

    @Override
    protected void exportCurXmlModel(PSSysEAIDEField pSSysEAIDEField, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSEAIDEFIELD");
        if (!bl) {
            pSSysEAIDEField.setCreateDate(null);
            pSSysEAIDEField.setCreateMan(null);
            pSSysEAIDEField.setPSSysEAIDEFieldId(null);
            pSSysEAIDEField.setUpdateDate(null);
            pSSysEAIDEField.setUpdateMan(null);
            pSSysEAIDEField.setPSDEId(null);
            pSSysEAIDEField.setPSSysEAIDEId(null);
            pSSysEAIDEField.setPSSysEAIDEName(null);
            pSSysEAIDEField.setPSSysEAIElementId(null);
            super.exportCurXmlModel(pSSysEAIDEField, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysEAIDEField pSSysEAIDEField, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysEAIDEField, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSEAIDE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSEAIDEFIELD_PSSYSEAIDE_PSSYSEAIDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDE", (boolean)true) == 0) {
            iEntity.set("PSSYSEAIDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSEAIDEID"};
    }

    @Override
    public String getModelV2Tag(PSSysEAIDEField pSSysEAIDEField) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDEField.getCodeName())) {
            return pSSysEAIDEField.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDEField.getPSSysEAIDEFieldName())) {
            return pSSysEAIDEField.getPSSysEAIDEFieldName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDEField.getCodeName())) {
            return pSSysEAIDEField.getCodeName();
        }
        return super.getModelV2Tag(pSSysEAIDEField);
    }

    @Override
    public boolean setModelV2Tag(PSSysEAIDEField pSSysEAIDEField, String string) {
        pSSysEAIDEField.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSEAIDEFIELDNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSEAIDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysEAIDEField pSSysEAIDEField, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysEAIDEField.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysEAIDEField, true);
        pSSysEAIDEField.set("CODENAME", string);
        if (this.select(pSSysEAIDEField, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysEAIDEField, true);
        return super.getModelV2Entity(pSSysEAIDEField, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysEAIDEField pSSysEAIDEField, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysEAIDEField, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysEAIDEField pSSysEAIDEField, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "EAIDEField");
        defaultValueMap.put("PSSYSEAIDEFIELDNAME", "\u5c5e\u6027\u6620\u5c04");
    }
}

