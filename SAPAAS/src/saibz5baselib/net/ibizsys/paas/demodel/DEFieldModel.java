/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;
import net.ibizsys.paas.demodel.DEFDBValueFuncModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFDTColumnModel;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;

public class DEFieldModel
extends ModelBase3Impl
implements IDEFieldModel,
IDEFDTColumn {
    protected ArrayList<IDEFSearchMode> defSearchModes = new ArrayList();
    protected IDataEntity iDataEntity = null;
    private String strDataType = null;
    private int nStdDataType = 0;
    private boolean bInheritDEField = false;
    private String strPreDefinedType = null;
    private boolean bKeyDEField = false;
    private boolean bUniTagDEField = false;
    private boolean bMajorDEField = false;
    private boolean bLinkDEField = false;
    private boolean bPhisicalDEField = true;
    private String strLogicName = null;
    private int nImportOrder = 100;
    private String strImportTag = "";
    private String strMemo = "";
    private String strDERName = "";
    private IDEFieldModel linkDEField = null;
    private IDEFieldModel realDEField = null;
    private String strLinkDEFName = "";
    private String strCodeListId = null;
    private String strValueFormat = "%1$s";
    private boolean bEnableAudit = false;
    private String strAuditInfoFormat = "[%1$s]\u4ece[%2$s]\u53d8\u66f4\u4e3a[%3$s]";
    private boolean bMultiFormDEField = false;
    private boolean bIndexTypeDEField = false;
    private boolean bEnableTempData = true;
    private String strUnionKeyValue = null;
    private boolean bEnableDBAutoValue = false;
    private String strDBValueInsertMode = null;
    private String strDBValueUpdateMode = null;
    private HashMap<String, IDEFDBValueFunc> dbValueFuncMap = null;
    private HashMap<String, IDEFDTColumn> defDTColumnMap = null;
    private int nDEFType = 0;
    private boolean bDynaStorageDEField = false;
    private boolean bFormulaDEField = false;

    public void init() throws Exception {
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public void registerDEFSearchMode(IDEFSearchMode iDEFSearchMode) {
        this.defSearchModes.add(iDEFSearchMode);
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getDataType() {
        return this.strDataType;
    }

    @Override
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    public boolean isEnableQuickSearch() {
        return false;
    }

    @Override
    public Iterator<IDEFSearchMode> getDEFSearchModes() {
        return this.defSearchModes.iterator();
    }

    public void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public String getLogicName() {
        return this.strLogicName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    @Override
    public String getLogicName(String strLanguange) {
        return this.getLogicName();
    }

    @Override
    public boolean isKeyDEField() {
        return this.bKeyDEField;
    }

    @Override
    public boolean isMajorDEField() {
        return this.bMajorDEField;
    }

    @Override
    public boolean isLinkDEField() {
        return this.bLinkDEField;
    }

    @Override
    public boolean isEnablePrivilege() {
        return false;
    }

    @Override
    public String getCodeListId() {
        return this.strCodeListId;
    }

    public void setCodeListId(String strCodeListId) {
        this.strCodeListId = strCodeListId;
    }

    @Override
    public IDEFValueRule getDEFValueRule(String strDVRId) throws Exception {
        return null;
    }

    @Override
    public String getPreDefinedType() {
        return this.strPreDefinedType;
    }

    @Override
    public boolean isFormulaDEField() {
        return this.bFormulaDEField;
    }

    @Override
    public boolean isPhisicalDEField() {
        return this.bPhisicalDEField;
    }

    @Override
    public boolean isInheritDEField() {
        return this.bInheritDEField;
    }

    public void setDataType(String strDataType) {
        this.strDataType = strDataType;
    }

    public void setStdDataType(int nStdDataType) {
        this.nStdDataType = nStdDataType;
    }

    public void setKeyDEField(boolean bKeyDEField) {
        this.bKeyDEField = bKeyDEField;
    }

    public void setUniTagDEField(boolean bUniTagDEField) {
        this.bUniTagDEField = bUniTagDEField;
    }

    public void setMajorDEField(boolean bMajorDEField) {
        this.bMajorDEField = bMajorDEField;
    }

    public void setLinkDEField(boolean bLinkDEField) {
        this.bLinkDEField = bLinkDEField;
    }

    public void setPreDefinedType(String strPreDefinedType) {
        this.strPreDefinedType = strPreDefinedType;
    }

    public void setPreDefineType(String strPreDefinedType) {
        this.strPreDefinedType = strPreDefinedType;
    }

    public void setFormulaDEField(boolean bFormulaDEField) {
        this.bFormulaDEField = bFormulaDEField;
    }

    public void setPhisicalDEField(boolean bPhisicalDEField) {
        this.bPhisicalDEField = bPhisicalDEField;
    }

    public void setInheritDEField(boolean bInheritDEField) {
        this.bInheritDEField = bInheritDEField;
    }

    @Override
    public String getDBValueFunc() {
        return this.getDBValueUpdateMode();
    }

    public void setDBValueFunc(String strDBValueFunc) {
        this.strDBValueUpdateMode = strDBValueFunc;
    }

    @Override
    public int getImportOrder() {
        return this.nImportOrder;
    }

    public void setImportOrder(int nImportOrder) {
        this.nImportOrder = nImportOrder;
    }

    @Override
    public String getImportTag() {
        if (StringHelper.isNullOrEmpty(this.strImportTag)) {
            return this.getName();
        }
        return this.strImportTag;
    }

    public void setImportTag(String strImportTag) {
        this.strImportTag = strImportTag;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    public void setMemo(String strMemo) {
        this.strMemo = strMemo;
    }

    @Override
    public String getDERName() {
        return this.strDERName;
    }

    public void setDERName(String strDERName) {
        this.strDERName = strDERName;
    }

    @Override
    public String getLinkDEFName() {
        return this.strLinkDEFName;
    }

    public void setLinkDEFName(String strLinkDEFName) {
        this.strLinkDEFName = strLinkDEFName;
    }

    @Override
    public IDEFieldModel getLinkDEField() throws Exception {
        if (!this.isLinkDEField()) {
            return null;
        }
        if (this.linkDEField != null) {
            return this.linkDEField;
        }
        if (StringHelper.isNullOrEmpty(this.getLinkDEFName())) {
            return null;
        }
        if (StringHelper.isNullOrEmpty(this.getDERName())) {
            return null;
        }
        String strMajorDEId = this.getDataEntity().getSystem().getDER(this.getDERName()).getMajorDEId();
        this.linkDEField = (IDEFieldModel)DEModelGlobal.getDEModel(strMajorDEId).getDEField(this.getLinkDEFName(), false);
        return this.linkDEField;
    }

    @Override
    public IDEFieldModel getRealDEField() throws Exception {
        if (!this.isLinkDEField()) {
            return this;
        }
        if (this.realDEField != null) {
            return this.realDEField;
        }
        IDEFieldModel linkDEField = this.getLinkDEField();
        this.realDEField = linkDEField.getRealDEField();
        return this.realDEField;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return (IDataEntityModel)this.getDataEntity();
    }

    @Override
    public String getValueFormat() {
        return this.strValueFormat;
    }

    public void setValueFormat(String strValueFormat) {
        this.strValueFormat = strValueFormat;
    }

    @Override
    public boolean isEnableAudit() {
        return this.bEnableAudit;
    }

    public void setEnableAudit(boolean bEnableAudit) {
        this.bEnableAudit = bEnableAudit;
    }

    @Override
    public String getAuditInfoFormat() {
        return this.strAuditInfoFormat;
    }

    public void setAuditInfoFormat(String strAuditInfoFormat) {
        this.strAuditInfoFormat = strAuditInfoFormat;
    }

    @Override
    public boolean isMultiFormDEField() {
        return this.bMultiFormDEField;
    }

    public void setMultiFormDEField(boolean bMultiFormDEField) {
        this.bMultiFormDEField = bMultiFormDEField;
    }

    @Override
    public boolean isIndexTypeDEField() {
        return this.bIndexTypeDEField;
    }

    public void setIndexTypeDEField(boolean bIndexTypeDEField) {
        this.bIndexTypeDEField = bIndexTypeDEField;
    }

    @Override
    public boolean isEnableTempData() {
        return this.bEnableTempData;
    }

    public void setEnableTempData(boolean bEnableTempData) {
        this.bEnableTempData = bEnableTempData;
    }

    @Override
    public String getUnionKeyValue() {
        return this.strUnionKeyValue;
    }

    public void setUnionKeyValue(String strUnionKeyValue) {
        this.strUnionKeyValue = strUnionKeyValue;
    }

    @Override
    public boolean isEnableDBAutoValue() {
        return this.bEnableDBAutoValue;
    }

    public void setEnableDBAutoValue(boolean bEnableDBAutoValue) {
        this.bEnableDBAutoValue = bEnableDBAutoValue;
    }

    @Override
    public boolean isUniTagField() {
        return this.bUniTagDEField;
    }

    public void setUniTagField(boolean bUniTagDEField) {
        this.bUniTagDEField = bUniTagDEField;
    }

    @Override
    public String getDBValueInsertMode() {
        return this.strDBValueInsertMode;
    }

    @Override
    public String getDBValueUpdateMode() {
        return this.strDBValueUpdateMode;
    }

    public void setDBValueInsertMode(String strDBValueInsertMode) {
        this.strDBValueInsertMode = strDBValueInsertMode;
    }

    public void setDBValueUpdateMode(String strDBValueUpdateMode) {
        this.strDBValueUpdateMode = strDBValueUpdateMode;
    }

    @Override
    public boolean isEnableDBValueInsertUpdateMode() {
        return this.getDEModel().getSystemModel().getSystemSetting().isEnableDBValueInsertUpdateMode();
    }

    @Override
    public IDEFDBValueFunc getDEFDBValueFunc(String strDBType, boolean bInsert) throws Exception {
        if (this.dbValueFuncMap == null) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u83b7\u53d6\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u503c\u51fd\u6570\u5b9a\u4e49", strDBType));
        }
        String strTag = StringHelper.format("%1$s.%2$s", strDBType, bInsert ? "INSERT" : "UPDATE").toUpperCase();
        IDEFDBValueFunc iDEFDBValueFunc = this.dbValueFuncMap.get(strTag);
        if (iDEFDBValueFunc == null) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u83b7\u53d6\u6570\u636e\u5e93\u7c7b\u578b[%1$s][%2$s]\u503c\u51fd\u6570\u5b9a\u4e49", strDBType, bInsert ? "INSERT" : "UPDATE"));
        }
        return iDEFDBValueFunc;
    }

    public void registerDBValueFuncCode(String strDBType, boolean bInsert, String strValueFuncFormat, String strValueFuncFields) {
        if (this.dbValueFuncMap == null) {
            this.dbValueFuncMap = new HashMap();
        }
        String strTag = StringHelper.format("%1$s.%2$s", strDBType, bInsert ? "INSERT" : "UPDATE").toUpperCase();
        DEFDBValueFuncModel dbValueFuncModel = new DEFDBValueFuncModel();
        dbValueFuncModel.setCodeFormat(strValueFuncFormat);
        if (!StringHelper.isNullOrEmpty(strValueFuncFields)) {
            dbValueFuncModel.setFields(StringHelper.splitEx(strValueFuncFields));
        }
        this.dbValueFuncMap.put(strTag, dbValueFuncModel);
    }

    @Override
    public String getColumnName() {
        return this.getName();
    }

    @Override
    public IDEFDTColumn getDEFDTColumn(String strDBType) throws Exception {
        if (this.defDTColumnMap == null) {
            return this;
        }
        IDEFDTColumn iDEFDTColumn = this.defDTColumnMap.get(strDBType);
        if (iDEFDTColumn != null) {
            return iDEFDTColumn;
        }
        return this;
    }

    @Override
    public void registerDEFDTColumn(IDEFDTColumn iDEFDTColumn) {
        IDEFDTColumnModel iDEFDTColumnModel = (IDEFDTColumnModel)iDEFDTColumn;
        if (this.defDTColumnMap == null) {
            this.defDTColumnMap = new HashMap();
        }
        this.defDTColumnMap.put(iDEFDTColumnModel.getDBType(), iDEFDTColumn);
    }

    @Override
    public int getDEFType() {
        return this.nDEFType;
    }

    public void setDEFType(int nDEFType) {
        this.nDEFType = nDEFType;
    }

    @Override
    public boolean isDynaStorageDEField() {
        return this.bDynaStorageDEField;
    }

    public void setDynaStorageDEField(boolean bDynaStorageDEField) {
        this.bDynaStorageDEField = bDynaStorageDEField;
    }
}

