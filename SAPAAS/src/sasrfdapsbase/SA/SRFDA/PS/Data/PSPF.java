/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPF
extends BaseDataEntity {
    public static final int PFENGINEVER_UNKNOWN = 0;
    public static final int PFENGINEVER_10 = 10;
    public static final int PFENGINEVER_20 = 20;
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VIEWPUBOBJ = "VIEWPUBOBJ";
    public static final String TAG_CTRLPUBOBJ = "CTRLPUBOBJ";
    public static final String TAG_CTRLPARTPUBOBJ = "CTRLPARTPUBOBJ";
    public static final String TAG_EDITORPUBOBJ = "EDITORPUBOBJ";
    public static final String TAG_UAPUBOBJ = "UAPUBOBJ";
    public static final String TAG_VLPUBOBJ = "VLPUBOBJ";
    public static final String TAG_APPPUBOBJ = "APPPUBOBJ";
    public static final String TAG_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String TAG_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String TAG_FORMLAYOUTMODE = "FORMLAYOUTMODE";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_STYLEOBJ = "STYLEOBJ";
    public static final String TAG_JITAPPOBJ = "JITAPPOBJ";
    public static final String TAG_USEJITPREVIEW = "USEJITPREVIEW";
    public static final String TAG_STYLE2OBJ = "STYLE2OBJ";
    public static final String TAG_V2VIEWPUBOBJ = "V2VIEWPUBOBJ";
    public static final String TAG_V2VIEWMACROPARAMS = "V2VIEWMACROPARAMS";
    public static final String TAG_V2FOLDER = "V2FOLDER";
    public static final String TAG_V2GITPATH = "V2GITPATH";
    public static final String TAG_PFENGINEVER = "PFENGINEVER";

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.IsParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.GetParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.SetParamValue(TAG_PSPFNAME, strValue);
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

    public final boolean isVIEWPUBOBJNull() {
        return this.IsParamNull(TAG_VIEWPUBOBJ);
    }

    public final String getVIEWPUBOBJ() {
        return this.GetParamStringValue(TAG_VIEWPUBOBJ, "");
    }

    public final void setVIEWPUBOBJ(String strValue) {
        this.SetParamValue(TAG_VIEWPUBOBJ, strValue);
    }

    public final boolean isCTRLPUBOBJNull() {
        return this.IsParamNull(TAG_CTRLPUBOBJ);
    }

    public final String getCTRLPUBOBJ() {
        return this.GetParamStringValue(TAG_CTRLPUBOBJ, "");
    }

    public final void setCTRLPUBOBJ(String strValue) {
        this.SetParamValue(TAG_CTRLPUBOBJ, strValue);
    }

    public final boolean isCTRLPARTPUBOBJNull() {
        return this.IsParamNull(TAG_CTRLPARTPUBOBJ);
    }

    public final String getCTRLPARTPUBOBJ() {
        return this.GetParamStringValue(TAG_CTRLPARTPUBOBJ, "");
    }

    public final void setCTRLPARTPUBOBJ(String strValue) {
        this.SetParamValue(TAG_CTRLPARTPUBOBJ, strValue);
    }

    public final boolean isEDITORPUBOBJNull() {
        return this.IsParamNull(TAG_EDITORPUBOBJ);
    }

    public final String getEDITORPUBOBJ() {
        return this.GetParamStringValue(TAG_EDITORPUBOBJ, "");
    }

    public final void setEDITORPUBOBJ(String strValue) {
        this.SetParamValue(TAG_EDITORPUBOBJ, strValue);
    }

    public final boolean isUAPUBOBJNull() {
        return this.IsParamNull(TAG_UAPUBOBJ);
    }

    public final String getUAPUBOBJ() {
        return this.GetParamStringValue(TAG_UAPUBOBJ, "");
    }

    public final void setUAPUBOBJ(String strValue) {
        this.SetParamValue(TAG_UAPUBOBJ, strValue);
    }

    public final boolean isVLPUBOBJNull() {
        return this.IsParamNull(TAG_VLPUBOBJ);
    }

    public final String getVLPUBOBJ() {
        return this.GetParamStringValue(TAG_VLPUBOBJ, "");
    }

    public final void setVLPUBOBJ(String strValue) {
        this.SetParamValue(TAG_VLPUBOBJ, strValue);
    }

    public final boolean isAPPPUBOBJNull() {
        return this.IsParamNull(TAG_APPPUBOBJ);
    }

    public final String getAPPPUBOBJ() {
        return this.GetParamStringValue(TAG_APPPUBOBJ, "");
    }

    public final void setAPPPUBOBJ(String strValue) {
        this.SetParamValue(TAG_APPPUBOBJ, strValue);
    }

    public final boolean isFORMLAYOUTMODENull() {
        return this.IsParamNull(TAG_FORMLAYOUTMODE);
    }

    public final String getFORMLAYOUTMODE() {
        return this.GetParamStringValue(TAG_FORMLAYOUTMODE, "");
    }

    public final void setFORMLAYOUTMODE(String strValue) {
        this.SetParamValue(TAG_FORMLAYOUTMODE, strValue);
    }

    public final boolean isTYPEOBJNull() {
        return this.IsParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.GetParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.SetParamValue(TAG_TYPEOBJ, strValue);
    }

    public final boolean isPSAPPTYPEIDNull() {
        return this.IsParamNull(TAG_PSAPPTYPEID);
    }

    public final String getPSAPPTYPEID() {
        return this.GetParamStringValue(TAG_PSAPPTYPEID, "");
    }

    public final void setPSAPPTYPEID(String strValue) {
        this.SetParamValue(TAG_PSAPPTYPEID, strValue);
    }

    public final boolean isPSAPPTYPENAMENull() {
        return this.IsParamNull(TAG_PSAPPTYPENAME);
    }

    public final String getPSAPPTYPENAME() {
        return this.GetParamStringValue(TAG_PSAPPTYPENAME, "");
    }

    public final void setPSAPPTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPTYPENAME, strValue);
    }

    public final boolean isSTYLEOBJNull() {
        return this.IsParamNull(TAG_STYLEOBJ);
    }

    public final String getSTYLEOBJ() {
        return this.GetParamStringValue(TAG_STYLEOBJ, "");
    }

    public final void setSTYLEOBJ(String strValue) {
        this.SetParamValue(TAG_STYLEOBJ, strValue);
    }

    public final boolean isJITAPPOBJNull() {
        return this.IsParamNull(TAG_JITAPPOBJ);
    }

    public final String getJITAPPOBJ() {
        return this.GetParamStringValue(TAG_JITAPPOBJ, "");
    }

    public final void setJITAPPOBJ(String strValue) {
        this.SetParamValue(TAG_JITAPPOBJ, strValue);
    }

    public final boolean isUSEJITPREVIEWNull() {
        return this.IsParamNull(TAG_USEJITPREVIEW);
    }

    public final boolean getUSEJITPREVIEW() {
        return this.GetParamIntValue(TAG_USEJITPREVIEW, 0) == 1;
    }

    public final void setUSEJITPREVIEW(boolean bValue) {
        this.SetParamValue(TAG_USEJITPREVIEW, bValue ? 1 : 0);
    }

    public final boolean isSTYLE2OBJNull() {
        return this.IsParamNull(TAG_STYLE2OBJ);
    }

    public final String getSTYLE2OBJ() {
        return this.GetParamStringValue(TAG_STYLE2OBJ, "");
    }

    public final void setSTYLE2OBJ(String strValue) {
        this.SetParamValue(TAG_STYLE2OBJ, strValue);
    }

    public final boolean isV2VIEWPUBOBJNull() {
        return this.IsParamNull(TAG_V2VIEWPUBOBJ);
    }

    public final String getV2VIEWPUBOBJ() {
        return this.GetParamStringValue(TAG_V2VIEWPUBOBJ, "");
    }

    public final void setV2VIEWPUBOBJ(String strValue) {
        this.SetParamValue(TAG_V2VIEWPUBOBJ, strValue);
    }

    public final boolean isV2VIEWMACROPARAMSNull() {
        return this.IsParamNull(TAG_V2VIEWMACROPARAMS);
    }

    public final String getV2VIEWMACROPARAMS() {
        return this.GetParamStringValue(TAG_V2VIEWMACROPARAMS, "");
    }

    public final boolean isV2FOLDERNull() {
        return this.IsParamNull(TAG_V2FOLDER);
    }

    public final String getV2FOLDER() {
        return this.GetParamStringValue(TAG_V2FOLDER, "");
    }

    public final void setV2FOLDER(String strValue) {
        this.SetParamValue(TAG_V2FOLDER, strValue);
    }

    public final boolean isV2GITPATHNull() {
        return this.IsParamNull(TAG_V2GITPATH);
    }

    public final String getV2GITPATH() {
        return this.GetParamStringValue(TAG_V2GITPATH, "");
    }

    public final void setV2GITPATH(String strValue) {
        this.SetParamValue(TAG_V2GITPATH, strValue);
    }

    public final boolean isPFENGINEVERNull() {
        return this.IsParamNull(TAG_PFENGINEVER);
    }

    public final int getPFENGINEVER() {
        return this.GetParamIntValue(TAG_PFENGINEVER, 0);
    }

    public final void setPFENGINEVER(int nValue) {
        this.SetParamValue(TAG_PFENGINEVER, nValue);
    }
}

