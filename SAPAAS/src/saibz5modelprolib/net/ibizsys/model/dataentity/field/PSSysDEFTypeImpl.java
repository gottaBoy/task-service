/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.control.form.IPSDEFFormItem
 *  net.ibizsys.model.control.form.IPSDEFSearchFormItem
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import java.util.HashMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.form.IPSDEFSearchFormItem;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.field.IPSSysDEFTypeRuntime;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDEFieldType;
import net.ibizsys.model.entity.PSSysDEFType;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDEFTypeImpl
extends PSSystemObjectImpl
implements IPSSysDEFTypeRuntime {
    private static final Log log = LogFactory.getLog(PSSysDEFTypeImpl.class);
    protected PSSysDEFType psSysDEFType = null;
    private IPSDEFieldType iPSDEFieldType = null;
    protected HashMap<String, String> dataTypeMap = null;
    protected HashMap<String, String> fieldMap = null;
    protected String strValueFormat = null;
    protected Integer nStdDataType = null;
    protected Integer nStringLength = null;
    protected Integer nLength = null;
    protected Integer nPrecision = null;
    private Integer nEditorWidth = null;
    private Integer nMBEditorWidth = null;
    private Integer nEditorHeight = null;
    private Integer nMBEditorHeight = null;
    private String strPSCodeListId = null;
    private String strPSSysValueRuleId = null;
    private String strPSSysUnitId = null;
    private Integer nSearchEditorWidth = null;
    private Integer nSearchMBEditorWidth = null;
    private Integer nSearchEditorHeight = null;
    private Integer nSearchMBEditorHeight = null;
    private String strSearchEditorType = null;
    private String strSearchMBEditorType = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysDEFType psSysDEFType) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSysDEFType = psSysDEFType;
            this.setId(this.psSysDEFType.getPSSYSDEFTYPEID());
            this.setName(this.psSysDEFType.getPSSYSDEFTYPENAME());
            this.setPSObjectData(this.psSysDEFType);
            if (!StringHelper.isNullOrEmpty((String)this.psSysDEFType.getPSDEFTYPEID())) {
                this.iPSDEFieldType = this.getPSModelStorageContext().getPSDEFieldType(this.psSysDEFType.getPSDEFTYPEID());
            }
            if (this.iPSDEFieldType == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e73\u53f0\u9884\u7f6e\u5c5e\u6027\u7c7b\u578b");
            }
            String strFields = this.psSysDEFType.getFIELDS();
            if (!StringHelper.isNullOrEmpty((String)strFields)) {
                String[] datatypes;
                strFields = strFields.toUpperCase();
                this.fieldMap = new HashMap();
                strFields = strFields.replace(',', ';');
                String[] stringArray = datatypes = strFields.split("[;]");
                int n = datatypes.length;
                int n2 = 0;
                while (n2 < n) {
                    String strField = stringArray[n2];
                    this.fieldMap.put(strField.trim(), "");
                    ++n2;
                }
            }
            if (!psSysDEFType.isSTDDATATYPENull()) {
                this.nStdDataType = psSysDEFType.getSTDDATATYPE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDEFType.getVALUEFORMAT())) {
                this.strValueFormat = this.psSysDEFType.getVALUEFORMAT();
            }
            if (!this.psSysDEFType.isSTRLENGTHNull()) {
                this.nStringLength = this.psSysDEFType.getSTRLENGTH();
                this.nLength = this.psSysDEFType.getSTRLENGTH();
            }
            if (!this.psSysDEFType.isPRECISION2Null()) {
                this.nPrecision = this.psSysDEFType.getPRECISION2();
            }
            if (!this.psSysDEFType.isPRECISION2Null()) {
                this.nPrecision = this.psSysDEFType.getPRECISION2();
            }
            if (!this.psSysDEFType.isEDITORWIDTHNull()) {
                this.nEditorWidth = this.psSysDEFType.getEDITORWIDTH();
            }
            if (!this.psSysDEFType.isEDITORHEIGHTNull()) {
                this.nEditorHeight = this.psSysDEFType.getEDITORHEIGHT();
            }
            if (!this.psSysDEFType.isMBEDITORWIDTHNull()) {
                this.nMBEditorWidth = this.psSysDEFType.getMBEDITORWIDTH();
            }
            if (!this.psSysDEFType.isMBEDITORHEIGHTNull()) {
                this.nMBEditorHeight = this.psSysDEFType.getMBEDITORHEIGHT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDEFType.getPSCODELISTID())) {
                this.strPSCodeListId = this.psSysDEFType.getPSCODELISTID();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDEFType.getPSSYSVALUERULEID())) {
                this.strPSSysValueRuleId = this.psSysDEFType.getPSSYSVALUERULEID();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDEFType.getPSSYSUNITID())) {
                this.strPSSysUnitId = this.psSysDEFType.getPSSYSUNITID();
            }
            this.strSearchEditorType = this.psSysDEFType.getSEARCHEDITORTYPE();
            if (StringHelper.isNullOrEmpty((String)this.strSearchEditorType)) {
                this.strSearchEditorType = this.psSysDEFType.getEDITORTYPE();
                this.nSearchEditorWidth = this.nEditorWidth;
                this.nSearchEditorHeight = this.nEditorHeight;
            } else {
                if (!this.psSysDEFType.isSEARCHEDITORWIDTHNull()) {
                    this.nSearchEditorWidth = this.psSysDEFType.getSEARCHEDITORWIDTH();
                }
                if (!this.psSysDEFType.isSEARCHEDITORHEIGHTNull()) {
                    this.nSearchEditorHeight = this.psSysDEFType.getSEARCHEDITORHEIGHT();
                }
            }
            this.strSearchMBEditorType = this.psSysDEFType.getSEARCHMBEDITORTYPE();
            if (StringHelper.isNullOrEmpty((String)this.strSearchMBEditorType)) {
                this.strSearchMBEditorType = this.psSysDEFType.getMBEDITORTYPE();
                if (StringHelper.isNullOrEmpty((String)this.strSearchMBEditorType)) {
                    this.strSearchMBEditorType = this.psSysDEFType.getEDITORTYPE();
                }
                this.nSearchMBEditorWidth = this.nMBEditorWidth;
                this.nSearchMBEditorHeight = this.nMBEditorHeight;
            } else {
                if (!this.psSysDEFType.isSEARCHMBEDITORWIDTHNull()) {
                    this.nSearchMBEditorWidth = this.psSysDEFType.getSEARCHMBEDITORWIDTH();
                }
                if (!this.psSysDEFType.isSEARCHMBEDITORHEIGHTNull()) {
                    this.nSearchMBEditorHeight = this.psSysDEFType.getSEARCHMBEDITORHEIGHT();
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public boolean isSupportPSDEField(String strDEFieldTag) {
        if (this.fieldMap != null) {
            return this.fieldMap.containsKey(strDEFieldTag.toUpperCase());
        }
        return this.iPSDEFieldType.isSupportPSDEField(strDEFieldTag);
    }

    @Override
    public IPSDEField createPSDEField(PSDEField psDEField) throws Exception {
        return this.iPSDEFieldType.createPSDEField(psDEField);
    }

    @Override
    public String getPSCodeListTemplId() {
        return this.iPSDEFieldType.getPSCodeListTemplId();
    }

    @Override
    public int getStdDataType() {
        if (this.nStdDataType != null) {
            return this.nStdDataType;
        }
        return this.iPSDEFieldType.getStdDataType();
    }

    @Override
    public int getPrecision() {
        if (this.nPrecision != null) {
            return this.nPrecision;
        }
        return this.iPSDEFieldType.getPrecision();
    }

    @Override
    public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode psDEFUIMode) throws Exception {
        return this.iPSDEFieldType.createPSDEFGridColumn(psDEFUIMode);
    }

    @Override
    public IPSDEFFormItem createPSDEFFormItem(PSDEFUIMode psDEFUIMode) throws Exception {
        return this.iPSDEFieldType.createPSDEFFormItem(psDEFUIMode);
    }

    @Override
    public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode psDEFUIMode) throws Exception {
        return this.iPSDEFieldType.createPSDEFUIMode(psDEFUIMode);
    }

    @Override
    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode psDEFSearchMode) throws Exception {
        return this.iPSDEFieldType.createPSDEFSearchMode(psDEFSearchMode);
    }

    @Override
    public IPSDEFSearchFormItem createPSDEFSearchFormItem(PSDEFSearchMode psDEFSearchMode) throws Exception {
        return this.iPSDEFieldType.createPSDEFSearchFormItem(psDEFSearchMode);
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        return this.iPSDEFieldType.getEditorType();
    }

    @Override
    public String getValueFormat(String strSFType) {
        if (this.strValueFormat != null) {
            return this.strValueFormat;
        }
        return this.iPSDEFieldType.getValueFormat(strSFType);
    }

    @Override
    public int getStringLength() {
        if (this.nStringLength != null) {
            return this.nStringLength;
        }
        return this.iPSDEFieldType.getStringLength();
    }

    @Override
    public int getLength() {
        if (this.nLength != null) {
            return this.nLength;
        }
        return this.iPSDEFieldType.getLength();
    }

    @Override
    public String getMBEditorType() {
        return this.iPSDEFieldType.getMBEditorType();
    }

    @Override
    public IPSDEFieldType getPSDEFieldType() {
        return this.iPSDEFieldType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6", order=295)
    public Integer getEditorWidth() {
        if (this.nEditorWidth != null) {
            return this.nEditorWidth;
        }
        return this.iPSDEFieldType.getEditorWidth();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6", order=300)
    public Integer getEditorHeight() {
        if (this.nEditorHeight != null) {
            return this.nEditorHeight;
        }
        return this.iPSDEFieldType.getEditorHeight();
    }

    @Override
    public Integer getMBEditorWidth() {
        if (this.nMBEditorWidth != null) {
            return this.nMBEditorWidth;
        }
        return this.iPSDEFieldType.getMBEditorWidth();
    }

    @Override
    public Integer getMBEditorHeight() {
        if (this.nMBEditorHeight != null) {
            return this.nMBEditorHeight;
        }
        return this.iPSDEFieldType.getMBEditorHeight();
    }

    @Override
    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    @Override
    public String getPSSysValueRuleId() {
        return this.strPSSysValueRuleId;
    }

    @Override
    public boolean isAutoIncrement() {
        return this.iPSDEFieldType.isAutoIncrement();
    }

    @Override
    public boolean isUnsigned() {
        return this.iPSDEFieldType.isUnsigned();
    }

    @Override
    public String getSearchEditorType() {
        if (StringHelper.isNullOrEmpty((String)this.strSearchEditorType)) {
            return this.iPSDEFieldType.getSearchEditorType();
        }
        return this.strSearchEditorType;
    }

    @Override
    public Integer getSearchEditorWidth() {
        if (this.nSearchEditorWidth == null) {
            return this.iPSDEFieldType.getSearchEditorWidth();
        }
        return this.nSearchEditorWidth;
    }

    @Override
    public Integer getSearchEditorHeight() {
        if (this.nSearchEditorHeight == null) {
            return this.iPSDEFieldType.getSearchEditorHeight();
        }
        return this.nSearchEditorHeight;
    }

    @Override
    public String getSearchMBEditorType() {
        if (StringHelper.isNullOrEmpty((String)this.strSearchMBEditorType)) {
            return this.iPSDEFieldType.getSearchMBEditorType();
        }
        return this.strSearchMBEditorType;
    }

    @Override
    public Integer getSearchMBEditorWidth() {
        if (this.nSearchMBEditorWidth == null) {
            return this.iPSDEFieldType.getSearchMBEditorWidth();
        }
        return this.nSearchMBEditorWidth;
    }

    @Override
    public Integer getSearchMBEditorHeight() {
        if (this.nSearchMBEditorHeight == null) {
            return this.iPSDEFieldType.getSearchMBEditorHeight();
        }
        return this.nSearchMBEditorHeight;
    }

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSDEFieldType psDEFieldType) throws Exception {
    }

    @Override
    public String getPSValueRuleId() {
        return this.iPSDEFieldType.getPSValueRuleId();
    }
}

