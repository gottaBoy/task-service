/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysIssueEngine
extends BaseDataEntity {
    public static final String TAG_PSSYSISSUEENGINEID = "PSSYSISSUEENGINEID";
    public static final String TAG_PSSYSISSUEENGINENAME = "PSSYSISSUEENGINENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ENGINEOBJ = "ENGINEOBJ";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ENGINEPARAMS = "ENGINEPARAMS";

    public final boolean isPSSYSISSUEENGINEIDNull() {
        return this.IsParamNull(TAG_PSSYSISSUEENGINEID);
    }

    public final String getPSSYSISSUEENGINEID() {
        return this.GetParamStringValue(TAG_PSSYSISSUEENGINEID, "");
    }

    public final void setPSSYSISSUEENGINEID(String strValue) {
        this.SetParamValue(TAG_PSSYSISSUEENGINEID, strValue);
    }

    public final boolean isPSSYSISSUEENGINENAMENull() {
        return this.IsParamNull(TAG_PSSYSISSUEENGINENAME);
    }

    public final String getPSSYSISSUEENGINENAME() {
        return this.GetParamStringValue(TAG_PSSYSISSUEENGINENAME, "");
    }

    public final void setPSSYSISSUEENGINENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSISSUEENGINENAME, strValue);
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

    public final boolean isENGINEOBJNull() {
        return this.IsParamNull(TAG_ENGINEOBJ);
    }

    public final String getENGINEOBJ() {
        return this.GetParamStringValue(TAG_ENGINEOBJ, "");
    }

    public final void setENGINEOBJ(String strValue) {
        this.SetParamValue(TAG_ENGINEOBJ, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isENGINEPARAMSNull() {
        return this.IsParamNull(TAG_ENGINEPARAMS);
    }

    public final String getENGINEPARAMS() {
        return this.GetParamStringValue(TAG_ENGINEPARAMS, "");
    }

    public final void setENGINEPARAMS(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAMS, strValue);
    }
}

