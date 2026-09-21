/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysDEFType
extends BaseDataEntity {
    public static final String MBEDITORTYPE_MOBTEXT = "MOBTEXT";
    public static final String MBEDITORTYPE_MOBTEXTAREA = "MOBTEXTAREA";
    public static final String MBEDITORTYPE_MOBDROPDOWNLIST = "MOBDROPDOWNLIST";
    public static final String MBEDITORTYPE_MOBDATE = "MOBDATE";
    public static final String MBEDITORTYPE_MOBSWITCH = "MOBSWITCH";
    public static final String MBEDITORTYPE_MOBCHECKLIST = "MOBCHECKLIST";
    public static final String MBEDITORTYPE_MOBPICKER = "MOBPICKER";
    public static final String MBEDITORTYPE_MOBPICTURE = "MOBPICTURE";
    public static final String MBEDITORTYPE_MOBRADIOLIST = "MOBRADIOLIST";
    public static final String MBEDITORTYPE_MOBPICTURELIST = "MOBPICTURELIST";
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
    public static final String EDITORTYPE_PICTURE = "PICTURE";
    public static final String EDITORTYPE_DATEPICKEREX = "DATEPICKEREX";
    public static final String EDITORTYPE_DATEPICKEREX_HOUR = "DATEPICKEREX_HOUR";
    public static final String EDITORTYPE_DATEPICKEREX_MINUTE = "DATEPICKEREX_MINUTE";
    public static final String EDITORTYPE_DATEPICKEREX_SECOND = "DATEPICKEREX_SECOND";
    public static final String EDITORTYPE_DATEPICKEREX_NODAY = "DATEPICKEREX_NODAY";
    public static final String EDITORTYPE_DATEPICKEREX_NODAY_NOSECOND = "DATEPICKEREX_NODAY_NOSECOND";
    public static final String EDITORTYPE_SPANEX = "SPANEX";
    public static final String EDITORTYPE_PICKEREX_NOBUTTON = "PICKEREX_NOBUTTON";
    public static final String EDITORTYPE_PICKEREX_NOAC = "PICKEREX_NOAC";
    public static final String EDITORTYPE_DATEPICKEREX_NOTIME = "DATEPICKEREX_NOTIME";
    public static final String EDITORTYPE_LISTBOXPICKUP = "LISTBOXPICKUP";
    public static final String EDITORTYPE_OFFICEEDITOR = "OFFICEEDITOR";
    public static final String EDITORTYPE_PASSWORD = "PASSWORD";
    public static final String EDITORTYPE_ADDRESSPICKUP = "ADDRESSPICKUP";
    public static final String EDITORTYPE_OFFICEEDITOR2 = "OFFICEEDITOR2";
    public static final String EDITORTYPE_PICKEREX_LINK = "PICKEREX_LINK";
    public static final String EDITORTYPE_PICKEREX_NOAC_LINK = "PICKEREX_NOAC_LINK";
    public static final String EDITORTYPE_PICKEREX_TRIGGER_LINK = "PICKEREX_TRIGGER_LINK";
    public static final String EDITORTYPE_DROPDOWNLIST_100 = "DROPDOWNLIST_100";
    public static final String EDITORTYPE_AC_FS_NOBUTTON = "AC_FS_NOBUTTON";
    public static final String EDITORTYPE_AC_NOBUTTON = "AC_NOBUTTON";
    public static final int STDDATATYPE_0 = 0;
    public static final int STDDATATYPE_1 = 1;
    public static final int STDDATATYPE_2 = 2;
    public static final int STDDATATYPE_3 = 3;
    public static final int STDDATATYPE_4 = 4;
    public static final int STDDATATYPE_5 = 5;
    public static final int STDDATATYPE_6 = 6;
    public static final int STDDATATYPE_7 = 7;
    public static final int STDDATATYPE_8 = 8;
    public static final int STDDATATYPE_9 = 9;
    public static final int STDDATATYPE_10 = 10;
    public static final int STDDATATYPE_11 = 11;
    public static final int STDDATATYPE_12 = 12;
    public static final int STDDATATYPE_13 = 13;
    public static final int STDDATATYPE_14 = 14;
    public static final int STDDATATYPE_15 = 15;
    public static final int STDDATATYPE_16 = 16;
    public static final int STDDATATYPE_17 = 17;
    public static final int STDDATATYPE_18 = 18;
    public static final int STDDATATYPE_19 = 19;
    public static final int STDDATATYPE_20 = 20;
    public static final int STDDATATYPE_21 = 21;
    public static final int STDDATATYPE_22 = 22;
    public static final int STDDATATYPE_23 = 23;
    public static final int STDDATATYPE_24 = 24;
    public static final int STDDATATYPE_25 = 25;
    public static final int STDDATATYPE_26 = 26;
    public static final int STDDATATYPE_27 = 27;
    public static final int STDDATATYPE_28 = 28;
    public static final String TAG_PSSYSDEFTYPEID = "PSSYSDEFTYPEID";
    public static final String TAG_PSSYSDEFTYPENAME = "PSSYSDEFTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEFTYPEID = "PSDEFTYPEID";
    public static final String TAG_PSDEFTYPENAME = "PSDEFTYPENAME";
    public static final String TAG_MBEDITORWIDTH = "MBEDITORWIDTH";
    public static final String TAG_MBEDITORHEIGHT = "MBEDITORHEIGHT";
    public static final String TAG_MBEDITORTYPE = "MBEDITORTYPE";
    public static final String TAG_STRLENGTH = "STRLENGTH";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_EDITORHEIGHT = "EDITORHEIGHT";
    public static final String TAG_EDITORWIDTH = "EDITORWIDTH";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_FIELDS = "FIELDS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_PSSYSUNITID = "PSSYSUNITID";
    public static final String TAG_PSSYSUNITNAME = "PSSYSUNITNAME";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_SEARCHMBEDITORWIDTH = "SEARCHMBEDITORWIDTH";
    public static final String TAG_SEARCHMBEDITORHEIGHT = "SEARCHMBEDITORHEIGHT";
    public static final String TAG_SEARCHMBEDITORTYPE = "SEARCHMBEDITORTYPE";
    public static final String TAG_SEARCHEDITORTYPE = "SEARCHEDITORTYPE";
    public static final String TAG_SEARCHEDITORHEIGHT = "SEARCHEDITORHEIGHT";
    public static final String TAG_SEARCHEDITORWIDTH = "SEARCHEDITORWIDTH";

    public final boolean isPSSYSDEFTYPEIDNull() {
        return this.isParamNull(TAG_PSSYSDEFTYPEID);
    }

    public final String getPSSYSDEFTYPEID() {
        return this.getParamStringValue(TAG_PSSYSDEFTYPEID, "");
    }

    public final void setPSSYSDEFTYPEID(String strValue) {
        this.setParamValue(TAG_PSSYSDEFTYPEID, strValue);
    }

    public final boolean isPSSYSDEFTYPENAMENull() {
        return this.isParamNull(TAG_PSSYSDEFTYPENAME);
    }

    public final String getPSSYSDEFTYPENAME() {
        return this.getParamStringValue(TAG_PSSYSDEFTYPENAME, "");
    }

    public final void setPSSYSDEFTYPENAME(String strValue) {
        this.setParamValue(TAG_PSSYSDEFTYPENAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

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

    public final boolean isMBEDITORTYPENull() {
        return this.isParamNull(TAG_MBEDITORTYPE);
    }

    public final String getMBEDITORTYPE() {
        return this.getParamStringValue(TAG_MBEDITORTYPE, "");
    }

    public final void setMBEDITORTYPE(String strValue) {
        this.setParamValue(TAG_MBEDITORTYPE, strValue);
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

    public final boolean isEDITORTYPENull() {
        return this.isParamNull(TAG_EDITORTYPE);
    }

    public final String getEDITORTYPE() {
        return this.getParamStringValue(TAG_EDITORTYPE, "");
    }

    public final void setEDITORTYPE(String strValue) {
        this.setParamValue(TAG_EDITORTYPE, strValue);
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

    public final boolean isEDITORWIDTHNull() {
        return this.isParamNull(TAG_EDITORWIDTH);
    }

    public final int getEDITORWIDTH() {
        return this.getParamIntValue(TAG_EDITORWIDTH, 0);
    }

    public final void setEDITORWIDTH(int nValue) {
        this.setParamValue(TAG_EDITORWIDTH, nValue);
    }

    public final boolean isVALUEFORMATNull() {
        return this.isParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.getParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.setParamValue(TAG_VALUEFORMAT, strValue);
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

    public final boolean isFIELDSNull() {
        return this.isParamNull(TAG_FIELDS);
    }

    public final String getFIELDS() {
        return this.getParamStringValue(TAG_FIELDS, "");
    }

    public final void setFIELDS(String strValue) {
        this.setParamValue(TAG_FIELDS, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isPSCODELISTIDNull() {
        return this.isParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.getParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.setParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.isParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.getParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isPSSYSUNITIDNull() {
        return this.isParamNull(TAG_PSSYSUNITID);
    }

    public final String getPSSYSUNITID() {
        return this.getParamStringValue(TAG_PSSYSUNITID, "");
    }

    public final void setPSSYSUNITID(String strValue) {
        this.setParamValue(TAG_PSSYSUNITID, strValue);
    }

    public final boolean isPSSYSUNITNAMENull() {
        return this.isParamNull(TAG_PSSYSUNITNAME);
    }

    public final String getPSSYSUNITNAME() {
        return this.getParamStringValue(TAG_PSSYSUNITNAME, "");
    }

    public final void setPSSYSUNITNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNITNAME, strValue);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.isParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.getParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.isParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.getParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULENAME, strValue);
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

