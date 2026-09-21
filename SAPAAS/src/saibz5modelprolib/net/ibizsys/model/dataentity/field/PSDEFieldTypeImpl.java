/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFFormItem
 *  net.ibizsys.model.control.form.IPSDEFSearchFormItem
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field;

import java.util.HashMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.form.IPSDEFSearchFormItem;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDEFieldType;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFieldTypeImpl
extends PSObjectImpl
implements IPSDEFieldType {
    protected PSDEFieldType psDEFieldType = null;
    private String strObjHelper = "";
    protected HashMap<String, String> dataTypeMap = null;
    protected HashMap<String, String> fieldMap = null;
    private int nStdDataType = 0;
    private String strJavaFormat = "%1$s";
    private String strDotNetFormat = "{0}";
    private int nStringLength = 100;
    private int nLength = -1;
    private Integer nPrecision = 0;
    private Integer nEditorWidth = null;
    private Integer nMBEditorWidth = null;
    private Integer nEditorHeight = null;
    private Integer nMBEditorHeight = null;
    private Integer nSearchEditorWidth = null;
    private Integer nSearchMBEditorWidth = null;
    private Integer nSearchEditorHeight = null;
    private Integer nSearchMBEditorHeight = null;
    private String strSearchEditorType = null;
    private String strSearchMBEditorType = null;
    private String strPSUnitId = null;
    private String strPSValueRuleId = null;
    private boolean bAutoIncrement = false;
    private boolean bUnsigned = false;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSDEFieldType psDEFieldType) throws Exception {
        String strFields;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.psDEFieldType = psDEFieldType;
        this.setId(this.psDEFieldType.getPSDEFTYPEID());
        this.setName(this.psDEFieldType.getPSDEFTYPENAME());
        this.setPSObjectData(this.psDEFieldType);
        this.strObjHelper = this.psDEFieldType.getOBJHELPER2();
        if (StringHelper.isNullOrEmpty((String)this.strObjHelper)) {
            this.strObjHelper = this.psDEFieldType.getOBJHELPER();
        }
        if (!StringHelper.isNullOrEmpty((String)(strFields = this.psDEFieldType.getFIELDS()))) {
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
        if (!psDEFieldType.isSTDDATATYPENull()) {
            this.nStdDataType = psDEFieldType.getSTDDATATYPE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFieldType.getJAVAFORMAT())) {
            this.strJavaFormat = this.psDEFieldType.getJAVAFORMAT();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFieldType.getDOTNETFORMAT())) {
            this.strDotNetFormat = this.psDEFieldType.getDOTNETFORMAT();
        }
        if (!this.psDEFieldType.isSTRLENGTHNull()) {
            this.nStringLength = this.psDEFieldType.getSTRLENGTH();
            this.nLength = this.psDEFieldType.getSTRLENGTH();
        } else {
            this.nStringLength = DataTypeHelper.isLongStringType((int)this.getStdDataType()) ? 0x100000 : 200;
        }
        if (!this.psDEFieldType.isPRECISION2Null()) {
            this.nPrecision = this.psDEFieldType.getPRECISION2();
        }
        if (!this.psDEFieldType.isEDITORWIDTHNull()) {
            this.nEditorWidth = this.psDEFieldType.getEDITORWIDTH();
        }
        if (!this.psDEFieldType.isEDITORHEIGHTNull()) {
            this.nEditorHeight = this.psDEFieldType.getEDITORHEIGHT();
        }
        if (!this.psDEFieldType.isMBEDITORWIDTHNull()) {
            this.nMBEditorWidth = this.psDEFieldType.getMBEDITORWIDTH();
        }
        if (!this.psDEFieldType.isMBEDITORHEIGHTNull()) {
            this.nMBEditorHeight = this.psDEFieldType.getMBEDITORHEIGHT();
        }
        this.strSearchEditorType = this.psDEFieldType.getSEARCHEDITORTYPE();
        if (StringHelper.isNullOrEmpty((String)this.strSearchEditorType)) {
            this.strSearchEditorType = this.psDEFieldType.getEDITORTYPE();
            this.nSearchEditorWidth = this.nEditorWidth;
            this.nSearchEditorHeight = this.nEditorHeight;
        } else {
            if (!this.psDEFieldType.isSEARCHEDITORWIDTHNull()) {
                this.nSearchEditorWidth = this.psDEFieldType.getSEARCHEDITORWIDTH();
            }
            if (!this.psDEFieldType.isSEARCHEDITORHEIGHTNull()) {
                this.nSearchEditorHeight = this.psDEFieldType.getSEARCHEDITORHEIGHT();
            }
        }
        this.strSearchMBEditorType = this.psDEFieldType.getSEARCHMBEDITORTYPE();
        if (StringHelper.isNullOrEmpty((String)this.strSearchMBEditorType)) {
            this.strSearchMBEditorType = this.psDEFieldType.getMBEDITORTYPE();
            if (StringHelper.isNullOrEmpty((String)this.strSearchMBEditorType)) {
                this.strSearchMBEditorType = this.psDEFieldType.getEDITORTYPE();
            }
            this.nSearchMBEditorWidth = this.nMBEditorWidth;
            this.nSearchMBEditorHeight = this.nMBEditorHeight;
        } else {
            if (!this.psDEFieldType.isSEARCHMBEDITORWIDTHNull()) {
                this.nSearchMBEditorWidth = this.psDEFieldType.getSEARCHMBEDITORWIDTH();
            }
            if (!this.psDEFieldType.isSEARCHMBEDITORHEIGHTNull()) {
                this.nSearchMBEditorHeight = this.psDEFieldType.getSEARCHMBEDITORHEIGHT();
            }
        }
        this.strPSUnitId = this.psDEFieldType.getPSUNITID();
        this.strPSValueRuleId = this.psDEFieldType.getPSVALUERULEID();
        if (!this.psDEFieldType.isINCREMENTFLAGNull()) {
            this.bAutoIncrement = this.psDEFieldType.getINCREMENTFLAG();
        }
        if (!this.psDEFieldType.isUNSIGNEDFLAGNull()) {
            this.bUnsigned = this.psDEFieldType.getUNSIGNEDFLAG();
        }
        this.onInit();
    }

    @Override
    public IPSDEField createPSDEField(PSDEField psDEField) throws Exception {
        String strObj = this.strObjHelper.replace("SA.SRFDA.PS.Core.DEField", "net.ibizsys.model.dataentity.field");
        return (IPSDEField)this.getPSModelStorageContext().createObject(strObj);
    }

    @Override
    public boolean isSupportPSDEField(String strDEFieldTag) {
        return this.fieldMap != null && this.fieldMap.containsKey(strDEFieldTag.toUpperCase());
    }

    @Override
    public String getPSCodeListTemplId() {
        return this.psDEFieldType.getPSCODELISTTEMPLID();
    }

    @Override
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    public int getPrecision() {
        return this.nPrecision;
    }

    @Override
    public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode psDEFUIMode) throws Exception {
        return (IPSDEFGridColumn)this.getPSModelStorageContext().createObject(this.psDEFieldType.getGRIDCOLOBJ());
    }

    @Override
    public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode psDEFUIMode) throws Exception {
        return (IPSDEFUIMode)this.getPSModelStorageContext().createObject(this.psDEFieldType.getUIMODEOBJ());
    }

    @Override
    public IPSDEFFormItem createPSDEFFormItem(PSDEFUIMode psDEFUIMode) throws Exception {
        return (IPSDEFFormItem)this.getPSModelStorageContext().createObject(this.psDEFieldType.getFORMITEMOBJ());
    }

    @Override
    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode psDEFSearchMode) throws Exception {
        return (IPSDEFSearchMode)this.getPSModelStorageContext().createObject(this.psDEFieldType.getSEARCHMODEOBJ());
    }

    @Override
    public IPSDEFSearchFormItem createPSDEFSearchFormItem(PSDEFSearchMode psDEFSearchMode) throws Exception {
        return (IPSDEFSearchFormItem)this.getPSModelStorageContext().createObject(this.psDEFieldType.getSFITEMOBJ());
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        return this.psDEFieldType.getEDITORTYPE();
    }

    @Override
    public String getValueFormat(String strSFType) {
        if (strSFType.indexOf("J2EE") != -1) {
            return this.strJavaFormat;
        }
        return this.strDotNetFormat;
    }

    @Override
    public int getStringLength() {
        return this.nStringLength;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getMBEditorType() {
        if (StringHelper.isNullOrEmpty((String)this.psDEFieldType.getMBEDITORTYPE())) {
            return this.getEditorType();
        }
        return this.psDEFieldType.getMBEDITORTYPE();
    }

    @Override
    public int getLength() {
        return this.nLength;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6", order=290)
    public Integer getEditorWidth() {
        return this.nEditorWidth;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6", order=300)
    public Integer getEditorHeight() {
        return this.nEditorHeight;
    }

    @Override
    public Integer getMBEditorWidth() {
        return this.nMBEditorWidth;
    }

    @Override
    public Integer getMBEditorHeight() {
        return this.nMBEditorHeight;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u7f16\u8f91\u5668\u7c7b\u578b", order=382)
    public String getSearchEditorType() {
        return this.strSearchEditorType;
    }

    @Override
    public String getSearchMBEditorType() {
        return this.strSearchMBEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u7f16\u8f91\u5668\u5bbd\u5ea6", order=390)
    public Integer getSearchEditorWidth() {
        return this.nSearchEditorWidth;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u7f16\u8f91\u5668\u9ad8\u5ea6", order=400)
    public Integer getSearchEditorHeight() {
        return this.nSearchEditorHeight;
    }

    @Override
    public Integer getSearchMBEditorWidth() {
        return this.nSearchMBEditorWidth;
    }

    @Override
    public Integer getSearchMBEditorHeight() {
        return this.nSearchMBEditorHeight;
    }

    @Override
    public String getPSValueRuleId() {
        return this.strPSValueRuleId;
    }

    @Override
    public boolean isAutoIncrement() {
        return this.bAutoIncrement;
    }

    @Override
    public boolean isUnsigned() {
        return this.bUnsigned;
    }
}

