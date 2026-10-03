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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFDTColDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFDTColDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDTCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFDTColServiceBase
extends PSCoreSysServiceBase<PSDEFDTCol> {
    private static final Log log = LogFactory.getLog(PSDEFDTColServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFDTColDEModel pSDEFDTColDEModel;
    private PSDEFDTColDAO pSDEFDTColDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService";
    }

    public PSDEFDTColDEModel getPSDEFDTColDEModel() {
        if (this.pSDEFDTColDEModel == null) {
            try {
                this.pSDEFDTColDEModel = (PSDEFDTColDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFDTColDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDTColDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFDTColDEModel();
    }

    public PSDEFDTColDAO getPSDEFDTColDAO() {
        if (this.pSDEFDTColDAO == null) {
            try {
                this.pSDEFDTColDAO = (PSDEFDTColDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFDTColDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDTColDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFDTColDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEFDTCol pSDEFDTCol, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEFDTCol, pSDEField);
            return;
        }
        super.onFillParentInfo(pSDEFDTCol, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEF(PSDEFDTCol pSDEFDTCol, PSDEField pSDEField) throws Exception {
        pSDEFDTCol.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFDTCol.setPSDEFName(pSDEField.getPSDEFieldName());
        pSDEFDTCol.setPSDEId(pSDEField.getPSDEId());
        pSDEFDTCol.setPSDEName(pSDEField.getPSDEName());
        pSDEFDTCol.setTableName(pSDEField.getTableName());
    }

    protected boolean onFillEntityKeyValue(PSDEFDTCol pSDEFDTCol, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEFDTCol.get("PSDEFID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEFDTCol.get("DBTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEFDTCol.set(this.getPSDEFDTColDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEFDTCol pSDEFDTCol, boolean bl) throws Exception {
        if (bl && pSDEFDTCol.getCustomDataType() == null) {
            pSDEFDTCol.setCustomDataType((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDEFDTCol, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEFDTCol, bl);
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEFDTCol pSDEFDTCol, boolean bl) throws Exception {
        if (pSDEFDTCol.isPSDEFIdDirty()) {
            if (pSDEFDTCol.getPSDEFId() != null) {
                if (pSDEFDTCol.getPSDEFId() == null || pSDEFDTCol.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFDTCol.getPSDEF();
                    pSDEFDTCol.setPSDEFName(pSDEField.getPSDEFieldName());
                    pSDEFDTCol.setPSDEId(pSDEField.getPSDEId());
                    pSDEFDTCol.setPSDEName(pSDEField.getPSDEName());
                    pSDEFDTCol.setTableName(pSDEField.getTableName());
                }
            } else {
                pSDEFDTCol.setPSDEFName(null);
                pSDEFDTCol.setPSDEId(null);
                pSDEFDTCol.setPSDEName(null);
                pSDEFDTCol.setTableName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEFDTCol pSDEFDTCol, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFDTCol, bl);
    }

    public ArrayList<PSDEFDTCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFDTCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFDTCol> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFDTCol> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEFDTCol pSDEFDTCol : arrayList) {
            PSDEFDTCol pSDEFDTCol2 = (PSDEFDTCol)this.getDEModel().createEntity();
            pSDEFDTCol2.setPSDEFDTColId(pSDEFDTCol.getPSDEFDTColId());
            pSDEFDTCol2.setPSDEFId(null);
            this.update(pSDEFDTCol2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDTColServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEFDTColServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEFDTColServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFDTCol> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEFDTCol pSDEFDTCol : arrayList) {
            this.remove(pSDEFDTCol);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFDTCol> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFDTCol> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFDTCol pSDEFDTCol) throws Exception {
        super.onBeforeRemove(pSDEFDTCol);
    }

    protected void replaceParentInfo(PSDEFDTCol pSDEFDTCol, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFDTCol, cloneSession);
        if (pSDEFDTCol.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFDTCol.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEFDTCol, (PSDEField)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFDTCol pSDEFDTCol, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFDTCol, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CustomDataType(bl, pSDEFDTCol, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataType(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBType(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormulaFields(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormulaFormat(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Length(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NullValOrder(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFDTColId(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFDTColName(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFunc2Fields(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFunc2Format(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFuncFields(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFuncFormat(bl, pSDEFDTCol, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFDTCol, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CustomDataType(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isCustomDataTypeDirty() : !pSDEFDTCol.isCustomDataTypeDirty()) {
            return null;
        }
        Integer n = pSDEFDTCol.getCustomDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomDataType_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataType(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isDataTypeDirty() : !pSDEFDTCol.isDataTypeDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataType_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBType(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isDBTypeDirty() && !bl2 : !pSDEFDTCol.isDBTypeDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getDBType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBType_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isDefaultValueDirty() : !pSDEFDTCol.isDefaultValueDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_FormulaFields(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isFormulaFieldsDirty() : !pSDEFDTCol.isFormulaFieldsDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getFormulaFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormulaFields_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormulaFormat(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isFormulaFormatDirty() : !pSDEFDTCol.isFormulaFormatDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getFormulaFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormulaFormat_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_Length(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isLengthDirty() : !pSDEFDTCol.isLengthDirty()) {
            return null;
        }
        Integer n = pSDEFDTCol.getLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Length_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isMemoDirty() : !pSDEFDTCol.isMemoDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_NullValOrder(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isNullValOrderDirty() : !pSDEFDTCol.isNullValOrderDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getNullValOrder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NullValOrder_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NULLVALORDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isPrecision2Dirty() : !pSDEFDTCol.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSDEFDTCol.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFDTColId(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isPSDEFDTColIdDirty() && !bl2 : !pSDEFDTCol.isPSDEFDTColIdDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getPSDEFDTColId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDTCOLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFDTColId_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDTCOLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFDTColName(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isPSDEFDTColNameDirty() && !bl2 : !pSDEFDTCol.isPSDEFDTColNameDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getPSDEFDTColName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDTCOLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFDTColName_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDTCOLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isPSDEFIdDirty() && !bl2 : !pSDEFDTCol.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isPSDEFNameDirty() && !bl2 : !pSDEFDTCol.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isUserCatDirty() : !pSDEFDTCol.isUserCatDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isUserParamsDirty() : !pSDEFDTCol.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isUserTagDirty() : !pSDEFDTCol.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isUserTag2Dirty() : !pSDEFDTCol.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFDTCol.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isUserTag3Dirty() : !pSDEFDTCol.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEFDTCol.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isUserTag4Dirty() : !pSDEFDTCol.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEFDTCol.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEFDTCol, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueFunc2Fields(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isValueFunc2FieldsDirty() : !pSDEFDTCol.isValueFunc2FieldsDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getValueFunc2Fields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFunc2Fields_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFUNC2FIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueFunc2Format(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isValueFunc2FormatDirty() : !pSDEFDTCol.isValueFunc2FormatDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getValueFunc2Format();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFunc2Format_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFUNC2FORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueFuncFields(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isValueFuncFieldsDirty() : !pSDEFDTCol.isValueFuncFieldsDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getValueFuncFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFuncFields_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFUNCFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueFuncFormat(boolean bl, PSDEFDTCol pSDEFDTCol, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDTCol.isValueFuncFormatDirty() : !pSDEFDTCol.isValueFuncFormatDirty()) {
            return null;
        }
        String string = pSDEFDTCol.getValueFuncFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFuncFormat_Default(pSDEFDTCol, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFUNCFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFDTCol pSDEFDTCol, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFDTCol, bl);
    }

    protected void onSyncIndexEntities(PSDEFDTCol pSDEFDTCol, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFDTCol, bl);
    }

    public Object getDataContextValue(PSDEFDTCol pSDEFDTCol, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFDTCol, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEField pSDEField = pSDEFDTCol.getPSDEF();
        if (pSDEField != null && pSDEField.contains(string)) {
            return pSDEField.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFDTCol pSDEFDTCol, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFDTCol, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMULAFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormulaFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMULAFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormulaFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Length_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NULLVALORDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NullValOrder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFDTCOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFDTColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFDTCOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFDTColName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TableName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEFUNC2FIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFunc2Fields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEFUNC2FORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFunc2Format_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEFUNCFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFuncFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEFUNCFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFuncFormat_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CustomDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormulaFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMULAFIELDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_Length_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_NullValOrder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NULLVALORDER", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFDTColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFDTCOLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFDTColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFDTCOLNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("PSDEFDTCOLNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABLENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_ValueFunc2Fields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFUNC2FIELDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueFunc2Format_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFUNC2FORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueFuncFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFUNCFIELDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueFuncFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFUNCFORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDEFDTCol pSDEFDTCol) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFDTCol)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFDTCol pSDEFDTCol) throws Exception {
        Object object = pSDEFDTCol.get("PSDEFID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID", object);
        }
        super.onUpdateParent(pSDEFDTCol);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEFDTCol pSDEFDTCol, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFDTCOL");
        if (!bl) {
            pSDEFDTCol.setCreateDate(null);
            pSDEFDTCol.setCreateMan(null);
            pSDEFDTCol.setPSDEFDTColId(null);
            pSDEFDTCol.setPSDEId(null);
            pSDEFDTCol.setPSDEName(null);
            pSDEFDTCol.setTableName(null);
            pSDEFDTCol.setUpdateDate(null);
            pSDEFDTCol.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFDTCol, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEFDTCol pSDEFDTCol, PSSystem pSSystem) throws Exception {
        PSDEFDTCol pSDEFDTCol2 = new PSDEFDTCol();
        pSDEFDTCol2.setPSDEFId(pSDEFDTCol.getPSDEFId());
        pSDEFDTCol2.setDBType(pSDEFDTCol.getDBType());
        if (this.selectOne(pSDEFDTCol2, true)) {
            return pSDEFDTCol2.getPSDEFDTColId();
        }
        return super.getEntityFolderKeyValue(pSDEFDTCol, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFDTCol pSDEFDTCol, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFDTCol, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFIELD#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFIELD", (boolean)true) == 0) {
            iEntity.set("PSDEFID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEFID"};
    }

    @Override
    public String getModelV2Tag(PSDEFDTCol pSDEFDTCol) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFDTCol.getDBType())) {
            return pSDEFDTCol.getDBType();
        }
        return super.getModelV2Tag(pSDEFDTCol);
    }

    @Override
    public boolean setModelV2Tag(PSDEFDTCol pSDEFDTCol, String string) {
        pSDEFDTCol.setDBType(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("DBTYPE", "");
        map.put("PSDEFID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFDTCol pSDEFDTCol, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFDTCol.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFDTCol, true);
        pSDEFDTCol.set("DBTYPE", string);
        if (this.select(pSDEFDTCol, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFDTCol, true);
        return super.getModelV2Entity(pSDEFDTCol, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFDTCol pSDEFDTCol, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEFDTCol, objectNode, string, string2, n);
    }
}

