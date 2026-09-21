/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.ND.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class NDUserGroup
extends BaseDataEntity {
    public static final String NDUSEROBJECTTYPE_USERGROUP = "USERGROUP";
    public static final String NDUSEROBJECTTYPE_USER = "USER";
    public static final String TAG_NDUSERGROUPID = "NDUSERGROUPID";
    public static final String TAG_NDUSERGROUPNAME = "NDUSERGROUPNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_NDUSEROBJECTTYPE = "NDUSEROBJECTTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";

    public final boolean isNDUSERGROUPIDNull() {
        return this.IsParamNull(TAG_NDUSERGROUPID);
    }

    public final String getNDUSERGROUPID() {
        return this.GetParamStringValue(TAG_NDUSERGROUPID, "");
    }

    public final void setNDUSERGROUPID(String strValue) {
        this.SetParamValue(TAG_NDUSERGROUPID, strValue);
    }

    public final boolean isNDUSERGROUPNAMENull() {
        return this.IsParamNull(TAG_NDUSERGROUPNAME);
    }

    public final String getNDUSERGROUPNAME() {
        return this.GetParamStringValue(TAG_NDUSERGROUPNAME, "");
    }

    public final void setNDUSERGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NDUSERGROUPNAME, strValue);
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

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isNDUSEROBJECTTYPENull() {
        return this.IsParamNull(TAG_NDUSEROBJECTTYPE);
    }

    public final String getNDUSEROBJECTTYPE() {
        return this.GetParamStringValue(TAG_NDUSEROBJECTTYPE, "");
    }

    public final void setNDUSEROBJECTTYPE(String strValue) {
        this.SetParamValue(TAG_NDUSEROBJECTTYPE, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }
}

