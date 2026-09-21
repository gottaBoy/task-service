/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppWFVer
extends BaseDataEntity {
    public static final String TAG_PSAPPWFVERID = "PSAPPWFVERID";
    public static final String TAG_PSAPPWFVERNAME = "PSAPPWFVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSAPPWFID = "PSAPPWFID";
    public static final String TAG_PSAPPWFNAME = "PSAPPWFNAME";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSWORKFLOWID = "PSWORKFLOWID";

    public final boolean isPSAPPWFVERIDNull() {
        return this.IsParamNull(TAG_PSAPPWFVERID);
    }

    public final String getPSAPPWFVERID() {
        return this.GetParamStringValue(TAG_PSAPPWFVERID, "");
    }

    public final void setPSAPPWFVERID(String strValue) {
        this.SetParamValue(TAG_PSAPPWFVERID, strValue);
    }

    public final boolean isPSAPPWFVERNAMENull() {
        return this.IsParamNull(TAG_PSAPPWFVERNAME);
    }

    public final String getPSAPPWFVERNAME() {
        return this.GetParamStringValue(TAG_PSAPPWFVERNAME, "");
    }

    public final void setPSAPPWFVERNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPWFVERNAME, strValue);
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

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
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

    public final boolean isPSWORKFLOWIDNull() {
        return this.IsParamNull(TAG_PSWORKFLOWID);
    }

    public final String getPSWORKFLOWID() {
        return this.GetParamStringValue(TAG_PSWORKFLOWID, "");
    }

    public final void setPSWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWID, strValue);
    }
}

