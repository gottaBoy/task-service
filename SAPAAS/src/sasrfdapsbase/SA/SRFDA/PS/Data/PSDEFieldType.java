/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFieldType
extends BaseDataEntity {
    public static final String DATATYPES_TEXT = "TEXT";
    public static final String DATATYPES_GUID = "GUID";
    public static final String DATATYPES_ACID = "ACID";
    public static final String DATATYPES_LONGTEXT_1000 = "LONGTEXT_1000";
    public static final String DATATYPES_LONGTEXT = "LONGTEXT";
    public static final String DATATYPES_HTMLTEXT = "HTMLTEXT";
    public static final String DATATYPES_INT = "INT";
    public static final String DATATYPES_BIGINT = "BIGINT";
    public static final String DATATYPES_SBID = "SBID";
    public static final String DATATYPES_NBID = "NBID";
    public static final String DATATYPES_FLOAT = "FLOAT";
    public static final String DATATYPES_DECIMAL = "DECIMAL";
    public static final String DATATYPES_DATE = "DATE";
    public static final String DATATYPES_TIME = "TIME";
    public static final String DATATYPES_DATETIME = "DATETIME";
    public static final String DATATYPES_SSCODELIST = "SSCODELIST";
    public static final String DATATYPES_SMCODELIST = "SMCODELIST";
    public static final String DATATYPES_NSCODELIST = "NSCODELIST";
    public static final String DATATYPES_NMCODELIST = "NMCODELIST";
    public static final String DATATYPES_PICKUP = "PICKUP";
    public static final String DATATYPES_PICKUPTEXT = "PICKUPTEXT";
    public static final String DATATYPES_PICKUPDATA = "PICKUPDATA";
    public static final String DATATYPES_INHERIT = "INHERIT";
    public static final String DATATYPES_YESNO = "YESNO";
    public static final String DATATYPES_TRUEFALSE = "TRUEFALSE";
    public static final String DATATYPES_CURRENCY = "CURRENCY";
    public static final String DATATYPES_CURRENCYUNIT = "CURRENCYUNIT";
    public static final String DATATYPES_WFSTATE = "WFSTATE";
    public static final String DATATYPES_DATETIME_BIRTHDAY = "DATETIME_BIRTHDAY";
    public static final String DATATYPES_TEXT_EMAIL = "TEXT_EMAIL";
    public static final String DATATYPES_BINARY = "BINARY";
    public static final String DATATYPES_TEXTARRAY = "TEXTARRAY";
    public static final String DATATYPES_TEXTARRAY2 = "TEXTARRAY2";
    public static final String DATATYPES_INTARRAY = "INTARRAY";
    public static final String DATATYPES_INTARRAY2 = "INTARRAY2";
    public static final String DATATYPES_BIGINTARRAY = "BIGINTARRAY";
    public static final String DATATYPES_BIGINTARRAY2 = "BIGINTARRAY2";
    public static final String DATATYPES_FLOATARRAY = "FLOATARRAY";
    public static final String DATATYPES_FLOATARRAY2 = "FLOATARRAY2";
    public static final String DATATYPES_DECIMALARRAY = "DECIMALARRAY";
    public static final String DATATYPES_DECIMALARRAY2 = "DECIMALARRAY2";
    public static final String TAG_PSCODELISTTEMPLID = "PSCODELISTTEMPLID";
    public static final String TAG_PSCODELISTTEMPLNAME = "PSCODELISTTEMPLNAME";
    public static final String EDITORTYPE_TEXTBOX = "TEXTBOX";
    public static final String EDITORTYPE_USERCONTROL = "USERCONTROL";
    public static final String EDITORTYPE_HIDDEN = "HIDDEN";
    public static final String EDITORTYPE_IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";
    public static final String EDITORTYPE_SPAN = "SPAN";
    public static final String EDITORTYPE_SPAN_LINK = "SPAN_LINK";
    public static final String EDITORTYPE_TEXTAREA = "TEXTAREA";
    public static final String EDITORTYPE_PICKER = "PICKER";
    public static final String EDITORTYPE_DROPDOWNLIST = "DROPDOWNLIST";
    public static final String EDITORTYPE_HTMLEDITOR = "HTMLEDITOR";
    public static final String EDITORTYPE_RAW = "RAW";
    public static final String EDITORTYPE_DATEPICKER = "DATEPICKER";
    public static final String EDITORTYPE_LISTBOX = "LISTBOX";
    public static final String EDITORTYPE_CHECKBOXLIST = "CHECKBOXLIST";
    public static final String EDITORTYPE_CHECKBOX = "CHECKBOX";
    public static final String EDITORTYPE_RADIOBUTTONLIST = "RADIOBUTTONLIST";
    public static final String EDITORTYPE_FILEUPLOADER = "FILEUPLOADER";
    public static final String EDITORTYPE_PICKEREX_TRIGGER = "PICKEREX_TRIGGER";
    public static final String EDITORTYPE_TEXTAREA_10 = "TEXTAREA_10";
    public static final String EDITORTYPE_AC = "AC";
    public static final String EDITORTYPE_AC_FS = "AC_FS";
    public static final String MBEDITORTYPE_MOB2DBARCODEREADER = "MOB2DBARCODEREADER";
    public static final String MBEDITORTYPE_MOBBARCODEREADER = "MOBBARCODEREADER";
    public static final String MBEDITORTYPE_MOBCHECKLIST = "MOBCHECKLIST";
    public static final String MBEDITORTYPE_MOBDATE = "MOBDATE";
    public static final String MBEDITORTYPE_MOBDROPDOWNLIST = "MOBDROPDOWNLIST";
    public static final String MBEDITORTYPE_MOBPICKER = "MOBPICKER";
    public static final String MBEDITORTYPE_MOBPICTURE = "MOBPICTURE";
    public static final String MBEDITORTYPE_MOBPICTURELIST = "MOBPICTURELIST";
    public static final String MBEDITORTYPE_MOBRADIOLIST = "MOBRADIOLIST";
    public static final String MBEDITORTYPE_MOBSWITCH = "MOBSWITCH";
    public static final String MBEDITORTYPE_MOBTEXT = "MOBTEXT";
    public static final String MBEDITORTYPE_MOBTEXTAREA = "MOBTEXTAREA";
    public static final String TAG_PSDEFTYPEID = "PSDEFTYPEID";
    public static final String TAG_PSDEFTYPENAME = "PSDEFTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DATATYPES = "DATATYPES";
    public static final String TAG_FIELDS = "FIELDS";
    public static final String TAG_OBJHELPER = "OBJHELPER";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_OBJHELPER2 = "OBJHELPER2";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_GRIDCOLOBJ = "GRIDCOLOBJ";
    public static final String TAG_FORMITEMOBJ = "FORMITEMOBJ";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_JAVAFORMAT = "JAVAFORMAT";
    public static final String TAG_DOTNETFORMAT = "DOTNETFORMAT";
    public static final String TAG_UIMODEOBJ = "UIMODEOBJ";
    public static final String TAG_SEARCHMODEOBJ = "SEARCHMODEOBJ";
    public static final String TAG_SFITEMOBJ = "SFITEMOBJ";
    public static final String TAG_EDITORWIDTH = "EDITORWIDTH";
    public static final String TAG_EDITORHEIGHT = "EDITORHEIGHT";
    public static final String TAG_STRLENGTH = "STRLENGTH";
    public static final String TAG_MBEDITORTYPE = "MBEDITORTYPE";
    public static final String TAG_MBEDITORWIDTH = "MBEDITORWIDTH";
    public static final String TAG_MBEDITORHEIGHT = "MBEDITORHEIGHT";
    public static final String TAG_TESTDATA = "TESTDATA";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_PSUNITID = "PSUNITID";
    public static final String TAG_PSUNITNAME = "PSUNITNAME";
    public static final String TAG_PSVALUERULEID = "PSVALUERULEID";
    public static final String TAG_PSVALUERULENAME = "PSVALUERULENAME";
    public static final String TAG_INCREMENTFLAG = "INCREMENTFLAG";
    public static final String TAG_UNSIGNEDFLAG = "UNSIGNEDFLAG";
    public static final String TAG_SEARCHMBEDITORWIDTH = "SEARCHMBEDITORWIDTH";
    public static final String TAG_SEARCHMBEDITORHEIGHT = "SEARCHMBEDITORHEIGHT";
    public static final String TAG_SEARCHMBEDITORTYPE = "SEARCHMBEDITORTYPE";
    public static final String TAG_SEARCHEDITORTYPE = "SEARCHEDITORTYPE";
    public static final String TAG_SEARCHEDITORHEIGHT = "SEARCHEDITORHEIGHT";
    public static final String TAG_SEARCHEDITORWIDTH = "SEARCHEDITORWIDTH";
    public static final String TAG_JSFORMAT = "JSFORMAT";
    public static final String TAG_TSFORMAT = "TSFORMAT";
    public static final String TAG_PYFORMAT = "PYFORMAT";
    public static final String TAG_MAXVALUE = "MAXVALUE";
    public static final String TAG_MINVALUE = "MINVALUE";
    public static final String TAG_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String TAG_MAXVALUESTR = "MAXVALUESTR";
    public static final String TAG_MINVALUESTR = "MINVALUESTR";
    public static final String TAG_GRIDCOLWIDTH = "GRIDCOLWIDTH";
    public static final String TAG_GRIDCOLALIGN = "GRIDCOLALIGN";
    public static final String TAG_GRIDCOLCLMODE = "GRIDCOLCLMODE";

    public final boolean isPSDEFTYPEIDNull() {
        return this.IsParamNull(TAG_PSDEFTYPEID);
    }

    public final String getPSDEFTYPEID() {
        return this.GetParamStringValue(TAG_PSDEFTYPEID, "");
    }

    public final void setPSDEFTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDEFTYPEID, strValue);
    }

    public final boolean isPSDEFTYPENAMENull() {
        return this.IsParamNull(TAG_PSDEFTYPENAME);
    }

    public final String getPSDEFTYPENAME() {
        return this.GetParamStringValue(TAG_PSDEFTYPENAME, "");
    }

    public final void setPSDEFTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFTYPENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDATATYPESNull() {
        return this.IsParamNull(TAG_DATATYPES);
    }

    public final String getDATATYPES() {
        return this.GetParamStringValue(TAG_DATATYPES, "");
    }

    public final void setDATATYPES(String strValue) {
        this.SetParamValue(TAG_DATATYPES, strValue);
    }

    public final boolean isFIELDSNull() {
        return this.IsParamNull(TAG_FIELDS);
    }

    public final String getFIELDS() {
        return this.GetParamStringValue(TAG_FIELDS, "");
    }

    public final void setFIELDS(String strValue) {
        this.SetParamValue(TAG_FIELDS, strValue);
    }

    public final boolean isOBJHELPERNull() {
        return this.IsParamNull(TAG_OBJHELPER);
    }

    public final String getOBJHELPER() {
        return this.GetParamStringValue(TAG_OBJHELPER, "");
    }

    public final void setOBJHELPER(String strValue) {
        this.SetParamValue(TAG_OBJHELPER, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isOBJHELPER2Null() {
        return this.IsParamNull(TAG_OBJHELPER2);
    }

    public final String getOBJHELPER2() {
        return this.GetParamStringValue(TAG_OBJHELPER2, "");
    }

    public final void setOBJHELPER2(String strValue) {
        this.SetParamValue(TAG_OBJHELPER2, strValue);
    }

    public final boolean isPSCODELISTTEMPLIDNull() {
        return this.IsParamNull(TAG_PSCODELISTTEMPLID);
    }

    public final String getPSCODELISTTEMPLID() {
        return this.GetParamStringValue(TAG_PSCODELISTTEMPLID, "");
    }

    public final void setPSCODELISTTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTTEMPLID, strValue);
    }

    public final boolean isPSCODELISTTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTTEMPLNAME);
    }

    public final String getPSCODELISTTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTTEMPLNAME, "");
    }

    public final void setPSCODELISTTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTTEMPLNAME, strValue);
    }

    public final boolean isSTDDATATYPENull() {
        return this.IsParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.GetParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_STDDATATYPE, nValue);
    }

    public final boolean isGRIDCOLOBJNull() {
        return this.IsParamNull(TAG_GRIDCOLOBJ);
    }

    public final String getGRIDCOLOBJ() {
        return this.GetParamStringValue(TAG_GRIDCOLOBJ, "");
    }

    public final void setGRIDCOLOBJ(String strValue) {
        this.SetParamValue(TAG_GRIDCOLOBJ, strValue);
    }

    public final boolean isFORMITEMOBJNull() {
        return this.IsParamNull(TAG_FORMITEMOBJ);
    }

    public final String getFORMITEMOBJ() {
        return this.GetParamStringValue(TAG_FORMITEMOBJ, "");
    }

    public final void setFORMITEMOBJ(String strValue) {
        this.SetParamValue(TAG_FORMITEMOBJ, strValue);
    }

    public final boolean isEDITORTYPENull() {
        return this.IsParamNull(TAG_EDITORTYPE);
    }

    public final String getEDITORTYPE() {
        return this.GetParamStringValue(TAG_EDITORTYPE, "");
    }

    public final void setEDITORTYPE(String strValue) {
        this.SetParamValue(TAG_EDITORTYPE, strValue);
    }

    public final boolean isJAVAFORMATNull() {
        return this.IsParamNull(TAG_JAVAFORMAT);
    }

    public final String getJAVAFORMAT() {
        return this.GetParamStringValue(TAG_JAVAFORMAT, "");
    }

    public final void setJAVAFORMAT(String strValue) {
        this.SetParamValue(TAG_JAVAFORMAT, strValue);
    }

    public final boolean isDOTNETFORMATNull() {
        return this.IsParamNull(TAG_DOTNETFORMAT);
    }

    public final String getDOTNETFORMAT() {
        return this.GetParamStringValue(TAG_DOTNETFORMAT, "");
    }

    public final void setDOTNETFORMAT(String strValue) {
        this.SetParamValue(TAG_DOTNETFORMAT, strValue);
    }

    public final boolean isUIMODEOBJNull() {
        return this.IsParamNull(TAG_UIMODEOBJ);
    }

    public final String getUIMODEOBJ() {
        return this.GetParamStringValue(TAG_UIMODEOBJ, "");
    }

    public final void setUIMODEOBJ(String strValue) {
        this.SetParamValue(TAG_UIMODEOBJ, strValue);
    }

    public final boolean isSEARCHMODEOBJNull() {
        return this.IsParamNull(TAG_SEARCHMODEOBJ);
    }

    public final String getSEARCHMODEOBJ() {
        return this.GetParamStringValue(TAG_SEARCHMODEOBJ, "");
    }

    public final void setSEARCHMODEOBJ(String strValue) {
        this.SetParamValue(TAG_SEARCHMODEOBJ, strValue);
    }

    public final boolean isSFITEMOBJNull() {
        return this.IsParamNull(TAG_SFITEMOBJ);
    }

    public final String getSFITEMOBJ() {
        return this.GetParamStringValue(TAG_SFITEMOBJ, "");
    }

    public final void setSFITEMOBJ(String strValue) {
        this.SetParamValue(TAG_SFITEMOBJ, strValue);
    }

    public final boolean isEDITORWIDTHNull() {
        return this.IsParamNull(TAG_EDITORWIDTH);
    }

    public final int getEDITORWIDTH() {
        return this.GetParamIntValue(TAG_EDITORWIDTH, 0);
    }

    public final void setEDITORWIDTH(int nValue) {
        this.SetParamValue(TAG_EDITORWIDTH, nValue);
    }

    public final boolean isEDITORHEIGHTNull() {
        return this.IsParamNull(TAG_EDITORHEIGHT);
    }

    public final int getEDITORHEIGHT() {
        return this.GetParamIntValue(TAG_EDITORHEIGHT, 0);
    }

    public final void setEDITORHEIGHT(int nValue) {
        this.SetParamValue(TAG_EDITORHEIGHT, nValue);
    }

    public final boolean isSTRLENGTHNull() {
        return this.IsParamNull(TAG_STRLENGTH);
    }

    public final int getSTRLENGTH() {
        return this.GetParamIntValue(TAG_STRLENGTH, 0);
    }

    public final void setSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_STRLENGTH, nValue);
    }

    public final boolean isMBEDITORTYPENull() {
        return this.IsParamNull(TAG_MBEDITORTYPE);
    }

    public final String getMBEDITORTYPE() {
        return this.GetParamStringValue(TAG_MBEDITORTYPE, "");
    }

    public final void setMBEDITORTYPE(String strValue) {
        this.SetParamValue(TAG_MBEDITORTYPE, strValue);
    }

    public final boolean isMBEDITORWIDTHNull() {
        return this.IsParamNull(TAG_MBEDITORWIDTH);
    }

    public final int getMBEDITORWIDTH() {
        return this.GetParamIntValue(TAG_MBEDITORWIDTH, 0);
    }

    public final void setMBEDITORWIDTH(int nValue) {
        this.SetParamValue(TAG_MBEDITORWIDTH, nValue);
    }

    public final boolean isMBEDITORHEIGHTNull() {
        return this.IsParamNull(TAG_MBEDITORHEIGHT);
    }

    public final int getMBEDITORHEIGHT() {
        return this.GetParamIntValue(TAG_MBEDITORHEIGHT, 0);
    }

    public final void setMBEDITORHEIGHT(int nValue) {
        this.SetParamValue(TAG_MBEDITORHEIGHT, nValue);
    }

    public final boolean isTESTDATANull() {
        return this.IsParamNull(TAG_TESTDATA);
    }

    public final String getTESTDATA() {
        return this.GetParamStringValue(TAG_TESTDATA, "");
    }

    public final void setTESTDATA(String strValue) {
        this.SetParamValue(TAG_TESTDATA, strValue);
    }

    public final boolean isPRECISION2Null() {
        return this.IsParamNull(TAG_PRECISION2);
    }

    public final int getPRECISION2() {
        return this.GetParamIntValue(TAG_PRECISION2, 0);
    }

    public final void setPRECISION2(int nValue) {
        this.SetParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isPSUNITIDNull() {
        return this.IsParamNull(TAG_PSUNITID);
    }

    public final String getPSUNITID() {
        return this.GetParamStringValue(TAG_PSUNITID, "");
    }

    public final void setPSUNITID(String strValue) {
        this.SetParamValue(TAG_PSUNITID, strValue);
    }

    public final boolean isPSUNITNAMENull() {
        return this.IsParamNull(TAG_PSUNITNAME);
    }

    public final String getPSUNITNAME() {
        return this.GetParamStringValue(TAG_PSUNITNAME, "");
    }

    public final void setPSUNITNAME(String strValue) {
        this.SetParamValue(TAG_PSUNITNAME, strValue);
    }

    public final boolean isPSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSVALUERULEID);
    }

    public final String getPSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSVALUERULEID, "");
    }

    public final void setPSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSVALUERULEID, strValue);
    }

    public final boolean isPSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSVALUERULENAME);
    }

    public final String getPSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSVALUERULENAME, "");
    }

    public final void setPSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSVALUERULENAME, strValue);
    }

    public final boolean isINCREMENTFLAGNull() {
        return this.IsParamNull(TAG_INCREMENTFLAG);
    }

    public final boolean getINCREMENTFLAG() {
        return this.GetParamIntValue(TAG_INCREMENTFLAG, 0) == 1;
    }

    public final void setINCREMENTFLAG(boolean bValue) {
        this.SetParamValue(TAG_INCREMENTFLAG, bValue ? 1 : 0);
    }

    public final boolean isUNSIGNEDFLAGNull() {
        return this.IsParamNull(TAG_UNSIGNEDFLAG);
    }

    public final boolean getUNSIGNEDFLAG() {
        return this.GetParamIntValue(TAG_UNSIGNEDFLAG, 0) == 1;
    }

    public final void setUNSIGNEDFLAG(boolean bValue) {
        this.SetParamValue(TAG_UNSIGNEDFLAG, bValue ? 1 : 0);
    }

    public final boolean isSEARCHMBEDITORWIDTHNull() {
        return this.IsParamNull(TAG_SEARCHMBEDITORWIDTH);
    }

    public final int getSEARCHMBEDITORWIDTH() {
        return this.GetParamIntValue(TAG_SEARCHMBEDITORWIDTH, 0);
    }

    public final void setSEARCHMBEDITORWIDTH(int nValue) {
        this.SetParamValue(TAG_SEARCHMBEDITORWIDTH, nValue);
    }

    public final boolean isSEARCHMBEDITORHEIGHTNull() {
        return this.IsParamNull(TAG_SEARCHMBEDITORHEIGHT);
    }

    public final int getSEARCHMBEDITORHEIGHT() {
        return this.GetParamIntValue(TAG_SEARCHMBEDITORHEIGHT, 0);
    }

    public final void setSEARCHMBEDITORHEIGHT(int nValue) {
        this.SetParamValue(TAG_SEARCHMBEDITORHEIGHT, nValue);
    }

    public final boolean isSEARCHMBEDITORTYPENull() {
        return this.IsParamNull(TAG_SEARCHMBEDITORTYPE);
    }

    public final String getSEARCHMBEDITORTYPE() {
        return this.GetParamStringValue(TAG_SEARCHMBEDITORTYPE, "");
    }

    public final void setSEARCHMBEDITORTYPE(String strValue) {
        this.SetParamValue(TAG_SEARCHMBEDITORTYPE, strValue);
    }

    public final boolean isSEARCHEDITORTYPENull() {
        return this.IsParamNull(TAG_SEARCHEDITORTYPE);
    }

    public final String getSEARCHEDITORTYPE() {
        return this.GetParamStringValue(TAG_SEARCHEDITORTYPE, "");
    }

    public final void setSEARCHEDITORTYPE(String strValue) {
        this.SetParamValue(TAG_SEARCHEDITORTYPE, strValue);
    }

    public final boolean isSEARCHEDITORHEIGHTNull() {
        return this.IsParamNull(TAG_SEARCHEDITORHEIGHT);
    }

    public final int getSEARCHEDITORHEIGHT() {
        return this.GetParamIntValue(TAG_SEARCHEDITORHEIGHT, 0);
    }

    public final void setSEARCHEDITORHEIGHT(int nValue) {
        this.SetParamValue(TAG_SEARCHEDITORHEIGHT, nValue);
    }

    public final boolean isSEARCHEDITORWIDTHNull() {
        return this.IsParamNull(TAG_SEARCHEDITORWIDTH);
    }

    public final int getSEARCHEDITORWIDTH() {
        return this.GetParamIntValue(TAG_SEARCHEDITORWIDTH, 0);
    }

    public final void setSEARCHEDITORWIDTH(int nValue) {
        this.SetParamValue(TAG_SEARCHEDITORWIDTH, nValue);
    }

    public final boolean isJSFORMATNull() {
        return this.IsParamNull(TAG_JSFORMAT);
    }

    public final String getJSFORMAT() {
        return this.GetParamStringValue(TAG_JSFORMAT, "");
    }

    public final void setJSFORMAT(String strValue) {
        this.SetParamValue(TAG_JSFORMAT, strValue);
    }

    public final boolean isTSFORMATNull() {
        return this.IsParamNull(TAG_TSFORMAT);
    }

    public final String getTSFORMAT() {
        return this.GetParamStringValue(TAG_TSFORMAT, "");
    }

    public final void setTSFORMAT(String strValue) {
        this.SetParamValue(TAG_TSFORMAT, strValue);
    }

    public final boolean isPYFORMATNull() {
        return this.IsParamNull(TAG_PYFORMAT);
    }

    public final String getPYFORMAT() {
        return this.GetParamStringValue(TAG_PYFORMAT, "");
    }

    public final void setPYFORMAT(String strValue) {
        this.SetParamValue(TAG_PYFORMAT, strValue);
    }

    public final boolean isMAXVALUESTRNull() {
        return this.IsParamNull(TAG_MAXVALUESTR);
    }

    public final String getMAXVALUESTR() {
        return this.GetParamStringValue(TAG_MAXVALUESTR, "");
    }

    public final void setMAXVALUESTR(String strValue) {
        this.SetParamValue(TAG_MAXVALUESTR, strValue);
    }

    public final boolean isMINVALUESTRNull() {
        return this.IsParamNull(TAG_MINVALUESTR);
    }

    public final String getMINVALUESTR() {
        return this.GetParamStringValue(TAG_MINVALUESTR, "");
    }

    public final void setMINVALUESTR(String strValue) {
        this.SetParamValue(TAG_MINVALUESTR, strValue);
    }

    public final boolean isMINSTRLENGTHNull() {
        return this.IsParamNull(TAG_MINSTRLENGTH);
    }

    public final int getMINSTRLENGTH() {
        return this.GetParamIntValue(TAG_MINSTRLENGTH, 0);
    }

    public final void setMINSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_MINSTRLENGTH, nValue);
    }

    public final boolean isGRIDCOLWIDTHNull() {
        return this.IsParamNull(TAG_GRIDCOLWIDTH);
    }

    public final int getGRIDCOLWIDTH() {
        return this.GetParamIntValue(TAG_GRIDCOLWIDTH, 0);
    }

    public final void setGRIDCOLWIDTH(int nValue) {
        this.SetParamValue(TAG_GRIDCOLWIDTH, nValue);
    }

    public final boolean isGRIDCOLALIGNNull() {
        return this.IsParamNull(TAG_GRIDCOLALIGN);
    }

    public final String getGRIDCOLALIGN() {
        return this.GetParamStringValue(TAG_GRIDCOLALIGN, "");
    }

    public final void setGRIDCOLALIGN(String strValue) {
        this.SetParamValue(TAG_GRIDCOLALIGN, strValue);
    }

    public final boolean isGRIDCOLCLMODENull() {
        return this.IsParamNull(TAG_GRIDCOLCLMODE);
    }

    public final String getGRIDCOLCLMODE() {
        return this.GetParamStringValue(TAG_GRIDCOLCLMODE, "");
    }

    public final void setGRIDCOLCLMODE(String strValue) {
        this.SetParamValue(TAG_GRIDCOLCLMODE, strValue);
    }
}

