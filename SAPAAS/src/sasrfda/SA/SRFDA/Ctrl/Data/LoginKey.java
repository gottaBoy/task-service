/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class LoginKey
extends BaseDataEntity {
    public static final String TAG_LOINGKEYID = "LOINGKEYID";
    public static final String TAG_LOINGKEYNAME = "LOINGKEYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IPADDRESS = "IPADDRESS";
    public static final String TAG_LIMITCNT = "LIMITCNT";
    public static final String TAG_EXPIREDTIME = "EXPIREDTIME";

    public String getLOINGKEYID() {
        return this.GetParamStringValue(TAG_LOINGKEYID, "");
    }

    public void setLOINGKEYID(String strValue) {
        this.SetParamValue(TAG_LOINGKEYID, strValue);
    }

    public String getLOINGKEYNAME() {
        return this.GetParamStringValue(TAG_LOINGKEYNAME, "");
    }

    public void setLOINGKEYNAME(String strValue) {
        this.SetParamValue(TAG_LOINGKEYNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getIPADDRESS() {
        return this.GetParamStringValue(TAG_IPADDRESS, "");
    }

    public void setIPADDRESS(String strValue) {
        this.SetParamValue(TAG_IPADDRESS, strValue);
    }

    public int getLIMITCNT() {
        return this.GetParamIntValue(TAG_LIMITCNT, 0);
    }

    public void setLIMITCNT(int strValue) {
        this.SetParamValue(TAG_LIMITCNT, strValue);
    }

    public Date getEXPIREDTIME() {
        return this.GetParamDateValue(TAG_EXPIREDTIME, null);
    }

    public void setEXPIREDTIME(Date strValue) {
        this.SetParamValue(TAG_EXPIREDTIME, strValue);
    }
}

