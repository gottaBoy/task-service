/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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
    public static final String TAG_PSCODELISTTEMPLID = "PSCODELISTTEMPLID";
    public static final String TAG_PSCODELISTTEMPLNAME = "PSCODELISTTEMPLNAME";
    public static final String EDITORTYPE_TEXTBOX = "TEXTBOX";
    public static final String EDITORTYPE_USERCONTROL = "USERCONTROL";
    public static final String EDITORTYPE_HIDDEN = "HIDDEN";
    public static final String EDITORTYPE_IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";
    public static final String EDITORTYPE_SPAN = "SPAN";
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

    public final boolean isPSDEFTYPEIDNull() {
        return this.isParamNull(TAG_PSDEFTYPEID);
    }

    public final String getPSDEFTYPEID() {
        return this.getParamStringValue(TAG_PSDEFTYPEID, "");
    }

    public final void setPSDEFTYPEID(String strValue) {
        this.setParamValue(TAG_PSDEFTYPEID, strValue);
    }

    public final boolean isPSDEFTYPENAMENull() {
        return this.isParamNull(TAG_PSDEFTYPENAME);
    }

    public final String getPSDEFTYPENAME() {
        return this.getParamStringValue(TAG_PSDEFTYPENAME, "");
    }

    public final void setPSDEFTYPENAME(String strValue) {
        this.setParamValue(TAG_PSDEFTYPENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDATATYPESNull() {
        return this.isParamNull(TAG_DATATYPES);
    }

    public final String getDATATYPES() {
        return this.getParamStringValue(TAG_DATATYPES, "");
    }

    public final void setDATATYPES(String strValue) {
        this.setParamValue(TAG_DATATYPES, strValue);
    }

    public final boolean isFIELDSNull() {
        return this.isParamNull(TAG_FIELDS);
    }

    public final String getFIELDS() {
        return this.getParamStringValue(TAG_FIELDS, "");
    }

    public final void setFIELDS(String strValue) {
        this.setParamValue(TAG_FIELDS, strValue);
    }

    public final boolean isOBJHELPERNull() {
        return this.isParamNull(TAG_OBJHELPER);
    }

    public final String getOBJHELPER() {
        return this.getParamStringValue(TAG_OBJHELPER, "");
    }

    public final void setOBJHELPER(String strValue) {
        this.setParamValue(TAG_OBJHELPER, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isOBJHELPER2Null() {
        return this.isParamNull(TAG_OBJHELPER2);
    }

    public final String getOBJHELPER2() {
        return this.getParamStringValue(TAG_OBJHELPER2, "");
    }

    public final void setOBJHELPER2(String strValue) {
        this.setParamValue(TAG_OBJHELPER2, strValue);
    }

    public final boolean isPSCODELISTTEMPLIDNull() {
        return this.isParamNull(TAG_PSCODELISTTEMPLID);
    }

    public final String getPSCODELISTTEMPLID() {
        return this.getParamStringValue(TAG_PSCODELISTTEMPLID, "");
    }

    public final void setPSCODELISTTEMPLID(String strValue) {
        this.setParamValue(TAG_PSCODELISTTEMPLID, strValue);
    }

    public final boolean isPSCODELISTTEMPLNAMENull() {
        return this.isParamNull(TAG_PSCODELISTTEMPLNAME);
    }

    public final String getPSCODELISTTEMPLNAME() {
        return this.getParamStringValue(TAG_PSCODELISTTEMPLNAME, "");
    }

    public final void setPSCODELISTTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTTEMPLNAME, strValue);
    }

    public final boolean isSTDDATATYPENull() {
        return this.isParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.getParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.setParamValue(TAG_STDDATATYPE, nValue);
    }

    public final boolean isGRIDCOLOBJNull() {
        return this.isParamNull(TAG_GRIDCOLOBJ);
    }

    public final String getGRIDCOLOBJ() {
        return this.getParamStringValue(TAG_GRIDCOLOBJ, "");
    }

    public final void setGRIDCOLOBJ(String strValue) {
        this.setParamValue(TAG_GRIDCOLOBJ, strValue);
    }

    public final boolean isFORMITEMOBJNull() {
        return this.isParamNull(TAG_FORMITEMOBJ);
    }

    public final String getFORMITEMOBJ() {
        return this.getParamStringValue(TAG_FORMITEMOBJ, "");
    }

    public final void setFORMITEMOBJ(String strValue) {
        this.setParamValue(TAG_FORMITEMOBJ, strValue);
    }

    public final boolean isEDITORTYPENull() {
        return this.isParamNull(TAG_EDITORTYPE);
    }

    public final String getEDITORTYPE() {
        return this.getParamStringValue(TAG_EDITORTYPE, "");
    }

    public final void setEDITORTYPE(String strValue) {
        this.setParamValue(TAG_EDITORTYPE, strValue);
    }

    public final boolean isJAVAFORMATNull() {
        return this.isParamNull(TAG_JAVAFORMAT);
    }

    public final String getJAVAFORMAT() {
        return this.getParamStringValue(TAG_JAVAFORMAT, "");
    }

    public final void setJAVAFORMAT(String strValue) {
        this.setParamValue(TAG_JAVAFORMAT, strValue);
    }

    public final boolean isDOTNETFORMATNull() {
        return this.isParamNull(TAG_DOTNETFORMAT);
    }

    public final String getDOTNETFORMAT() {
        return this.getParamStringValue(TAG_DOTNETFORMAT, "");
    }

    public final void setDOTNETFORMAT(String strValue) {
        this.setParamValue(TAG_DOTNETFORMAT, strValue);
    }

    public final boolean isUIMODEOBJNull() {
        return this.isParamNull(TAG_UIMODEOBJ);
    }

    public final String getUIMODEOBJ() {
        return this.getParamStringValue(TAG_UIMODEOBJ, "");
    }

    public final void setUIMODEOBJ(String strValue) {
        this.setParamValue(TAG_UIMODEOBJ, strValue);
    }

    public final boolean isSEARCHMODEOBJNull() {
        return this.isParamNull(TAG_SEARCHMODEOBJ);
    }

    public final String getSEARCHMODEOBJ() {
        return this.getParamStringValue(TAG_SEARCHMODEOBJ, "");
    }

    public final void setSEARCHMODEOBJ(String strValue) {
        this.setParamValue(TAG_SEARCHMODEOBJ, strValue);
    }

    public final boolean isSFITEMOBJNull() {
        return this.isParamNull(TAG_SFITEMOBJ);
    }

    public final String getSFITEMOBJ() {
        return this.getParamStringValue(TAG_SFITEMOBJ, "");
    }

    public final void setSFITEMOBJ(String strValue) {
        this.setParamValue(TAG_SFITEMOBJ, strValue);
    }

    public final boolean isEDITORWIDTHNull() {
        return this.isParamNull(TAG_EDITORWIDTH);
    }

    public final int getEDITORWIDTH() {
        return this.getParamIntValue(TAG_EDITORWIDTH, 0);
    }

    public final void setEDITORWIDTH(int nValue) {
        this.setParamValue(TAG_EDITORWIDTH, nValue);
    }

    public final boolean isEDITORHEIGHTNull() {
        return this.isParamNull(TAG_EDITORHEIGHT);
    }

    public final int getEDITORHEIGHT() {
        return this.getParamIntValue(TAG_EDITORHEIGHT, 0);
    }

    public final void setEDITORHEIGHT(int nValue) {
        this.setParamValue(TAG_EDITORHEIGHT, nValue);
    }

    public final boolean isSTRLENGTHNull() {
        return this.isParamNull(TAG_STRLENGTH);
    }

    public final int getSTRLENGTH() {
        return this.getParamIntValue(TAG_STRLENGTH, 0);
    }

    public final void setSTRLENGTH(int nValue) {
        this.setParamValue(TAG_STRLENGTH, nValue);
    }

    public final boolean isMBEDITORTYPENull() {
        return this.isParamNull(TAG_MBEDITORTYPE);
    }

    public final String getMBEDITORTYPE() {
        return this.getParamStringValue(TAG_MBEDITORTYPE, "");
    }

    public final void setMBEDITORTYPE(String strValue) {
        this.setParamValue(TAG_MBEDITORTYPE, strValue);
    }

    public final boolean isMBEDITORWIDTHNull() {
        return this.isParamNull(TAG_MBEDITORWIDTH);
    }

    public final int getMBEDITORWIDTH() {
        return this.getParamIntValue(TAG_MBEDITORWIDTH, 0);
    }

    public final void setMBEDITORWIDTH(int nValue) {
        this.setParamValue(TAG_MBEDITORWIDTH, nValue);
    }

    public final boolean isMBEDITORHEIGHTNull() {
        return this.isParamNull(TAG_MBEDITORHEIGHT);
    }

    public final int getMBEDITORHEIGHT() {
        return this.getParamIntValue(TAG_MBEDITORHEIGHT, 0);
    }

    public final void setMBEDITORHEIGHT(int nValue) {
        this.setParamValue(TAG_MBEDITORHEIGHT, nValue);
    }

    public final boolean isTESTDATANull() {
        return this.isParamNull(TAG_TESTDATA);
    }

    public final String getTESTDATA() {
        return this.getParamStringValue(TAG_TESTDATA, "");
    }

    public final void setTESTDATA(String strValue) {
        this.setParamValue(TAG_TESTDATA, strValue);
    }

    public final boolean isPRECISION2Null() {
        return this.isParamNull(TAG_PRECISION2);
    }

    public final int getPRECISION2() {
        return this.getParamIntValue(TAG_PRECISION2, 0);
    }

    public final void setPRECISION2(int nValue) {
        this.setParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isPSUNITIDNull() {
        return this.isParamNull(TAG_PSUNITID);
    }

    public final String getPSUNITID() {
        return this.getParamStringValue(TAG_PSUNITID, "");
    }

    public final void setPSUNITID(String strValue) {
        this.setParamValue(TAG_PSUNITID, strValue);
    }

    public final boolean isPSUNITNAMENull() {
        return this.isParamNull(TAG_PSUNITNAME);
    }

    public final String getPSUNITNAME() {
        return this.getParamStringValue(TAG_PSUNITNAME, "");
    }

    public final void setPSUNITNAME(String strValue) {
        this.setParamValue(TAG_PSUNITNAME, strValue);
    }

    public final boolean isPSVALUERULEIDNull() {
        return this.isParamNull(TAG_PSVALUERULEID);
    }

    public final String getPSVALUERULEID() {
        return this.getParamStringValue(TAG_PSVALUERULEID, "");
    }

    public final void setPSVALUERULEID(String strValue) {
        this.setParamValue(TAG_PSVALUERULEID, strValue);
    }

    public final boolean isPSVALUERULENAMENull() {
        return this.isParamNull(TAG_PSVALUERULENAME);
    }

    public final String getPSVALUERULENAME() {
        return this.getParamStringValue(TAG_PSVALUERULENAME, "");
    }

    public final void setPSVALUERULENAME(String strValue) {
        this.setParamValue(TAG_PSVALUERULENAME, strValue);
    }

    public final boolean isINCREMENTFLAGNull() {
        return this.isParamNull(TAG_INCREMENTFLAG);
    }

    public final boolean getINCREMENTFLAG() {
        return this.getParamIntValue(TAG_INCREMENTFLAG, 0) == 1;
    }

    public final void setINCREMENTFLAG(boolean bValue) {
        this.setParamValue(TAG_INCREMENTFLAG, bValue ? 1 : 0);
    }

    public final boolean isUNSIGNEDFLAGNull() {
        return this.isParamNull(TAG_UNSIGNEDFLAG);
    }

    public final boolean getUNSIGNEDFLAG() {
        return this.getParamIntValue(TAG_UNSIGNEDFLAG, 0) == 1;
    }

    public final void setUNSIGNEDFLAG(boolean bValue) {
        this.setParamValue(TAG_UNSIGNEDFLAG, bValue ? 1 : 0);
    }

    public final boolean isSEARCHMBEDITORWIDTHNull() {
        return this.isParamNull(TAG_SEARCHMBEDITORWIDTH);
    }

    public final int getSEARCHMBEDITORWIDTH() {
        return this.getParamIntValue(TAG_SEARCHMBEDITORWIDTH, 0);
    }

    public final void setSEARCHMBEDITORWIDTH(int nValue) {
        this.setParamValue(TAG_SEARCHMBEDITORWIDTH, nValue);
    }

    public final boolean isSEARCHMBEDITORHEIGHTNull() {
        return this.isParamNull(TAG_SEARCHMBEDITORHEIGHT);
    }

    public final int getSEARCHMBEDITORHEIGHT() {
        return this.getParamIntValue(TAG_SEARCHMBEDITORHEIGHT, 0);
    }

    public final void setSEARCHMBEDITORHEIGHT(int nValue) {
        this.setParamValue(TAG_SEARCHMBEDITORHEIGHT, nValue);
    }

    public final boolean isSEARCHMBEDITORTYPENull() {
        return this.isParamNull(TAG_SEARCHMBEDITORTYPE);
    }

    public final String getSEARCHMBEDITORTYPE() {
        return this.getParamStringValue(TAG_SEARCHMBEDITORTYPE, "");
    }

    public final void setSEARCHMBEDITORTYPE(String strValue) {
        this.setParamValue(TAG_SEARCHMBEDITORTYPE, strValue);
    }

    public final boolean isSEARCHEDITORTYPENull() {
        return this.isParamNull(TAG_SEARCHEDITORTYPE);
    }

    public final String getSEARCHEDITORTYPE() {
        return this.getParamStringValue(TAG_SEARCHEDITORTYPE, "");
    }

    public final void setSEARCHEDITORTYPE(String strValue) {
        this.setParamValue(TAG_SEARCHEDITORTYPE, strValue);
    }

    public final boolean isSEARCHEDITORHEIGHTNull() {
        return this.isParamNull(TAG_SEARCHEDITORHEIGHT);
    }

    public final int getSEARCHEDITORHEIGHT() {
        return this.getParamIntValue(TAG_SEARCHEDITORHEIGHT, 0);
    }

    public final void setSEARCHEDITORHEIGHT(int nValue) {
        this.setParamValue(TAG_SEARCHEDITORHEIGHT, nValue);
    }

    public final boolean isSEARCHEDITORWIDTHNull() {
        return this.isParamNull(TAG_SEARCHEDITORWIDTH);
    }

    public final int getSEARCHEDITORWIDTH() {
        return this.getParamIntValue(TAG_SEARCHEDITORWIDTH, 0);
    }

    public final void setSEARCHEDITORWIDTH(int nValue) {
        this.setParamValue(TAG_SEARCHEDITORWIDTH, nValue);
    }
}

