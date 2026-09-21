/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFStyleVer
extends BaseDataEntity {
    public static final int PUBMODE_1 = 1;
    public static final int PUBMODE_2 = 2;
    public static final String TAG_PSSFSTYLEVERID = "PSSFSTYLEVERID";
    public static final String TAG_PSSFSTYLEVERNAME = "PSSFSTYLEVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String TAG_PUBMODE = "PUBMODE";
    public static final String TAG_MAJOR = "MAJOR";
    public static final String TAG_MINOR = "MINOR";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSFID = "PSSFID";

    public final boolean isPSSFSTYLEVERIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEVERID);
    }

    public final String getPSSFSTYLEVERID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEVERID, "");
    }

    public final void setPSSFSTYLEVERID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEVERID, strValue);
    }

    public final boolean isPSSFSTYLEVERNAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLEVERNAME);
    }

    public final String getPSSFSTYLEVERNAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLEVERNAME, "");
    }

    public final void setPSSFSTYLEVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEVERNAME, strValue);
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

    public final boolean isPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEID);
    }

    public final String getPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEID, "");
    }

    public final void setPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEID, strValue);
    }

    public final boolean isPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLENAME);
    }

    public final String getPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLENAME, "");
    }

    public final void setPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLENAME, strValue);
    }

    public final boolean isPUBMODENull() {
        return this.IsParamNull(TAG_PUBMODE);
    }

    public final int getPUBMODE() {
        return this.GetParamIntValue(TAG_PUBMODE, 0);
    }

    public final void setPUBMODE(int nValue) {
        this.SetParamValue(TAG_PUBMODE, nValue);
    }

    public final boolean isMAJORNull() {
        return this.IsParamNull(TAG_MAJOR);
    }

    public final int getMAJOR() {
        return this.GetParamIntValue(TAG_MAJOR, 0);
    }

    public final void setMAJOR(int nValue) {
        this.SetParamValue(TAG_MAJOR, nValue);
    }

    public final boolean isMINORNull() {
        return this.IsParamNull(TAG_MINOR);
    }

    public final int getMINOR() {
        return this.GetParamIntValue(TAG_MINOR, 0);
    }

    public final void setMINOR(int nValue) {
        this.SetParamValue(TAG_MINOR, nValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
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

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }
}

