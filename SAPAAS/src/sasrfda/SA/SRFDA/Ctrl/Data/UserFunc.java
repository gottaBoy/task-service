/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UserFunc
extends BaseDataEntity {
    public static final String TAG_USERFUNCID = "USERFUNCID";
    public static final String TAG_USERFUNCNAME = "USERFUNCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USEROBJECTID = "USEROBJECTID";
    public static final String TAG_USEROBJECTNAME = "USEROBJECTNAME";
    public static final String TAG_USERFUNCTEMPLID = "USERFUNCTEMPLID";
    public static final String TAG_USERFUNCTEMPLNAME = "USERFUNCTEMPLNAME";
    public static final String TAG_OPABILITY = "OPABILITY";
    public static final String TAG_DATARANGE = "DATARANGE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isUSERFUNCIDNull() {
        return this.IsParamNull(TAG_USERFUNCID);
    }

    public final String getUSERFUNCID() {
        return this.GetParamStringValue(TAG_USERFUNCID, "");
    }

    public final void setUSERFUNCID(String strValue) {
        this.SetParamValue(TAG_USERFUNCID, strValue);
    }

    public final boolean isUSERFUNCNAMENull() {
        return this.IsParamNull(TAG_USERFUNCNAME);
    }

    public final String getUSERFUNCNAME() {
        return this.GetParamStringValue(TAG_USERFUNCNAME, "");
    }

    public final void setUSERFUNCNAME(String strValue) {
        this.SetParamValue(TAG_USERFUNCNAME, strValue);
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

    public final boolean isUSEROBJECTIDNull() {
        return this.IsParamNull(TAG_USEROBJECTID);
    }

    public final String getUSEROBJECTID() {
        return this.GetParamStringValue(TAG_USEROBJECTID, "");
    }

    public final void setUSEROBJECTID(String strValue) {
        this.SetParamValue(TAG_USEROBJECTID, strValue);
    }

    public final boolean isUSEROBJECTNAMENull() {
        return this.IsParamNull(TAG_USEROBJECTNAME);
    }

    public final String getUSEROBJECTNAME() {
        return this.GetParamStringValue(TAG_USEROBJECTNAME, "");
    }

    public final void setUSEROBJECTNAME(String strValue) {
        this.SetParamValue(TAG_USEROBJECTNAME, strValue);
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

    public final boolean isOPABILITYNull() {
        return this.IsParamNull(TAG_OPABILITY);
    }

    public final String getOPABILITY() {
        return this.GetParamStringValue(TAG_OPABILITY, "");
    }

    public final void setOPABILITY(String strValue) {
        this.SetParamValue(TAG_OPABILITY, strValue);
    }

    public final boolean isDATARANGENull() {
        return this.IsParamNull(TAG_DATARANGE);
    }

    public final String getDATARANGE() {
        return this.GetParamStringValue(TAG_DATARANGE, "");
    }

    public final void setDATARANGE(String strValue) {
        this.SetParamValue(TAG_DATARANGE, strValue);
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
}

