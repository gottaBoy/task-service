/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDataQueryCodeExpV3
extends BaseDataEntity {
    public static final String TAG_PSDEDQCODEEXPID = "PSDEDQCODEEXPID";
    public static final String TAG_PSDEDQCODEEXPNAME = "PSDEDQCODEEXPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDQCODEID = "PSDEDQCODEID";
    public static final String TAG_PSDEDQCODENAME = "PSDEDQCODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_EXPCODE = "EXPCODE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSDEDQCODEEXPIDNull() {
        return this.IsParamNull(TAG_PSDEDQCODEEXPID);
    }

    public final String getPSDEDQCODEEXPID() {
        return this.GetParamStringValue(TAG_PSDEDQCODEEXPID, "");
    }

    public final void setPSDEDQCODEEXPID(String strValue) {
        this.SetParamValue(TAG_PSDEDQCODEEXPID, strValue);
    }

    public final boolean isPSDEDQCODEEXPNAMENull() {
        return this.IsParamNull(TAG_PSDEDQCODEEXPNAME);
    }

    public final String getPSDEDQCODEEXPNAME() {
        return this.GetParamStringValue(TAG_PSDEDQCODEEXPNAME, "");
    }

    public final void setPSDEDQCODEEXPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQCODEEXPNAME, strValue);
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

    public final boolean isPSDEDQCODEIDNull() {
        return this.IsParamNull(TAG_PSDEDQCODEID);
    }

    public final String getPSDEDQCODEID() {
        return this.GetParamStringValue(TAG_PSDEDQCODEID, "");
    }

    public final void setPSDEDQCODEID(String strValue) {
        this.SetParamValue(TAG_PSDEDQCODEID, strValue);
    }

    public final boolean isPSDEDQCODENAMENull() {
        return this.IsParamNull(TAG_PSDEDQCODENAME);
    }

    public final String getPSDEDQCODENAME() {
        return this.GetParamStringValue(TAG_PSDEDQCODENAME, "");
    }

    public final void setPSDEDQCODENAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQCODENAME, strValue);
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

    public final boolean isEXPCODENull() {
        return this.IsParamNull(TAG_EXPCODE);
    }

    public final String getEXPCODE() {
        return this.GetParamStringValue(TAG_EXPCODE, "");
    }

    public final void setEXPCODE(String strValue) {
        this.SetParamValue(TAG_EXPCODE, strValue);
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
}

