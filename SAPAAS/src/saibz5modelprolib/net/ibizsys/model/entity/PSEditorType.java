/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSEditorType
extends BaseDataEntity {
    public static final String STANDARDEDITOR_TEXTBOX = "TEXTBOX";
    public static final String STANDARDEDITOR_USERCONTROL = "USERCONTROL";
    public static final String STANDARDEDITOR_HIDDEN = "HIDDEN";
    public static final String AJAXHANDLER_CodeList = "CodeList";
    public static final String AJAXHANDLER_PickupText = "PickupText";
    public static final String AJAXHANDLER_AC = "AC";
    public static final String AJAXHANDLER_Custom = "Custom";
    public static final String LINKVIEWSHOWMODE_NORMAL = "NORMAL";
    public static final String LINKVIEWSHOWMODE_MODAL = "MODAL";
    public static final String LINKVIEWSHOWMODE_EMBEDDED = "EMBEDDED";
    public static final String TAG_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String TAG_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_STANDARDTYPE = "STANDARDTYPE";
    public static final String TAG_STANDARDEDITOR = "STANDARDEDITOR";
    public static final String TAG_FIEDITOR = "FIEDITOR";
    public static final String TAG_GCEDITOR = "GCEDITOR";
    public static final String TAG_EDITABLE = "EDITABLE";
    public static final String TAG_EDITORPARAM = "EDITORPARAM";
    public static final String TAG_CONVERTCITEXT = "CONVERTCITEXT";
    public static final String TAG_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String TAG_VALUEPROCESSOR = "VALUEPROCESSOR";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_AJAXHANDLER = "AJAXHANDLER";
    public static final String TAG_REFVIEWSHOWMODE = "REFVIEWSHOWMODE";
    public static final String TAG_LINKVIEWSHOWMODE = "LINKVIEWSHOWMODE";

    public final boolean isPSEDITORTYPEIDNull() {
        return this.isParamNull(TAG_PSEDITORTYPEID);
    }

    public final String getPSEDITORTYPEID() {
        return this.getParamStringValue(TAG_PSEDITORTYPEID, "");
    }

    public final void setPSEDITORTYPEID(String strValue) {
        this.setParamValue(TAG_PSEDITORTYPEID, strValue);
    }

    public final boolean isPSEDITORTYPENAMENull() {
        return this.isParamNull(TAG_PSEDITORTYPENAME);
    }

    public final String getPSEDITORTYPENAME() {
        return this.getParamStringValue(TAG_PSEDITORTYPENAME, "");
    }

    public final void setPSEDITORTYPENAME(String strValue) {
        this.setParamValue(TAG_PSEDITORTYPENAME, strValue);
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

    public final boolean isSTANDARDTYPENull() {
        return this.isParamNull(TAG_STANDARDTYPE);
    }

    public final boolean getSTANDARDTYPE() {
        return this.getParamIntValue(TAG_STANDARDTYPE, 0) == 1;
    }

    public final void setSTANDARDTYPE(boolean bValue) {
        this.setParamValue(TAG_STANDARDTYPE, bValue ? 1 : 0);
    }

    public final boolean isSTANDARDEDITORNull() {
        return this.isParamNull(TAG_STANDARDEDITOR);
    }

    public final String getSTANDARDEDITOR() {
        return this.getParamStringValue(TAG_STANDARDEDITOR, "");
    }

    public final void setSTANDARDEDITOR(String strValue) {
        this.setParamValue(TAG_STANDARDEDITOR, strValue);
    }

    public final boolean isFIEDITORNull() {
        return this.isParamNull(TAG_FIEDITOR);
    }

    public final boolean getFIEDITOR() {
        return this.getParamIntValue(TAG_FIEDITOR, 0) == 1;
    }

    public final void setFIEDITOR(boolean bValue) {
        this.setParamValue(TAG_FIEDITOR, bValue ? 1 : 0);
    }

    public final boolean isGCEDITORNull() {
        return this.isParamNull(TAG_GCEDITOR);
    }

    public final boolean getGCEDITOR() {
        return this.getParamIntValue(TAG_GCEDITOR, 0) == 1;
    }

    public final void setGCEDITOR(boolean bValue) {
        this.setParamValue(TAG_GCEDITOR, bValue ? 1 : 0);
    }

    public final boolean isEDITABLENull() {
        return this.isParamNull(TAG_EDITABLE);
    }

    public final boolean getEDITABLE() {
        return this.getParamIntValue(TAG_EDITABLE, 0) == 1;
    }

    public final void setEDITABLE(boolean bValue) {
        this.setParamValue(TAG_EDITABLE, bValue ? 1 : 0);
    }

    public final boolean isEDITORPARAMNull() {
        return this.isParamNull(TAG_EDITORPARAM);
    }

    public final String getEDITORPARAM() {
        return this.getParamStringValue(TAG_EDITORPARAM, "");
    }

    public final void setEDITORPARAM(String strValue) {
        this.setParamValue(TAG_EDITORPARAM, strValue);
    }

    public final boolean isCONVERTCITEXTNull() {
        return this.isParamNull(TAG_CONVERTCITEXT);
    }

    public final boolean getCONVERTCITEXT() {
        return this.getParamIntValue(TAG_CONVERTCITEXT, 0) == 1;
    }

    public final void setCONVERTCITEXT(boolean bValue) {
        this.setParamValue(TAG_CONVERTCITEXT, bValue ? 1 : 0);
    }

    public final boolean isNEEDCODELISTCONFIGNull() {
        return this.isParamNull(TAG_NEEDCODELISTCONFIG);
    }

    public final boolean getNEEDCODELISTCONFIG() {
        return this.getParamIntValue(TAG_NEEDCODELISTCONFIG, 0) == 1;
    }

    public final void setNEEDCODELISTCONFIG(boolean bValue) {
        this.setParamValue(TAG_NEEDCODELISTCONFIG, bValue ? 1 : 0);
    }

    public final boolean isVALUEPROCESSORNull() {
        return this.isParamNull(TAG_VALUEPROCESSOR);
    }

    public final String getVALUEPROCESSOR() {
        return this.getParamStringValue(TAG_VALUEPROCESSOR, "");
    }

    public final void setVALUEPROCESSOR(String strValue) {
        this.setParamValue(TAG_VALUEPROCESSOR, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.isParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.getParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.setParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
    }

    public final void setICONPATH(String strValue) {
        this.setParamValue(TAG_ICONPATH, strValue);
    }

    public final boolean isAJAXHANDLERNull() {
        return this.isParamNull(TAG_AJAXHANDLER);
    }

    public final String getAJAXHANDLER() {
        return this.getParamStringValue(TAG_AJAXHANDLER, "");
    }

    public final void setAJAXHANDLER(String strValue) {
        this.setParamValue(TAG_AJAXHANDLER, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isICONPATHNull() {
        return this.isParamNull(TAG_ICONPATH);
    }

    public final String getICONPATH() {
        return this.getParamStringValue(TAG_ICONPATH, "");
    }

    public final boolean isREFVIEWSHOWMODENull() {
        return this.isParamNull(TAG_REFVIEWSHOWMODE);
    }

    public final String getREFVIEWSHOWMODE() {
        return this.getParamStringValue(TAG_REFVIEWSHOWMODE, "");
    }

    public final void setREFVIEWSHOWMODE(String strValue) {
        this.setParamValue(TAG_REFVIEWSHOWMODE, strValue);
    }

    public final boolean isLINKVIEWSHOWMODENull() {
        return this.isParamNull(TAG_LINKVIEWSHOWMODE);
    }

    public final String getLINKVIEWSHOWMODE() {
        return this.getParamStringValue(TAG_LINKVIEWSHOWMODE, "");
    }

    public final void setLINKVIEWSHOWMODE(String strValue) {
        this.setParamValue(TAG_LINKVIEWSHOWMODE, strValue);
    }
}

