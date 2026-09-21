/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMOrg
extends BaseDataEntity {
    public static final String ORGTYPE_20 = "20";
    public static final String ORGTYPE_30 = "30";
    public static final String TAG_IMORGID = "IMORGID";
    public static final String TAG_IMORGNAME = "IMORGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PIMORGID = "PIMORGID";
    public static final String TAG_PIMORGNAME = "PIMORGNAME";
    public static final String TAG_ORDERFLAG2 = "ORDERFLAG2";
    public static final String TAG_ORGTYPE = "ORGTYPE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_SHORTNAME = "SHORTNAME";

    public final boolean isIMORGIDNull() {
        return this.IsParamNull(TAG_IMORGID);
    }

    public final String getIMORGID() {
        return this.GetParamStringValue(TAG_IMORGID, "");
    }

    public final void setIMORGID(String strValue) {
        this.SetParamValue(TAG_IMORGID, strValue);
    }

    public final boolean isIMORGNAMENull() {
        return this.IsParamNull(TAG_IMORGNAME);
    }

    public final String getIMORGNAME() {
        return this.GetParamStringValue(TAG_IMORGNAME, "");
    }

    public final void setIMORGNAME(String strValue) {
        this.SetParamValue(TAG_IMORGNAME, strValue);
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

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
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

    public final boolean isPIMORGIDNull() {
        return this.IsParamNull(TAG_PIMORGID);
    }

    public final String getPIMORGID() {
        return this.GetParamStringValue(TAG_PIMORGID, "");
    }

    public final void setPIMORGID(String strValue) {
        this.SetParamValue(TAG_PIMORGID, strValue);
    }

    public final boolean isPIMORGNAMENull() {
        return this.IsParamNull(TAG_PIMORGNAME);
    }

    public final String getPIMORGNAME() {
        return this.GetParamStringValue(TAG_PIMORGNAME, "");
    }

    public final void setPIMORGNAME(String strValue) {
        this.SetParamValue(TAG_PIMORGNAME, strValue);
    }

    public final boolean isORDERFLAG2Null() {
        return this.IsParamNull(TAG_ORDERFLAG2);
    }

    public final String getORDERFLAG2() {
        return this.GetParamStringValue(TAG_ORDERFLAG2, "");
    }

    public final void setORDERFLAG2(String strValue) {
        this.SetParamValue(TAG_ORDERFLAG2, strValue);
    }

    public final boolean isORGTYPENull() {
        return this.IsParamNull(TAG_ORGTYPE);
    }

    public final String getORGTYPE() {
        return this.GetParamStringValue(TAG_ORGTYPE, "");
    }

    public final void setORGTYPE(String strValue) {
        this.SetParamValue(TAG_ORGTYPE, strValue);
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

    public final boolean isSHORTNAMENull() {
        return this.IsParamNull(TAG_SHORTNAME);
    }

    public final String getSHORTNAME() {
        return this.GetParamStringValue(TAG_SHORTNAME, "");
    }

    public final void setSHORTNAME(String strValue) {
        this.SetParamValue(TAG_SHORTNAME, strValue);
    }
}

