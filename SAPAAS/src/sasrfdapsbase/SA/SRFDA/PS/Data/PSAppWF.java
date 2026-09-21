/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppWF
extends BaseDataEntity {
    public static final String TAG_PSAPPWFID = "PSAPPWFID";
    public static final String TAG_PSAPPWFNAME = "PSAPPWFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String TAG_PSWORKFLOWNAME = "PSWORKFLOWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSAPPWFIDNull() {
        return this.IsParamNull(TAG_PSAPPWFID);
    }

    public final String getPSAPPWFID() {
        return this.GetParamStringValue(TAG_PSAPPWFID, "");
    }

    public final void setPSAPPWFID(String strValue) {
        this.SetParamValue(TAG_PSAPPWFID, strValue);
    }

    public final boolean isPSAPPWFNAMENull() {
        return this.IsParamNull(TAG_PSAPPWFNAME);
    }

    public final String getPSAPPWFNAME() {
        return this.GetParamStringValue(TAG_PSAPPWFNAME, "");
    }

    public final void setPSAPPWFNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPWFNAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSWORKFLOWIDNull() {
        return this.IsParamNull(TAG_PSWORKFLOWID);
    }

    public final String getPSWORKFLOWID() {
        return this.GetParamStringValue(TAG_PSWORKFLOWID, "");
    }

    public final void setPSWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWID, strValue);
    }

    public final boolean isPSWORKFLOWNAMENull() {
        return this.IsParamNull(TAG_PSWORKFLOWNAME);
    }

    public final String getPSWORKFLOWNAME() {
        return this.GetParamStringValue(TAG_PSWORKFLOWNAME, "");
    }

    public final void setPSWORKFLOWNAME(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

