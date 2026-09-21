/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDevBTType
extends BaseDataEntity {
    public static final String TAG_PSSYSDEVBTTYPEID = "PSSYSDEVBTTYPEID";
    public static final String TAG_PSSYSDEVBTTYPENAME = "PSSYSDEVBTTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TASKOBJ = "TASKOBJ";
    public static final String TAG_USEROBOTFLAG = "USEROBOTFLAG";

    public final boolean isPSSYSDEVBTTYPEIDNull() {
        return this.IsParamNull(TAG_PSSYSDEVBTTYPEID);
    }

    public final String getPSSYSDEVBTTYPEID() {
        return this.GetParamStringValue(TAG_PSSYSDEVBTTYPEID, "");
    }

    public final void setPSSYSDEVBTTYPEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDEVBTTYPEID, strValue);
    }

    public final boolean isPSSYSDEVBTTYPENAMENull() {
        return this.IsParamNull(TAG_PSSYSDEVBTTYPENAME);
    }

    public final String getPSSYSDEVBTTYPENAME() {
        return this.GetParamStringValue(TAG_PSSYSDEVBTTYPENAME, "");
    }

    public final void setPSSYSDEVBTTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDEVBTTYPENAME, strValue);
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

    public final boolean isTASKOBJNull() {
        return this.IsParamNull(TAG_TASKOBJ);
    }

    public final String getTASKOBJ() {
        return this.GetParamStringValue(TAG_TASKOBJ, "");
    }

    public final void setTASKOBJ(String strValue) {
        this.SetParamValue(TAG_TASKOBJ, strValue);
    }

    public final boolean isUSEROBOTFLAGNull() {
        return this.IsParamNull(TAG_USEROBOTFLAG);
    }

    public final boolean getUSEROBOTFLAG() {
        return this.GetParamIntValue(TAG_USEROBOTFLAG, 0) == 1;
    }

    public final void setUSEROBOTFLAG(boolean bValue) {
        this.SetParamValue(TAG_USEROBOTFLAG, bValue ? 1 : 0);
    }
}

