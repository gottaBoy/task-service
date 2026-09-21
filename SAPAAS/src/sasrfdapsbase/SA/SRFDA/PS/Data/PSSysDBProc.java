/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDBProc
extends BaseDataEntity {
    public static final String TAG_PSSYSDBPROCID = "PSSYSDBPROCID";
    public static final String TAG_PSSYSDBPROCNAME = "PSSYSDBPROCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String TAG_PSSYSDBSCHEMENAME = "PSSYSDBSCHEMENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSDBPROCIDNull() {
        return this.IsParamNull(TAG_PSSYSDBPROCID);
    }

    public final String getPSSYSDBPROCID() {
        return this.GetParamStringValue(TAG_PSSYSDBPROCID, "");
    }

    public final void setPSSYSDBPROCID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBPROCID, strValue);
    }

    public final boolean isPSSYSDBPROCNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBPROCNAME);
    }

    public final String getPSSYSDBPROCNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBPROCNAME, "");
    }

    public final void setPSSYSDBPROCNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBPROCNAME, strValue);
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

    public final boolean isPSSYSDBSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSDBSCHEMEID);
    }

    public final String getPSSYSDBSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSDBSCHEMEID, "");
    }

    public final void setPSSYSDBSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBSCHEMEID, strValue);
    }

    public final boolean isPSSYSDBSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSDBSCHEMENAME);
    }

    public final String getPSSYSDBSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSDBSCHEMENAME, "");
    }

    public final void setPSSYSDBSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBSCHEMENAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

