/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UserDGTheme
extends BaseDataEntity {
    public static final String TAG_USERDGTHEMEID = "USERDGTHEMEID";
    public static final String TAG_USERDGTHEMENAME = "USERDGTHEMENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    public static final String TAG_PROJECTID = "PROJECTID";
    public static final String TAG_PERSONID = "PERSONID";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_RESERVER3 = "RESERVER3";
    public static final String TAG_DGTHEMEMODEL = "DGTHEMEMODEL";

    public String getUSERDGTHEMEID() {
        return this.GetParamStringValue(TAG_USERDGTHEMEID, "");
    }

    public void setUSERDGTHEMEID(String strValue) {
        this.SetParamValue(TAG_USERDGTHEMEID, strValue);
    }

    public String getUSERDGTHEMENAME() {
        return this.GetParamStringValue(TAG_USERDGTHEMENAME, "");
    }

    public void setUSERDGTHEMENAME(String strValue) {
        this.SetParamValue(TAG_USERDGTHEMENAME, strValue);
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

    public String getDATAGRIDID() {
        return this.GetParamStringValue(TAG_DATAGRIDID, "");
    }

    public void setDATAGRIDID(String strValue) {
        this.SetParamValue(TAG_DATAGRIDID, strValue);
    }

    public String getPROJECTID() {
        return this.GetParamStringValue(TAG_PROJECTID, "");
    }

    public void setPROJECTID(String strValue) {
        this.SetParamValue(TAG_PROJECTID, strValue);
    }

    public String getPERSONID() {
        return this.GetParamStringValue(TAG_PERSONID, "");
    }

    public void setPERSONID(String strValue) {
        this.SetParamValue(TAG_PERSONID, strValue);
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public String getRESERVER3() {
        return this.GetParamStringValue(TAG_RESERVER3, "");
    }

    public void setRESERVER3(String strValue) {
        this.SetParamValue(TAG_RESERVER3, strValue);
    }

    public String getDGTHEMEMODEL() {
        return this.GetParamStringValue(TAG_DGTHEMEMODEL, "");
    }

    public void setDGTHEMEMODEL(String strValue) {
        this.SetParamValue(TAG_DGTHEMEMODEL, strValue);
    }
}

