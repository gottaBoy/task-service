/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSampleValue
extends BaseDataEntity {
    public static final String TAG_PSSAMPLEVALUEID = "PSSAMPLEVALUEID";
    public static final String TAG_PSSAMPLEVALUENAME = "PSSAMPLEVALUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_NULLVALUE = "NULLVALUE";
    public static final String TAG_VALUELIST = "VALUELIST";

    public final boolean isPSSAMPLEVALUEIDNull() {
        return this.IsParamNull(TAG_PSSAMPLEVALUEID);
    }

    public final String getPSSAMPLEVALUEID() {
        return this.GetParamStringValue(TAG_PSSAMPLEVALUEID, "");
    }

    public final void setPSSAMPLEVALUEID(String strValue) {
        this.SetParamValue(TAG_PSSAMPLEVALUEID, strValue);
    }

    public final boolean isPSSAMPLEVALUENAMENull() {
        return this.IsParamNull(TAG_PSSAMPLEVALUENAME);
    }

    public final String getPSSAMPLEVALUENAME() {
        return this.GetParamStringValue(TAG_PSSAMPLEVALUENAME, "");
    }

    public final void setPSSAMPLEVALUENAME(String strValue) {
        this.SetParamValue(TAG_PSSAMPLEVALUENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isVALUENull() {
        return this.IsParamNull(TAG_VALUE);
    }

    public final String getVALUE() {
        return this.GetParamStringValue(TAG_VALUE, "");
    }

    public final void setVALUE(String strValue) {
        this.SetParamValue(TAG_VALUE, strValue);
    }

    public final boolean isNULLVALUENull() {
        return this.IsParamNull(TAG_NULLVALUE);
    }

    public final boolean getNULLVALUE() {
        return this.GetParamIntValue(TAG_NULLVALUE, 0) == 1;
    }

    public final void setNULLVALUE(boolean bValue) {
        this.SetParamValue(TAG_NULLVALUE, bValue ? 1 : 0);
    }

    public final boolean isVALUELISTNull() {
        return this.IsParamNull(TAG_VALUELIST);
    }

    public final String getVALUELIST() {
        return this.GetParamStringValue(TAG_VALUELIST, "");
    }

    public final void setVALUELIST(String strValue) {
        this.SetParamValue(TAG_VALUELIST, strValue);
    }
}

