/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TempData
extends BaseDataEntity {
    public static final String TAG_TEMPDATAID = "TEMPDATAID";
    public static final String TAG_TEMPDATANAME = "TEMPDATANAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PDEID = "PDEID";
    public static final String TAG_PTEMPKEYNAME = "PTEMPKEYNAME";
    public static final String TAG_PTEMPKEYVALUE = "PTEMPKEYVALUE";
    public static final String TAG_DEDATA = "DEDATA";
    public static final String TAG_SAVEMODE = "SAVEMODE";
    public static final String TAG_NOSAVE = "NOSAVE";

    public String getTEMPDATAID() {
        return this.GetParamStringValue(TAG_TEMPDATAID, "");
    }

    public void setTEMPDATAID(String strValue) {
        this.SetParamValue(TAG_TEMPDATAID, strValue);
    }

    public String getTEMPDATANAME() {
        return this.GetParamStringValue(TAG_TEMPDATANAME, "");
    }

    public void setTEMPDATANAME(String strValue) {
        this.SetParamValue(TAG_TEMPDATANAME, strValue);
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

    public String getPDEID() {
        return this.GetParamStringValue(TAG_PDEID, "");
    }

    public void setPDEID(String strValue) {
        this.SetParamValue(TAG_PDEID, strValue);
    }

    public String getPTEMPKEYNAME() {
        return this.GetParamStringValue(TAG_PTEMPKEYNAME, "");
    }

    public void setPTEMPKEYNAME(String strValue) {
        this.SetParamValue(TAG_PTEMPKEYNAME, strValue);
    }

    public String getPTEMPKEYVALUE() {
        return this.GetParamStringValue(TAG_PTEMPKEYVALUE, "");
    }

    public void setPTEMPKEYVALUE(String strValue) {
        this.SetParamValue(TAG_PTEMPKEYVALUE, strValue);
    }

    public String getDEDATA() {
        return this.GetParamStringValue(TAG_DEDATA, "");
    }

    public void setDEDATA(String strValue) {
        this.SetParamValue(TAG_DEDATA, strValue);
    }

    public String getSAVEMODE() {
        return this.GetParamStringValue(TAG_SAVEMODE, "");
    }

    public void setSAVEMODE(String strValue) {
        this.SetParamValue(TAG_SAVEMODE, strValue);
    }

    public boolean getNOSAVE() {
        return this.GetParamIntValue(TAG_NOSAVE, 0) == 1;
    }

    public void setNOSAVE(boolean bValue) {
        this.SetParamValue(TAG_NOSAVE, bValue ? 1 : 0);
    }
}

