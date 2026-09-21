/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSEditorType
extends BaseDataEntity {
    public static final String STANDARDEDITOR_TEXTBOX = "TEXTBOX";
    public static final String STANDARDEDITOR_USERCONTROL = "USERCONTROL";
    public static final String STANDARDEDITOR_HIDDEN = "HIDDEN";
    public static final String STANDARDEDITOR_MOBTEXT = "MOBTEXT";
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
    public static final String TAG_JAVAFORMAT = "JAVAFORMAT";
    public static final String TAG_DOTNETFORMAT = "DOTNETFORMAT";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_MOBFIEDITOR = "MOBFIEDITOR";
    public static final String TAG_EDITORCODE = "EDITORCODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_AJAXHANDLER = "AJAXHANDLER";
    public static final String TAG_REFVIEWSHOWMODE = "REFVIEWSHOWMODE";
    public static final String TAG_LINKVIEWSHOWMODE = "LINKVIEWSHOWMODE";
    public static final String TAG_CTRLOBJ = "CTRLOBJ";
    public static final String TAG_INFOEDITOR = "INFOEDITOR";
    public static final String TAG_SBEDITOR = "SBEDITOR";

    public final boolean isPSEDITORTYPEIDNull() {
        return this.IsParamNull(TAG_PSEDITORTYPEID);
    }

    public final String getPSEDITORTYPEID() {
        return this.GetParamStringValue(TAG_PSEDITORTYPEID, "");
    }

    public final void setPSEDITORTYPEID(String strValue) {
        this.SetParamValue(TAG_PSEDITORTYPEID, strValue);
    }

    public final boolean isPSEDITORTYPENAMENull() {
        return this.IsParamNull(TAG_PSEDITORTYPENAME);
    }

    public final String getPSEDITORTYPENAME() {
        return this.GetParamStringValue(TAG_PSEDITORTYPENAME, "");
    }

    public final void setPSEDITORTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSEDITORTYPENAME, strValue);
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

    public final boolean isSTANDARDTYPENull() {
        return this.IsParamNull(TAG_STANDARDTYPE);
    }

    public final boolean getSTANDARDTYPE() {
        return this.GetParamIntValue(TAG_STANDARDTYPE, 0) == 1;
    }

    public final void setSTANDARDTYPE(boolean bValue) {
        this.SetParamValue(TAG_STANDARDTYPE, bValue ? 1 : 0);
    }

    public final boolean isSTANDARDEDITORNull() {
        return this.IsParamNull(TAG_STANDARDEDITOR);
    }

    public final String getSTANDARDEDITOR() {
        return this.GetParamStringValue(TAG_STANDARDEDITOR, "");
    }

    public final void setSTANDARDEDITOR(String strValue) {
        this.SetParamValue(TAG_STANDARDEDITOR, strValue);
    }

    public final boolean isFIEDITORNull() {
        return this.IsParamNull(TAG_FIEDITOR);
    }

    public final boolean getFIEDITOR() {
        return this.GetParamIntValue(TAG_FIEDITOR, 0) == 1;
    }

    public final void setFIEDITOR(boolean bValue) {
        this.SetParamValue(TAG_FIEDITOR, bValue ? 1 : 0);
    }

    public final boolean isGCEDITORNull() {
        return this.IsParamNull(TAG_GCEDITOR);
    }

    public final boolean getGCEDITOR() {
        return this.GetParamIntValue(TAG_GCEDITOR, 0) == 1;
    }

    public final void setGCEDITOR(boolean bValue) {
        this.SetParamValue(TAG_GCEDITOR, bValue ? 1 : 0);
    }

    public final boolean isEDITABLENull() {
        return this.IsParamNull(TAG_EDITABLE);
    }

    public final boolean getEDITABLE() {
        return this.GetParamIntValue(TAG_EDITABLE, 0) == 1;
    }

    public final void setEDITABLE(boolean bValue) {
        this.SetParamValue(TAG_EDITABLE, bValue ? 1 : 0);
    }

    public final boolean isEDITORPARAMNull() {
        return this.IsParamNull(TAG_EDITORPARAM);
    }

    public final String getEDITORPARAM() {
        return this.GetParamStringValue(TAG_EDITORPARAM, "");
    }

    public final void setEDITORPARAM(String strValue) {
        this.SetParamValue(TAG_EDITORPARAM, strValue);
    }

    public final boolean isCONVERTCITEXTNull() {
        return this.IsParamNull(TAG_CONVERTCITEXT);
    }

    public final boolean getCONVERTCITEXT() {
        return this.GetParamIntValue(TAG_CONVERTCITEXT, 0) == 1;
    }

    public final void setCONVERTCITEXT(boolean bValue) {
        this.SetParamValue(TAG_CONVERTCITEXT, bValue ? 1 : 0);
    }

    public final boolean isNEEDCODELISTCONFIGNull() {
        return this.IsParamNull(TAG_NEEDCODELISTCONFIG);
    }

    public final boolean getNEEDCODELISTCONFIG() {
        return this.GetParamIntValue(TAG_NEEDCODELISTCONFIG, 0) == 1;
    }

    public final void setNEEDCODELISTCONFIG(boolean bValue) {
        this.SetParamValue(TAG_NEEDCODELISTCONFIG, bValue ? 1 : 0);
    }

    public final boolean isVALUEPROCESSORNull() {
        return this.IsParamNull(TAG_VALUEPROCESSOR);
    }

    public final String getVALUEPROCESSOR() {
        return this.GetParamStringValue(TAG_VALUEPROCESSOR, "");
    }

    public final void setVALUEPROCESSOR(String strValue) {
        this.SetParamValue(TAG_VALUEPROCESSOR, strValue);
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

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isMOBFIEDITORNull() {
        return this.IsParamNull(TAG_MOBFIEDITOR);
    }

    public final boolean getMOBFIEDITOR() {
        return this.GetParamIntValue(TAG_MOBFIEDITOR, 0) == 1;
    }

    public final void setMOBFIEDITOR(boolean bValue) {
        this.SetParamValue(TAG_MOBFIEDITOR, bValue ? 1 : 0);
    }

    public final boolean isEDITORCODENull() {
        return this.IsParamNull(TAG_EDITORCODE);
    }

    public final String getEDITORCODE() {
        return this.GetParamStringValue(TAG_EDITORCODE, "");
    }

    public final void setEDITORCODE(String strValue) {
        this.SetParamValue(TAG_EDITORCODE, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isICONPATHNull() {
        return this.IsParamNull(TAG_ICONPATH);
    }

    public final String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public final void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public final boolean isAJAXHANDLERNull() {
        return this.IsParamNull(TAG_AJAXHANDLER);
    }

    public final String getAJAXHANDLER() {
        return this.GetParamStringValue(TAG_AJAXHANDLER, "");
    }

    public final void setAJAXHANDLER(String strValue) {
        this.SetParamValue(TAG_AJAXHANDLER, strValue);
    }

    public final boolean isREFVIEWSHOWMODENull() {
        return this.IsParamNull(TAG_REFVIEWSHOWMODE);
    }

    public final String getREFVIEWSHOWMODE() {
        return this.GetParamStringValue(TAG_REFVIEWSHOWMODE, "");
    }

    public final void setREFVIEWSHOWMODE(String strValue) {
        this.SetParamValue(TAG_REFVIEWSHOWMODE, strValue);
    }

    public final boolean isLINKVIEWSHOWMODENull() {
        return this.IsParamNull(TAG_LINKVIEWSHOWMODE);
    }

    public final String getLINKVIEWSHOWMODE() {
        return this.GetParamStringValue(TAG_LINKVIEWSHOWMODE, "");
    }

    public final void setLINKVIEWSHOWMODE(String strValue) {
        this.SetParamValue(TAG_LINKVIEWSHOWMODE, strValue);
    }

    public final boolean isCTRLOBJNull() {
        return this.IsParamNull(TAG_CTRLOBJ);
    }

    public final String getCTRLOBJ() {
        return this.GetParamStringValue(TAG_CTRLOBJ, "");
    }

    public final void setCTRLOBJ(String strValue) {
        this.SetParamValue(TAG_CTRLOBJ, strValue);
    }

    public final boolean isINFOEDITORNull() {
        return this.IsParamNull(TAG_INFOEDITOR);
    }

    public final String getINFOEDITOR() {
        return this.GetParamStringValue(TAG_INFOEDITOR, "");
    }

    public final void setINFOEDITOR(String strValue) {
        this.SetParamValue(TAG_INFOEDITOR, strValue);
    }

    public final boolean isSBEDITORNull() {
        return this.IsParamNull(TAG_SBEDITOR);
    }

    public final boolean getSBEDITOR() {
        return this.GetParamIntValue(TAG_SBEDITOR, 0) == 1;
    }

    public final void setSBEDITOR(boolean bValue) {
        this.SetParamValue(TAG_SBEDITOR, bValue ? 1 : 0);
    }
}

