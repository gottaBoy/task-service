/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFViewTempl
extends BaseDataEntity {
    public static final String TAG_PSPFVIEWTEMPLID = "PSPFVIEWTEMPLID";
    public static final String TAG_PSPFVIEWTEMPLNAME = "PSPFVIEWTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String TAG_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String TAG_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_PITEMPLCODE = "PITEMPLCODE";
    public static final String TAG_TYPECODE = "TYPECODE";
    public static final String TAG_FILENAME = "FILENAME";
    public static final String TAG_CODEPATH = "CODEPATH";
    public static final String TAG_VIEWSTYLE = "VIEWSTYLE";
    public static final String TAG_TEMPLFILEPATH = "TEMPLFILEPATH";
    public static final String TAG_PRJPATH = "PRJPATH";

    public final boolean isPSPFVIEWTEMPLIDNull() {
        return this.IsParamNull(TAG_PSPFVIEWTEMPLID);
    }

    public final String getPSPFVIEWTEMPLID() {
        return this.GetParamStringValue(TAG_PSPFVIEWTEMPLID, "");
    }

    public final void setPSPFVIEWTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSPFVIEWTEMPLID, strValue);
    }

    public final boolean isPSPFVIEWTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSPFVIEWTEMPLNAME);
    }

    public final String getPSPFVIEWTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSPFVIEWTEMPLNAME, "");
    }

    public final void setPSPFVIEWTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSPFVIEWTEMPLNAME, strValue);
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

    public final boolean isPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLENAME, strValue);
    }

    public final boolean isPSVIEWTYPEIDNull() {
        return this.IsParamNull(TAG_PSVIEWTYPEID);
    }

    public final String getPSVIEWTYPEID() {
        return this.GetParamStringValue(TAG_PSVIEWTYPEID, "");
    }

    public final void setPSVIEWTYPEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWTYPEID, strValue);
    }

    public final boolean isPSVIEWTYPENAMENull() {
        return this.IsParamNull(TAG_PSVIEWTYPENAME);
    }

    public final String getPSVIEWTYPENAME() {
        return this.GetParamStringValue(TAG_PSVIEWTYPENAME, "");
    }

    public final void setPSVIEWTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWTYPENAME, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.IsParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.GetParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isPSPFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PSPFPUBCODEID);
    }

    public final String getPSPFPUBCODEID() {
        return this.GetParamStringValue(TAG_PSPFPUBCODEID, "");
    }

    public final void setPSPFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODEID, strValue);
    }

    public final boolean isPSPFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PSPFPUBCODENAME);
    }

    public final String getPSPFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PSPFPUBCODENAME, "");
    }

    public final void setPSPFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODENAME, strValue);
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

    public final boolean isPUBOBJNull() {
        return this.IsParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.GetParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.SetParamValue(TAG_PUBOBJ, strValue);
    }

    public final boolean isPITEMPLCODENull() {
        return this.IsParamNull(TAG_PITEMPLCODE);
    }

    public final String getPITEMPLCODE() {
        return this.GetParamStringValue(TAG_PITEMPLCODE, "");
    }

    public final void setPITEMPLCODE(String strValue) {
        this.SetParamValue(TAG_PITEMPLCODE, strValue);
    }

    public final boolean isTYPECODENull() {
        return this.IsParamNull(TAG_TYPECODE);
    }

    public final String getTYPECODE() {
        return this.GetParamStringValue(TAG_TYPECODE, "");
    }

    public final void setTYPECODE(String strValue) {
        this.SetParamValue(TAG_TYPECODE, strValue);
    }

    public final boolean isFILENAMENull() {
        return this.IsParamNull(TAG_FILENAME);
    }

    public final String getFILENAME() {
        return this.GetParamStringValue(TAG_FILENAME, "");
    }

    public final void setFILENAME(String strValue) {
        this.SetParamValue(TAG_FILENAME, strValue);
    }

    public final boolean isCODEPATHNull() {
        return this.IsParamNull(TAG_CODEPATH);
    }

    public final String getCODEPATH() {
        return this.GetParamStringValue(TAG_CODEPATH, "");
    }

    public final void setCODEPATH(String strValue) {
        this.SetParamValue(TAG_CODEPATH, strValue);
    }

    public final boolean isVIEWSTYLENull() {
        return this.IsParamNull(TAG_VIEWSTYLE);
    }

    public final String getVIEWSTYLE() {
        return this.GetParamStringValue(TAG_VIEWSTYLE, "");
    }

    public final void setVIEWSTYLE(String strValue) {
        this.SetParamValue(TAG_VIEWSTYLE, strValue);
    }

    public final boolean isTEMPLFILEPATHNull() {
        return this.IsParamNull(TAG_TEMPLFILEPATH);
    }

    public final String getTEMPLFILEPATH() {
        return this.GetParamStringValue(TAG_TEMPLFILEPATH, "");
    }

    public final void setTEMPLFILEPATH(String strValue) {
        this.SetParamValue(TAG_TEMPLFILEPATH, strValue);
    }

    public final boolean isPRJPATHNull() {
        return this.IsParamNull(TAG_PRJPATH);
    }

    public final String getPRJPATH() {
        return this.GetParamStringValue(TAG_PRJPATH, "");
    }

    public final void setPRJPATH(String strValue) {
        this.SetParamValue(TAG_PRJPATH, strValue);
    }
}

