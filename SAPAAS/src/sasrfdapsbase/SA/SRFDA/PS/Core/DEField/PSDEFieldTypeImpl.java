/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFSearchFormItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDEFieldType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.LinkedHashMap;
import java.util.Map;

public class PSDEFieldTypeImpl
extends PSObjectImpl
implements IPSDEFieldType {
    protected PSDEFieldType psDEFieldType = null;
    private String strObjHelper = "";
    protected Map<String, String> dataTypeMap = null;
    protected Map<String, String> fieldMap = null;
    private int nStdDataType = 0;
    private String strJavaFormat = "%1$s";
    private String strDotNetFormat = "{0}";
    private String strJSFormat = null;
    private String strTSFormat = null;
    private String strPYFormat = null;
    private int nStringLength = 100;
    private int nMinStringLength = 0;
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
    private String strMaxValue = null;
    private String strMinValue = null;
    private String strGridColumnAlign = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDEFieldType psDEFieldType) throws Exception {
        String strFields;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDEFieldType = psDEFieldType;
        this.setId(this.psDEFieldType.getPSDEFTYPEID());
        this.setName(this.psDEFieldType.getPSDEFTYPENAME());
        this.setPSObjectData(this.psDEFieldType);
        this.strObjHelper = this.psDEFieldType.getOBJHELPER2();
        if (StringHelper.IsNullOrEmpty((String)this.strObjHelper)) {
            this.strObjHelper = this.psDEFieldType.getOBJHELPER();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strFields = this.psDEFieldType.getFIELDS()))) {
            String[] datatypes;
            strFields = strFields.toUpperCase();
            this.fieldMap = new LinkedHashMap<String, String>();
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
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getJAVAFORMAT())) {
            this.strJavaFormat = this.psDEFieldType.getJAVAFORMAT();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getDOTNETFORMAT())) {
            this.strDotNetFormat = this.psDEFieldType.getDOTNETFORMAT();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getTSFORMAT())) {
            this.strTSFormat = this.psDEFieldType.getTSFORMAT();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getJSFORMAT())) {
            this.strJSFormat = this.psDEFieldType.getJSFORMAT();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strJSFormat) && !StringHelper.IsNullOrEmpty((String)this.strJavaFormat)) {
            if (StringHelper.Compare((String)this.strJavaFormat, (String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (boolean)false) == 0) {
                this.strJSFormat = "YYYY-MM-DD HH:mm:ss";
            } else if (StringHelper.Compare((String)this.strJavaFormat, (String)"%1$tY-%1$tm-%1$td", (boolean)false) == 0) {
                this.strJSFormat = "YYYY-MM-DD";
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getPYFORMAT())) {
            this.strPYFormat = this.psDEFieldType.getPYFORMAT();
        }
        if (!this.psDEFieldType.isSTRLENGTHNull()) {
            this.nStringLength = this.psDEFieldType.getSTRLENGTH();
            this.nLength = this.psDEFieldType.getSTRLENGTH();
        } else {
            this.nStringLength = DataTypeHelper.IsLongStringType((int)this.getStdDataType()) ? 0x100000 : 200;
        }
        if (!this.psDEFieldType.isMINSTRLENGTHNull()) {
            this.nMinStringLength = this.psDEFieldType.getMINSTRLENGTH();
            if (this.nMinStringLength < 0) {
                this.nMinStringLength = 0;
            }
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
        if (StringHelper.IsNullOrEmpty((String)this.strSearchEditorType)) {
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
        if (StringHelper.IsNullOrEmpty((String)this.strSearchMBEditorType)) {
            this.strSearchMBEditorType = this.psDEFieldType.getMBEDITORTYPE();
            if (StringHelper.IsNullOrEmpty((String)this.strSearchMBEditorType)) {
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
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getMINVALUESTR())) {
            this.strMinValue = this.psDEFieldType.getMINVALUESTR();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getMAXVALUESTR())) {
            this.strMaxValue = this.psDEFieldType.getMAXVALUESTR();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getGRIDCOLALIGN())) {
            this.strGridColumnAlign = this.psDEFieldType.getGRIDCOLALIGN();
        }
        this.onInit();
    }

    @Override
    public IPSDEField createPSDEField(PSDEField psDEField) throws Exception {
        return (IPSDEField)ObjectHelper.Create((String)this.strObjHelper);
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
    public String getUnit() {
        return "";
    }

    @Override
    public int getUnitWidth() {
        return 0;
    }

    @Override
    public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode psDEFUIMode) throws Exception {
        return (IPSDEFGridColumn)ObjectHelper.Create((String)this.psDEFieldType.getGRIDCOLOBJ());
    }

    @Override
    public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode psDEFUIMode) throws Exception {
        return (IPSDEFUIMode)ObjectHelper.Create((String)this.psDEFieldType.getUIMODEOBJ());
    }

    @Override
    public IPSDEFFormItem createPSDEFFormItem(PSDEFUIMode psDEFUIMode) throws Exception {
        return (IPSDEFFormItem)ObjectHelper.Create((String)this.psDEFieldType.getFORMITEMOBJ());
    }

    @Override
    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode psDEFSearchMode) throws Exception {
        return (IPSDEFSearchMode)ObjectHelper.Create((String)this.psDEFieldType.getSEARCHMODEOBJ());
    }

    @Override
    public IPSDEFSearchFormItem createPSDEFSearchFormItem(PSDEFSearchMode psDEFSearchMode) throws Exception {
        return (IPSDEFSearchFormItem)ObjectHelper.Create((String)this.psDEFieldType.getSFITEMOBJ());
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
        if (StringHelper.Compare((String)"JS", (String)strSFType, (boolean)true) == 0) {
            return this.strJSFormat;
        }
        if (StringHelper.Compare((String)"TS", (String)strSFType, (boolean)true) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)this.strTSFormat)) {
                return this.strTSFormat;
            }
            return this.strJSFormat;
        }
        if (StringHelper.Compare((String)"PY", (String)strSFType, (boolean)true) == 0) {
            return this.strPYFormat;
        }
        return this.strDotNetFormat;
    }

    @Override
    public int getStringLength() {
        return this.nStringLength;
    }

    @Override
    public int getMinStringLength() {
        return this.nMinStringLength;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getMBEditorType() {
        if (StringHelper.IsNullOrEmpty((String)this.psDEFieldType.getMBEDITORTYPE())) {
            return this.getEditorType();
        }
        return this.psDEFieldType.getMBEDITORTYPE();
    }

    @Override
    public String getTestDataValue() {
        return this.psDEFieldType.getTESTDATA();
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
    public String getPSUnitId() {
        return this.strPSUnitId;
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

    @Override
    public String getMaxValueString() {
        return this.strMaxValue;
    }

    @Override
    public String getMinValueString() {
        return this.strMinValue;
    }

    @Override
    public String getGridColumnAlign() {
        return this.strGridColumnAlign;
    }
}

