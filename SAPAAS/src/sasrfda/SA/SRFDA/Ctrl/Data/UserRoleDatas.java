/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UserRoleDatas
extends BaseDataEntity {
    public static final String TAG_USERROLEDATASID = "USERROLEDATASID";
    public static final String TAG_USERROLEDATASNAME = "USERROLEDATASNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USERROLEID = "USERROLEID";
    public static final String TAG_USERROLENAME = "USERROLENAME";
    public static final String TAG_USERROLEDATAID = "USERROLEDATAID";
    public static final String TAG_USERROLEDATANAME = "USERROLEDATANAME";
    public static final String TAG_DENAME = "DENAME";

    public final boolean isUSERROLEDATASIDNull() {
        return this.IsParamNull(TAG_USERROLEDATASID);
    }

    public final String getUSERROLEDATASID() {
        return this.GetParamStringValue(TAG_USERROLEDATASID, "");
    }

    public final void setUSERROLEDATASID(String strValue) {
        this.SetParamValue(TAG_USERROLEDATASID, strValue);
    }

    public final boolean isUSERROLEDATASNAMENull() {
        return this.IsParamNull(TAG_USERROLEDATASNAME);
    }

    public final String getUSERROLEDATASNAME() {
        return this.GetParamStringValue(TAG_USERROLEDATASNAME, "");
    }

    public final void setUSERROLEDATASNAME(String strValue) {
        this.SetParamValue(TAG_USERROLEDATASNAME, strValue);
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

    public final boolean isUSERROLEIDNull() {
        return this.IsParamNull(TAG_USERROLEID);
    }

    public final String getUSERROLEID() {
        return this.GetParamStringValue(TAG_USERROLEID, "");
    }

    public final void setUSERROLEID(String strValue) {
        this.SetParamValue(TAG_USERROLEID, strValue);
    }

    public final boolean isUSERROLENAMENull() {
        return this.IsParamNull(TAG_USERROLENAME);
    }

    public final String getUSERROLENAME() {
        return this.GetParamStringValue(TAG_USERROLENAME, "");
    }

    public final void setUSERROLENAME(String strValue) {
        this.SetParamValue(TAG_USERROLENAME, strValue);
    }

    public final boolean isUSERROLEDATAIDNull() {
        return this.IsParamNull(TAG_USERROLEDATAID);
    }

    public final String getUSERROLEDATAID() {
        return this.GetParamStringValue(TAG_USERROLEDATAID, "");
    }

    public final void setUSERROLEDATAID(String strValue) {
        this.SetParamValue(TAG_USERROLEDATAID, strValue);
    }

    public final boolean isUSERROLEDATANAMENull() {
        return this.IsParamNull(TAG_USERROLEDATANAME);
    }

    public final String getUSERROLEDATANAME() {
        return this.GetParamStringValue(TAG_USERROLEDATANAME, "");
    }

    public final void setUSERROLEDATANAME(String strValue) {
        this.SetParamValue(TAG_USERROLEDATANAME, strValue);
    }

    public final boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public final String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public final void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }
}

