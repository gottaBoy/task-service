/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFCodeTempl
extends BaseDataEntity {
    public static final String TAG_PSSFCODETEMPLID = "PSSFCODETEMPLID";
    public static final String TAG_PSSFCODETEMPLNAME = "PSSFCODETEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String TAG_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TEMPLDESC = "TEMPLDESC";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CHECKMODELONLY = "CHECKMODELONLY";
    public static final String TAG_REMOVEEMPTYFILE = "REMOVEEMPTYFILE";

    public final boolean isPSSFCODETEMPLIDNull() {
        return this.IsParamNull(TAG_PSSFCODETEMPLID);
    }

    public final String getPSSFCODETEMPLID() {
        return this.GetParamStringValue(TAG_PSSFCODETEMPLID, "");
    }

    public final void setPSSFCODETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSFCODETEMPLID, strValue);
    }

    public final boolean isPSSFCODETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSFCODETEMPLNAME);
    }

    public final String getPSSFCODETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSFCODETEMPLNAME, "");
    }

    public final void setPSSFCODETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSFCODETEMPLNAME, strValue);
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

    public final boolean isPSSFCODETYPEIDNull() {
        return this.IsParamNull(TAG_PSSFCODETYPEID);
    }

    public final String getPSSFCODETYPEID() {
        return this.GetParamStringValue(TAG_PSSFCODETYPEID, "");
    }

    public final void setPSSFCODETYPEID(String strValue) {
        this.SetParamValue(TAG_PSSFCODETYPEID, strValue);
    }

    public final boolean isPSSFCODETYPENAMENull() {
        return this.IsParamNull(TAG_PSSFCODETYPENAME);
    }

    public final String getPSSFCODETYPENAME() {
        return this.GetParamStringValue(TAG_PSSFCODETYPENAME, "");
    }

    public final void setPSSFCODETYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSFCODETYPENAME, strValue);
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

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.IsParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.GetParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isTEMPLDESCNull() {
        return this.IsParamNull(TAG_TEMPLDESC);
    }

    public final String getTEMPLDESC() {
        return this.GetParamStringValue(TAG_TEMPLDESC, "");
    }

    public final void setTEMPLDESC(String strValue) {
        this.SetParamValue(TAG_TEMPLDESC, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isCHECKMODELONLYNull() {
        return this.IsParamNull(TAG_CHECKMODELONLY);
    }

    public final boolean getCHECKMODELONLY() {
        return this.GetParamIntValue(TAG_CHECKMODELONLY, 0) == 1;
    }

    public final void setCHECKMODELONLY(boolean bValue) {
        this.SetParamValue(TAG_CHECKMODELONLY, bValue ? 1 : 0);
    }

    public final boolean isREMOVEEMPTYFILENull() {
        return this.IsParamNull(TAG_REMOVEEMPTYFILE);
    }

    public final boolean getREMOVEEMPTYFILE() {
        return this.GetParamIntValue(TAG_REMOVEEMPTYFILE, 0) == 1;
    }

    public final void setREMOVEEMPTYFILE(boolean bValue) {
        this.SetParamValue(TAG_REMOVEEMPTYFILE, bValue ? 1 : 0);
    }
}

