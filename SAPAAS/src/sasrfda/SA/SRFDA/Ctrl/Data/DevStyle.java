/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DevStyle
extends BaseDataEntity {
    public static final String TAG_DEVSTYLEID = "DEVSTYLEID";
    public static final String TAG_DEVSTYLENAME = "DEVSTYLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEVSTYOBJECTID = "DEVSTYOBJECTID";
    public static final String TAG_DEVSTYOBJECTNAME = "DEVSTYOBJECTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_STYLEPARAM = "STYLEPARAM";
    public static final String TAG_VERSION = "VERSION";

    public final boolean isDEVSTYLEIDNull() {
        return this.IsParamNull(TAG_DEVSTYLEID);
    }

    public final String getDEVSTYLEID() {
        return this.GetParamStringValue(TAG_DEVSTYLEID, "");
    }

    public final void setDEVSTYLEID(String strValue) {
        this.SetParamValue(TAG_DEVSTYLEID, strValue);
    }

    public final boolean isDEVSTYLENAMENull() {
        return this.IsParamNull(TAG_DEVSTYLENAME);
    }

    public final String getDEVSTYLENAME() {
        return this.GetParamStringValue(TAG_DEVSTYLENAME, "");
    }

    public final void setDEVSTYLENAME(String strValue) {
        this.SetParamValue(TAG_DEVSTYLENAME, strValue);
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

    public final boolean isDEVSTYOBJECTIDNull() {
        return this.IsParamNull(TAG_DEVSTYOBJECTID);
    }

    public final String getDEVSTYOBJECTID() {
        return this.GetParamStringValue(TAG_DEVSTYOBJECTID, "");
    }

    public final void setDEVSTYOBJECTID(String strValue) {
        this.SetParamValue(TAG_DEVSTYOBJECTID, strValue);
    }

    public final boolean isDEVSTYOBJECTNAMENull() {
        return this.IsParamNull(TAG_DEVSTYOBJECTNAME);
    }

    public final String getDEVSTYOBJECTNAME() {
        return this.GetParamStringValue(TAG_DEVSTYOBJECTNAME, "");
    }

    public final void setDEVSTYOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_DEVSTYOBJECTNAME, strValue);
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

    public final boolean isSTYLEPARAMNull() {
        return this.IsParamNull(TAG_STYLEPARAM);
    }

    public final String getSTYLEPARAM() {
        return this.GetParamStringValue(TAG_STYLEPARAM, "");
    }

    public final void setSTYLEPARAM(String strValue) {
        this.SetParamValue(TAG_STYLEPARAM, strValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }
}

