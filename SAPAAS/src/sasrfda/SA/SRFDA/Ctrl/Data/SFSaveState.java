/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class SFSaveState
extends BaseDataEntity {
    public static final String TAG_SFSAVESTATEID = "SFSAVESTATEID";
    public static final String TAG_SFSAVESTATENAME = "SFSAVESTATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_SFID = "SFID";
    public static final String TAG_SAVESTATE = "SAVESTATE";

    public String getSFSAVESTATEID() {
        return this.GetParamStringValue(TAG_SFSAVESTATEID, "");
    }

    public void setSFSAVESTATEID(String strValue) {
        this.SetParamValue(TAG_SFSAVESTATEID, strValue);
    }

    public String getSFSAVESTATENAME() {
        return this.GetParamStringValue(TAG_SFSAVESTATENAME, "");
    }

    public void setSFSAVESTATENAME(String strValue) {
        this.SetParamValue(TAG_SFSAVESTATENAME, strValue);
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

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getSFID() {
        return this.GetParamStringValue(TAG_SFID, "");
    }

    public void setSFID(String strValue) {
        this.SetParamValue(TAG_SFID, strValue);
    }

    public String getSAVESTATE() {
        return this.GetParamStringValue(TAG_SAVESTATE, "");
    }

    public void setSAVESTATE(String strValue) {
        this.SetParamValue(TAG_SAVESTATE, strValue);
    }
}

