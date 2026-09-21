/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ORGUnit
extends BaseDataEntity {
    public static final String TAG_ORGUNITID = "ORGUNITID";
    public static final String TAG_ORGUNITNAME = "ORGUNITNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_ORGUNITTYPE = "ORGUNITTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_UNITTITLE = "UNITTITLE";
    public static final String TAG_UNITLEVEL = "UNITLEVEL";

    public final boolean isORGUNITIDNull() {
        return this.IsParamNull(TAG_ORGUNITID);
    }

    public final String getORGUNITID() {
        return this.GetParamStringValue(TAG_ORGUNITID, "");
    }

    public final void setORGUNITID(String strValue) {
        this.SetParamValue(TAG_ORGUNITID, strValue);
    }

    public final boolean isORGUNITNAMENull() {
        return this.IsParamNull(TAG_ORGUNITNAME);
    }

    public final String getORGUNITNAME() {
        return this.GetParamStringValue(TAG_ORGUNITNAME, "");
    }

    public final void setORGUNITNAME(String strValue) {
        this.SetParamValue(TAG_ORGUNITNAME, strValue);
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

    public final boolean isORGUNITTYPENull() {
        return this.IsParamNull(TAG_ORGUNITTYPE);
    }

    public final String getORGUNITTYPE() {
        return this.GetParamStringValue(TAG_ORGUNITTYPE, "");
    }

    public final void setORGUNITTYPE(String strValue) {
        this.SetParamValue(TAG_ORGUNITTYPE, strValue);
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

    public final boolean isUNITTITLENull() {
        return this.IsParamNull(TAG_UNITTITLE);
    }

    public final String getUNITTITLE() {
        return this.GetParamStringValue(TAG_UNITTITLE, "");
    }

    public final void setUNITTITLE(String strValue) {
        this.SetParamValue(TAG_UNITTITLE, strValue);
    }

    public final boolean isUNITLEVELNull() {
        return this.IsParamNull(TAG_UNITLEVEL);
    }

    public final int getUNITLEVEL() {
        return this.GetParamIntValue(TAG_UNITLEVEL, 0);
    }

    public final void setUNITLEVEL(int nValue) {
        this.SetParamValue(TAG_UNITLEVEL, nValue);
    }
}

