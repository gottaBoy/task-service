/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMServerLog
extends BaseDataEntity {
    public static final String TAG_IMSERVERLOGID = "IMSERVERLOGID";
    public static final String TAG_IMSERVERLOGNAME = "IMSERVERLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMSERVERID = "IMSERVERID";
    public static final String TAG_IMSERVERNAME = "IMSERVERNAME";
    public static final String TAG_LOGINFO = "LOGINFO";

    public final boolean isIMSERVERLOGIDNull() {
        return this.IsParamNull(TAG_IMSERVERLOGID);
    }

    public final String getIMSERVERLOGID() {
        return this.GetParamStringValue(TAG_IMSERVERLOGID, "");
    }

    public final void setIMSERVERLOGID(String strValue) {
        this.SetParamValue(TAG_IMSERVERLOGID, strValue);
    }

    public final boolean isIMSERVERLOGNAMENull() {
        return this.IsParamNull(TAG_IMSERVERLOGNAME);
    }

    public final String getIMSERVERLOGNAME() {
        return this.GetParamStringValue(TAG_IMSERVERLOGNAME, "");
    }

    public final void setIMSERVERLOGNAME(String strValue) {
        this.SetParamValue(TAG_IMSERVERLOGNAME, strValue);
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

    public final boolean isLOGINFONull() {
        return this.IsParamNull(TAG_LOGINFO);
    }

    public final String getLOGINFO() {
        return this.GetParamStringValue(TAG_LOGINFO, "");
    }

    public final void setLOGINFO(String strValue) {
        this.SetParamValue(TAG_LOGINFO, strValue);
    }
}

