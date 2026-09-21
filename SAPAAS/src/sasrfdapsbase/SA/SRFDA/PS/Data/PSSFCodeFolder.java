/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFCodeFolder
extends BaseDataEntity {
    public static final String TAG_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String TAG_PSSFCODEFOLDERNAME = "PSSFCODEFOLDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FOLDERNAME = "FOLDERNAME";
    public static final String TAG_HEADERCODE = "HEADERCODE";
    public static final String TAG_BOTTOMCODE = "BOTTOMCODE";
    public static final String TAG_MODELLEVEL = "MODELLEVEL";
    public static final String TAG_PSSFSTYLEPRJID = "PSSFSTYLEPRJID";
    public static final String TAG_PSSFSTYLEPRJNAME = "PSSFSTYLEPRJNAME";
    public static final String TAG_PRJFOLDER = "PRJFOLDER";

    public final boolean isPSSFCODEFOLDERIDNull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERID);
    }

    public final String getPSSFCODEFOLDERID() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERID, "");
    }

    public final void setPSSFCODEFOLDERID(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERID, strValue);
    }

    public final boolean isPSSFCODEFOLDERNAMENull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERNAME);
    }

    public final String getPSSFCODEFOLDERNAME() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERNAME, "");
    }

    public final void setPSSFCODEFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERNAME, strValue);
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

    public final boolean isPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEID);
    }

    public final String getPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEID, "");
    }

    public final void setPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEID, strValue);
    }

    public final boolean isPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLENAME);
    }

    public final String getPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLENAME, "");
    }

    public final void setPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLENAME, strValue);
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

    public final boolean isFOLDERNAMENull() {
        return this.IsParamNull(TAG_FOLDERNAME);
    }

    public final String getFOLDERNAME() {
        return this.GetParamStringValue(TAG_FOLDERNAME, "");
    }

    public final void setFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_FOLDERNAME, strValue);
    }

    public final boolean isHEADERCODENull() {
        return this.IsParamNull(TAG_HEADERCODE);
    }

    public final String getHEADERCODE() {
        return this.GetParamStringValue(TAG_HEADERCODE, "");
    }

    public final void setHEADERCODE(String strValue) {
        this.SetParamValue(TAG_HEADERCODE, strValue);
    }

    public final boolean isBOTTOMCODENull() {
        return this.IsParamNull(TAG_BOTTOMCODE);
    }

    public final String getBOTTOMCODE() {
        return this.GetParamStringValue(TAG_BOTTOMCODE, "");
    }

    public final void setBOTTOMCODE(String strValue) {
        this.SetParamValue(TAG_BOTTOMCODE, strValue);
    }

    public final boolean isMODELLEVELNull() {
        return this.IsParamNull(TAG_MODELLEVEL);
    }

    public final int getMODELLEVEL() {
        return this.GetParamIntValue(TAG_MODELLEVEL, 0);
    }

    public final void setMODELLEVEL(int nValue) {
        this.SetParamValue(TAG_MODELLEVEL, nValue);
    }

    public final boolean isPSSFSTYLEPRJIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEPRJID);
    }

    public final String getPSSFSTYLEPRJID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEPRJID, "");
    }

    public final void setPSSFSTYLEPRJID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEPRJID, strValue);
    }

    public final boolean isPSSFSTYLEPRJNAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLEPRJNAME);
    }

    public final String getPSSFSTYLEPRJNAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLEPRJNAME, "");
    }

    public final void setPSSFSTYLEPRJNAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEPRJNAME, strValue);
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

