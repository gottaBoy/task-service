/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMServer
extends BaseDataEntity {
    public static final String IMSERVERTYPE_CATALOGSERVER = "CATALOGSERVER";
    public static final String IMSERVERTYPE_MEETINGSERVER = "MEETINGSERVER";
    public static final String IMSERVERTYPE_STATESERVER = "STATESERVER";
    public static final String IMDOMAIN_IMDOMAIN001 = "IMDOMAIN001";
    public static final String IMDOMAIN_IMDOMAIN002 = "IMDOMAIN002";
    public static final String IMDOMAIN_IMDOMAIN004 = "IMDOMAIN004";
    public static final String IMDOMAIN_IMDOMAIN005 = "IMDOMAIN005";
    public static final String IMDOMAIN_IMDOMAIN006 = "IMDOMAIN006";
    public static final String IMDOMAIN_IMDOMAIN007 = "IMDOMAIN007";
    public static final String IMDOMAIN_IMDOMAIN008 = "IMDOMAIN008";
    public static final String IMDOMAIN_IMDOMAIN009 = "IMDOMAIN009";
    public static final String IMDOMAIN_IMDOMAIN010 = "IMDOMAIN010";
    public static final String IMDOMAIN_IMDOMAIN003 = "IMDOMAIN003";
    public static final String TAG_IMSERVERID = "IMSERVERID";
    public static final String TAG_IMSERVERNAME = "IMSERVERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_IMSERVERTYPE = "IMSERVERTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SERVERPATH = "SERVERPATH";
    public static final String TAG_SERVERCOMETPATH = "SERVERCOMETPATH";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IMDOMAIN = "IMDOMAIN";

    public final boolean isIMSERVERIDNull() {
        return this.IsParamNull(TAG_IMSERVERID);
    }

    public final String getIMSERVERID() {
        return this.GetParamStringValue(TAG_IMSERVERID, "");
    }

    public final void setIMSERVERID(String strValue) {
        this.SetParamValue(TAG_IMSERVERID, strValue);
    }

    public final boolean isIMSERVERNAMENull() {
        return this.IsParamNull(TAG_IMSERVERNAME);
    }

    public final String getIMSERVERNAME() {
        return this.GetParamStringValue(TAG_IMSERVERNAME, "");
    }

    public final void setIMSERVERNAME(String strValue) {
        this.SetParamValue(TAG_IMSERVERNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public final boolean isIMSERVERTYPENull() {
        return this.IsParamNull(TAG_IMSERVERTYPE);
    }

    public final String getIMSERVERTYPE() {
        return this.GetParamStringValue(TAG_IMSERVERTYPE, "");
    }

    public final void setIMSERVERTYPE(String strValue) {
        this.SetParamValue(TAG_IMSERVERTYPE, strValue);
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

    public final boolean isSERVERPATHNull() {
        return this.IsParamNull(TAG_SERVERPATH);
    }

    public final String getSERVERPATH() {
        return this.GetParamStringValue(TAG_SERVERPATH, "");
    }

    public final void setSERVERPATH(String strValue) {
        this.SetParamValue(TAG_SERVERPATH, strValue);
    }

    public final boolean isSERVERCOMETPATHNull() {
        return this.IsParamNull(TAG_SERVERCOMETPATH);
    }

    public final String getSERVERCOMETPATH() {
        return this.GetParamStringValue(TAG_SERVERCOMETPATH, "");
    }

    public final void setSERVERCOMETPATH(String strValue) {
        this.SetParamValue(TAG_SERVERCOMETPATH, strValue);
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

    public final boolean isIMDOMAINNull() {
        return this.IsParamNull(TAG_IMDOMAIN);
    }

    public final String getIMDOMAIN() {
        return this.GetParamStringValue(TAG_IMDOMAIN, "");
    }

    public final void setIMDOMAIN(String strValue) {
        this.SetParamValue(TAG_IMDOMAIN, strValue);
    }
}

