/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMStateServer
extends BaseDataEntity {
    public static final String IMSERVERTYPE_STATESERVER = "STATESERVER";
    public static final String IMSERVERTYPE_MEETINGSERVER = "MEETINGSERVER";
    public static final String IMSERVERTYPE_CATALOGSERVER = "CATALOGSERVER";
    public static final String TAG_IMSTATESERVERID = "IMSTATESERVERID";
    public static final String TAG_IMSTATESERVERNAME = "IMSTATESERVERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_IMSERVERTYPE = "IMSERVERTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMDOMAIN = "IMDOMAIN";

    public boolean isIMSTATESERVERIDNull() {
        return this.IsParamNull(TAG_IMSTATESERVERID);
    }

    public String getIMSTATESERVERID() {
        return this.GetParamStringValue(TAG_IMSTATESERVERID, "");
    }

    public void setIMSTATESERVERID(String strValue) {
        this.SetParamValue(TAG_IMSTATESERVERID, strValue);
    }

    public boolean isIMSTATESERVERNAMENull() {
        return this.IsParamNull(TAG_IMSTATESERVERNAME);
    }

    public String getIMSTATESERVERNAME() {
        return this.GetParamStringValue(TAG_IMSTATESERVERNAME, "");
    }

    public void setIMSTATESERVERNAME(String strValue) {
        this.SetParamValue(TAG_IMSTATESERVERNAME, strValue);
    }

    public boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isIMSERVERTYPENull() {
        return this.IsParamNull(TAG_IMSERVERTYPE);
    }

    public String getIMSERVERTYPE() {
        return this.GetParamStringValue(TAG_IMSERVERTYPE, "");
    }

    public void setIMSERVERTYPE(String strValue) {
        this.SetParamValue(TAG_IMSERVERTYPE, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
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

