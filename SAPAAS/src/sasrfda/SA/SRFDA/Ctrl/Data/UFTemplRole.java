/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UFTemplRole
extends BaseDataEntity {
    public static final String TAG_UFTEMPLROLEID = "UFTEMPLROLEID";
    public static final String TAG_UFTEMPLROLENAME = "UFTEMPLROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USERROLEID = "USERROLEID";
    public static final String TAG_USERROLENAME = "USERROLENAME";
    public static final String TAG_USERFUNCTEMPLID = "USERFUNCTEMPLID";
    public static final String TAG_USERFUNCTEMPLNAME = "USERFUNCTEMPLNAME";
    public static final String TAG_RSTAG = "RSTAG";

    public final boolean isUFTEMPLROLEIDNull() {
        return this.IsParamNull(TAG_UFTEMPLROLEID);
    }

    public final String getUFTEMPLROLEID() {
        return this.GetParamStringValue(TAG_UFTEMPLROLEID, "");
    }

    public final void setUFTEMPLROLEID(String strValue) {
        this.SetParamValue(TAG_UFTEMPLROLEID, strValue);
    }

    public final boolean isUFTEMPLROLENAMENull() {
        return this.IsParamNull(TAG_UFTEMPLROLENAME);
    }

    public final String getUFTEMPLROLENAME() {
        return this.GetParamStringValue(TAG_UFTEMPLROLENAME, "");
    }

    public final void setUFTEMPLROLENAME(String strValue) {
        this.SetParamValue(TAG_UFTEMPLROLENAME, strValue);
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

    public final boolean isUSERFUNCTEMPLIDNull() {
        return this.IsParamNull(TAG_USERFUNCTEMPLID);
    }

    public final String getUSERFUNCTEMPLID() {
        return this.GetParamStringValue(TAG_USERFUNCTEMPLID, "");
    }

    public final void setUSERFUNCTEMPLID(String strValue) {
        this.SetParamValue(TAG_USERFUNCTEMPLID, strValue);
    }

    public final boolean isUSERFUNCTEMPLNAMENull() {
        return this.IsParamNull(TAG_USERFUNCTEMPLNAME);
    }

    public final String getUSERFUNCTEMPLNAME() {
        return this.GetParamStringValue(TAG_USERFUNCTEMPLNAME, "");
    }

    public final void setUSERFUNCTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_USERFUNCTEMPLNAME, strValue);
    }

    public final boolean isRSTAGNull() {
        return this.IsParamNull(TAG_RSTAG);
    }

    public final String getRSTAG() {
        return this.GetParamStringValue(TAG_RSTAG, "");
    }

    public final void setRSTAG(String strValue) {
        this.SetParamValue(TAG_RSTAG, strValue);
    }
}

