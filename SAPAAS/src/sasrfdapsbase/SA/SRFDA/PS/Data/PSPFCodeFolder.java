/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFCodeFolder
extends BaseDataEntity {
    public static final String PRJTYPE_APP_PUB = "APP_PUB";
    public static final String PRJTYPE_APP_USR = "APP_USR";
    public static final String TAG_PSPFCODEFOLDERID = "PSPFCODEFOLDERID";
    public static final String TAG_PSPFCODEFOLDERNAME = "PSPFCODEFOLDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_FOLDERNAME = "FOLDERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PRJTYPE = "PRJTYPE";
    public static final String TAG_PRJFOLDER = "PRJFOLDER";

    public final boolean isPSPFCODEFOLDERIDNull() {
        return this.IsParamNull(TAG_PSPFCODEFOLDERID);
    }

    public final String getPSPFCODEFOLDERID() {
        return this.GetParamStringValue(TAG_PSPFCODEFOLDERID, "");
    }

    public final void setPSPFCODEFOLDERID(String strValue) {
        this.SetParamValue(TAG_PSPFCODEFOLDERID, strValue);
    }

    public final boolean isPSPFCODEFOLDERNAMENull() {
        return this.IsParamNull(TAG_PSPFCODEFOLDERNAME);
    }

    public final String getPSPFCODEFOLDERNAME() {
        return this.GetParamStringValue(TAG_PSPFCODEFOLDERNAME, "");
    }

    public final void setPSPFCODEFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_PSPFCODEFOLDERNAME, strValue);
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

    public final boolean isFOLDERNAMENull() {
        return this.IsParamNull(TAG_FOLDERNAME);
    }

    public final String getFOLDERNAME() {
        return this.GetParamStringValue(TAG_FOLDERNAME, "");
    }

    public final void setFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_FOLDERNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPRJTYPENull() {
        return this.IsParamNull(TAG_PRJTYPE);
    }

    public final String getPRJTYPE() {
        return this.GetParamStringValue(TAG_PRJTYPE, "");
    }

    public final void setPRJTYPE(String strValue) {
        this.SetParamValue(TAG_PRJTYPE, strValue);
    }

    public final boolean isPRJFOLDERNull() {
        return this.IsParamNull(TAG_PRJFOLDER);
    }

    public final String getPRJFOLDER() {
        return this.GetParamStringValue(TAG_PRJFOLDER, "");
    }

    public final void setPRJFOLDER(String strValue) {
        this.SetParamValue(TAG_PRJFOLDER, strValue);
    }
}

