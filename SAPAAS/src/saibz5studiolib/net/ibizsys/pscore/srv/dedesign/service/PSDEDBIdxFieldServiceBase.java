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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDBIdxFieldDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDBIdxFieldDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIdxField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIndex;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIndexBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDBIdxFieldServiceBase
extends PSCoreSysServiceBase<PSDEDBIdxField> {
    private static final Log log = LogFactory.getLog(PSDEDBIdxFieldServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEDBIdxFieldDEModel pSDEDBIdxFieldDEModel;
    private PSDEDBIdxFieldDAO pSDEDBIdxFieldDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDBIdxFieldService";
    }

    public PSDEDBIdxFieldDEModel getPSDEDBIdxFieldDEModel() {
        if (this.pSDEDBIdxFieldDEModel == null) {
            try {
                this.pSDEDBIdxFieldDEModel = (PSDEDBIdxFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDBIdxFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDBIdxFieldDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDBIdxFieldDEModel();
    }

    public PSDEDBIdxFieldDAO getPSDEDBIdxFieldDAO() {
        if (this.pSDEDBIdxFieldDAO == null) {
            try {
                this.pSDEDBIdxFieldDAO = (PSDEDBIdxFieldDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDBIdxFieldDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDBIdxFieldDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDBIdxFieldDAO();
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

    protected void onFillParentInfo(PSDEDBIdxField pSDEDBIdxField, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDBIndexService", (SessionFactory)this.getSessionFactory());
            PSDEDBIndex pSDEDBIndex = (PSDEDBIndex)iService.getDEModel().createEntity();
            pSDEDBIndex.set("PSDEDBINDEXID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDBIndex);
            } else {
                iService.get(pSDEDBIndex);
            }
            this.onFillParentInfo_PSDEDBIndex(pSDEDBIdxField, pSDEDBIndex);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDBIDXFIELD_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEDBIdxField, pSDEField);
            return;
        }
        super.onFillParentInfo(pSDEDBIdxField, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDBIndexService", (SessionFactory)this.getSessionFactory());
            PSDEDBIndex pSDEDBIndex = (PSDEDBIndex)iService.getDEModel().createEntity();
            pSDEDBIndex.set("PSDEDBINDEXID", string2);
            return this.onSyncDER1NData_PSDEDBIndex(pSDEDBIndex, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEDBIndex(PSDEDBIdxField pSDEDBIdxField, PSDEDBIndex pSDEDBIndex) throws Exception {
        pSDEDBIdxField.setPSDEDBIndexId(pSDEDBIndex.getPSDEDBIndexId());
        pSDEDBIdxField.setPSDEDBIndexName(pSDEDBIndex.getPSDEDBIndexName());
    }

    protected String onSyncDER1NData_PSDEDBIndex(PSDEDBIndex pSDEDBIndex, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEDBIndex(pSDEDBIndex);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEDBIdxField> arrayList = this.selectByPSDEDBIndex(pSDEDBIndex);
            for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEDBIdxField, (String)"PSDEDBIDXFIELDID", (String)""))) continue;
                this.remove(pSDEDBIdxField);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEF(PSDEDBIdxField pSDEDBIdxField, PSDEField pSDEField) throws Exception {
        pSDEDBIdxField.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEDBIdxField.setPSDEFName(pSDEField.getPSDEFieldName());
        pSDEDBIdxField.setPSDEId(pSDEField.getPSDEId());
    }

    protected boolean onFillEntityKeyValue(PSDEDBIdxField pSDEDBIdxField, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEDBIdxField.get("PSDEDBINDEXID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEDBIdxField.get("PSDEFID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEDBIdxField.set(this.getPSDEDBIdxFieldDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEDBIdxField pSDEDBIdxField, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDBIdxField.getIncMode() == null) {
                pSDEDBIdxField.setIncMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEDBIdxField.getSortDir() == null) {
                pSDEDBIdxField.setSortDir((String)this.getDefaultValue(this.getWebContext(), "", "ASC", 25));
            }
        }
        super.onFillEntityFullInfo(pSDEDBIdxField, bl);
        this.onFillEntityFullInfo_PSDEDBIndex(pSDEDBIdxField, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEDBIdxField, bl);
    }

    protected void onFillEntityFullInfo_PSDEDBIndex(PSDEDBIdxField pSDEDBIdxField, boolean bl) throws Exception {
        if (pSDEDBIdxField.isPSDEDBIndexIdDirty()) {
            if (pSDEDBIdxField.getPSDEDBIndexId() != null) {
                if (pSDEDBIdxField.getPSDEDBIndexId() == null || pSDEDBIdxField.getPSDEDBIndexName() == null) {
                    PSDEDBIndex pSDEDBIndex = pSDEDBIdxField.getPSDEDBIndex();
                    pSDEDBIdxField.setPSDEDBIndexName(pSDEDBIndex.getPSDEDBIndexName());
                }
            } else {
                pSDEDBIdxField.setPSDEDBIndexName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEDBIdxField pSDEDBIdxField, boolean bl) throws Exception {
        if (pSDEDBIdxField.isPSDEFIdDirty()) {
            if (pSDEDBIdxField.getPSDEFId() != null) {
                if (pSDEDBIdxField.getPSDEFId() == null || pSDEDBIdxField.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEDBIdxField.getPSDEF();
                    pSDEDBIdxField.setPSDEFName(pSDEField.getPSDEFieldName());
                    pSDEDBIdxField.setPSDEId(pSDEField.getPSDEId());
                }
            } else {
                pSDEDBIdxField.setPSDEFName(null);
                pSDEDBIdxField.setPSDEId(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEDBIdxField pSDEDBIdxField, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEDBIdxField, bl);
    }

    public ArrayList<PSDEDBIdxField> selectByPSDEDBIndex(PSDEDBIndexBase pSDEDBIndexBase) throws Exception {
        return this.selectByPSDEDBIndex(pSDEDBIndexBase, "", -1);
    }

    public ArrayList<PSDEDBIdxField> selectByPSDEDBIndex(PSDEDBIndexBase pSDEDBIndexBase, String string) throws Exception {
        return this.selectByPSDEDBIndex(pSDEDBIndexBase, string, -1);
    }

    public ArrayList<PSDEDBIdxField> selectByPSDEDBIndex(PSDEDBIndexBase pSDEDBIndexBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDBINDEXID", (Object)pSDEDBIndexBase.getPSDEDBIndexId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDBIndexCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDBIndexCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDBIdxField> selectTempByPSDEDBIndex(PSDEDBIndexBase pSDEDBIndexBase) throws Exception {
        return this.selectTempByPSDEDBIndex(pSDEDBIndexBase, "");
    }

    public ArrayList<PSDEDBIdxField> selectTempByPSDEDBIndex(PSDEDBIndexBase pSDEDBIndexBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDBINDEXID", (Object)pSDEDBIndexBase.getPSDEDBIndexId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEDBIndexCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEDBIndexCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDBIdxField> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDBIdxField> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDBIdxField> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
    }

    public void resetPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
        ArrayList<PSDEDBIdxField> arrayList = this.selectByPSDEDBIndex(pSDEDBIndex);
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            PSDEDBIdxField pSDEDBIdxField2 = (PSDEDBIdxField)this.getDEModel().createEntity();
            pSDEDBIdxField2.setPSDEDBIdxFieldId(pSDEDBIdxField.getPSDEDBIdxFieldId());
            pSDEDBIdxField2.setPSDEDBIndexId(null);
            this.update(pSDEDBIdxField2);
        }
    }

    public void resetTempPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
        ArrayList<PSDEDBIdxField> arrayList = this.selectTempByPSDEDBIndex(pSDEDBIndex);
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            PSDEDBIdxField pSDEDBIdxField2 = (PSDEDBIdxField)this.getDEModel().createEntity();
            pSDEDBIdxField2.setPSDEDBIdxFieldId(pSDEDBIdxField.getPSDEDBIdxFieldId());
            pSDEDBIdxField2.setPSDEDBIndexId(null);
            this.updateTemp(pSDEDBIdxField2);
        }
    }

    public void removeByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
        final PSDEDBIndex pSDEDBIndex2 = pSDEDBIndex;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDBIdxFieldServiceBase.this.onBeforeRemoveByPSDEDBIndex(pSDEDBIndex2);
                PSDEDBIdxFieldServiceBase.this.internalRemoveByPSDEDBIndex(pSDEDBIndex2);
                PSDEDBIdxFieldServiceBase.this.onAfterRemoveByPSDEDBIndex(pSDEDBIndex2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
    }

    protected void internalRemoveByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
        ArrayList<PSDEDBIdxField> arrayList = this.selectByPSDEDBIndex(pSDEDBIndex);
        this.onBeforeRemoveByPSDEDBIndex(pSDEDBIndex, arrayList);
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            this.remove(pSDEDBIdxField);
        }
        this.onAfterRemoveByPSDEDBIndex(pSDEDBIndex, arrayList);
    }

    protected void onAfterRemoveByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDBIndex(PSDEDBIndex pSDEDBIndex, ArrayList<PSDEDBIdxField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDBIndex(PSDEDBIndex pSDEDBIndex, ArrayList<PSDEDBIdxField> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDBIdxField> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDBIDXFIELD_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDEDBIDXFIELD", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDBIdxField> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            PSDEDBIdxField pSDEDBIdxField2 = (PSDEDBIdxField)this.getDEModel().createEntity();
            pSDEDBIdxField2.setPSDEDBIdxFieldId(pSDEDBIdxField.getPSDEDBIdxFieldId());
            pSDEDBIdxField2.setPSDEFId(null);
            this.update(pSDEDBIdxField2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDBIdxFieldServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEDBIdxFieldServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEDBIdxFieldServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDBIdxField> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            this.remove(pSDEDBIdxField);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEDBIdxField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEDBIdxField> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDBIdxField pSDEDBIdxField) throws Exception {
        super.onBeforeRemove(pSDEDBIdxField);
    }

    public void removeTempByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
        final PSDEDBIndex pSDEDBIndex2 = pSDEDBIndex;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDBIdxFieldServiceBase.this.onBeforeRemoveTempByPSDEDBIndex(pSDEDBIndex2);
                PSDEDBIdxFieldServiceBase.this.internalRemoveTempByPSDEDBIndex(pSDEDBIndex2);
                PSDEDBIdxFieldServiceBase.this.onAfterRemoveTempByPSDEDBIndex(pSDEDBIndex2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
    }

    protected void internalRemoveTempByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
        ArrayList<PSDEDBIdxField> arrayList = this.selectTempByPSDEDBIndex(pSDEDBIndex);
        this.onBeforeRemoveTempByPSDEDBIndex(pSDEDBIndex, arrayList);
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            this.removeTemp(pSDEDBIdxField);
        }
        this.onAfterRemoveTempByPSDEDBIndex(pSDEDBIndex, arrayList);
    }

    protected void onAfterRemoveTempByPSDEDBIndex(PSDEDBIndex pSDEDBIndex) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEDBIndex(PSDEDBIndex pSDEDBIndex, ArrayList<PSDEDBIdxField> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEDBIndex(PSDEDBIndex pSDEDBIndex, ArrayList<PSDEDBIdxField> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEDBIdxField pSDEDBIdxField, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEDBIdxField, cloneSession);
        if (pSDEDBIdxField.getPSDEDBIndexId() != null && (iEntity = cloneSession.getEntity("PSDEDBINDEX", (Object)pSDEDBIdxField.getPSDEDBIndexId())) != null) {
            this.onFillParentInfo_PSDEDBIndex(pSDEDBIdxField, (PSDEDBIndex)iEntity);
        }
        if (pSDEDBIdxField.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDBIdxField.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEDBIdxField, (PSDEField)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDBIdxField pSDEDBIdxField, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEDBIdxField, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IncMode(bl, pSDEDBIdxField, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IndexLength(bl, pSDEDBIdxField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDBIdxFieldId(bl, pSDEDBIdxField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDBIdxFieldName(bl, pSDEDBIdxField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDBIndexId(bl, pSDEDBIdxField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDBIndexName(bl, pSDEDBIdxField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEDBIdxField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEDBIdxField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SortDir(bl, pSDEDBIdxField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEDBIdxField, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IncMode(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isIncModeDirty() && !bl2 : !pSDEDBIdxField.isIncModeDirty()) {
            return null;
        }
        Integer n = pSDEDBIdxField.getIncMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_IncMode_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IndexLength(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isIndexLengthDirty() : !pSDEDBIdxField.isIndexLengthDirty()) {
            return null;
        }
        Integer n = pSDEDBIdxField.getIndexLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IndexLength_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INDEXLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDBIdxFieldId(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isPSDEDBIdxFieldIdDirty() && !bl2 : !pSDEDBIdxField.isPSDEDBIdxFieldIdDirty()) {
            return null;
        }
        String string = pSDEDBIdxField.getPSDEDBIdxFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBIDXFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDBIdxFieldId_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBIDXFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDBIdxFieldName(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isPSDEDBIdxFieldNameDirty() && !bl2 : !pSDEDBIdxField.isPSDEDBIdxFieldNameDirty()) {
            return null;
        }
        String string = pSDEDBIdxField.getPSDEDBIdxFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBIDXFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDBIdxFieldName_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBIDXFIELDNAME");
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
                string3 = "PSDEDBINDEXID";
                String string4 = this.checkFieldDupRule(this.getPSDEDBIdxFieldDEModel(), "PSDEDBIDXFIELDNAME", string3, pSDEDBIdxField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDBIDXFIELDNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDBIndexId(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isPSDEDBIndexIdDirty() && !bl2 : !pSDEDBIdxField.isPSDEDBIndexIdDirty()) {
            return null;
        }
        String string = pSDEDBIdxField.getPSDEDBIndexId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBINDEXID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDBIndexId_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBINDEXID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDBIndexName(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isPSDEDBIndexNameDirty() : !pSDEDBIdxField.isPSDEDBIndexNameDirty()) {
            return null;
        }
        String string = pSDEDBIdxField.getPSDEDBIndexName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDBIndexName_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBINDEXNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isPSDEFIdDirty() && !bl2 : !pSDEDBIdxField.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDBIdxField.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEDBINDEXID";
                String string4 = this.checkFieldDupRule(this.getPSDEDBIdxFieldDEModel(), "PSDEFID", string3, pSDEDBIdxField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isPSDEFNameDirty() && !bl2 : !pSDEDBIdxField.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDBIdxField.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
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
                string3 = "PSDEDBINDEXID";
                String string4 = this.checkFieldDupRule(this.getPSDEDBIdxFieldDEModel(), "PSDEFNAME", string3, pSDEDBIdxField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SortDir(boolean bl, PSDEDBIdxField pSDEDBIdxField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIdxField.isSortDirDirty() : !pSDEDBIdxField.isSortDirDirty()) {
            return null;
        }
        String string = pSDEDBIdxField.getSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SortDir_Default(pSDEDBIdxField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDBIdxField pSDEDBIdxField, boolean bl) throws Exception {
        super.onSyncEntity(pSDEDBIdxField, bl);
    }

    protected void onSyncIndexEntities(PSDEDBIdxField pSDEDBIdxField, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEDBIdxField, bl);
    }

    public Object getDataContextValue(PSDEDBIdxField pSDEDBIdxField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEDBIdxField, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEDBIndex pSDEDBIndex = pSDEDBIdxField.getPSDEDBIndex();
        if (pSDEDBIndex != null && pSDEDBIndex.contains(string)) {
            return pSDEDBIndex.get(string);
        }
        PSDEField pSDEField = pSDEDBIdxField.getPSDEF();
        if (pSDEField != null && pSDEField.contains(string)) {
            return pSDEField.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDBIdxField pSDEDBIdxField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEDBIdxField, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INDEXLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IndexLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDBIDXFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDBIdxFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDBIDXFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDBIdxFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDBINDEXID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDBIndexId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDBINDEXNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDBIndexName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SortDir_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_IncMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IndexLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDBIdxFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDBIDXFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDBIdxFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDBIDXFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDBIndexId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDBINDEXID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDBIndexName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDBINDEXNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_SortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected boolean onMergeChild(String string, String string2, PSDEDBIdxField pSDEDBIdxField) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEDBIdxField)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDBIdxField pSDEDBIdxField) throws Exception {
        super.onUpdateParent(pSDEDBIdxField);
    }

    @Override
    protected void exportCurXmlModel(PSDEDBIdxField pSDEDBIdxField, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDBIDXFIELD");
        if (!bl) {
            pSDEDBIdxField.setCreateDate(null);
            pSDEDBIdxField.setCreateMan(null);
            pSDEDBIdxField.setPSDEDBIdxFieldId(null);
            pSDEDBIdxField.setUpdateDate(null);
            pSDEDBIdxField.setUpdateMan(null);
            pSDEDBIdxField.setPSDEDBIndexId(null);
            pSDEDBIdxField.setPSDEDBIndexName(null);
            super.exportCurXmlModel(pSDEDBIdxField, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEDBIdxField pSDEDBIdxField, PSSystem pSSystem) throws Exception {
        PSDEDBIdxField pSDEDBIdxField2 = new PSDEDBIdxField();
        pSDEDBIdxField2.setPSDEDBIndexId(pSDEDBIdxField.getPSDEDBIndexId());
        pSDEDBIdxField2.setPSDEFId(pSDEDBIdxField.getPSDEFId());
        if (this.selectOne(pSDEDBIdxField2, true)) {
            return pSDEDBIdxField2.getPSDEDBIdxFieldId();
        }
        return super.getEntityFolderKeyValue(pSDEDBIdxField, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDBIdxField pSDEDBIdxField, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDBIdxField, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDBINDEXID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDBINDEX#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDBINDEXID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDBINDEXID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDBINDEXNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEDBINDEX", (boolean)true) == 0) {
            iEntity.set("PSDEDBINDEXID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEDBINDEXID"};
    }

    @Override
    public String getModelV2Tag(PSDEDBIdxField pSDEDBIdxField) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDBIdxField.getPSDEDBIdxFieldName())) {
            return pSDEDBIdxField.getPSDEDBIdxFieldName();
        }
        return super.getModelV2Tag(pSDEDBIdxField);
    }

    @Override
    public boolean setModelV2Tag(PSDEDBIdxField pSDEDBIdxField, String string) {
        pSDEDBIdxField.setPSDEDBIdxFieldName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEDBIDXFIELDNAME", "");
        map.put("PSDEDBINDEXID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDBIdxField pSDEDBIdxField, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDBIdxField.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDBIdxField, true);
        pSDEDBIdxField.set("PSDEDBIDXFIELDNAME", string);
        if (this.select(pSDEDBIdxField, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDBIdxField, true);
        return super.getModelV2Entity(pSDEDBIdxField, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDBIdxField pSDEDBIdxField, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEDBIdxField, objectNode, string, string2, n);
    }
}

