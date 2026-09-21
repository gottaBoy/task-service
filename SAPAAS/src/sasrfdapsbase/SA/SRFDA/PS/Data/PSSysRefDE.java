/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysRefDE
extends BaseDataEntity {
    public static final String TAG_PSSYSREFDEID = "PSSYSREFDEID";
    public static final String TAG_PSSYSREFDENAME = "PSSYSREFDENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSREFID = "PSSYSREFID";
    public static final String TAG_PSSYSREFNAME = "PSSYSREFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_ORIPSDEID = "ORIPSDEID";
    public static final String TAG_SERVICECLS = "SERVICECLS";

    public final boolean isPSSYSREFDEIDNull() {
        return this.IsParamNull(TAG_PSSYSREFDEID);
    }

    public final String getPSSYSREFDEID() {
        return this.GetParamStringValue(TAG_PSSYSREFDEID, "");
    }

    public final void setPSSYSREFDEID(String strValue) {
        this.SetParamValue(TAG_PSSYSREFDEID, strValue);
    }

    public final boolean isPSSYSREFDENAMENull() {
        return this.IsParamNull(TAG_PSSYSREFDENAME);
    }

    public final String getPSSYSREFDENAME() {
        return this.GetParamStringValue(TAG_PSSYSREFDENAME, "");
    }

    public final void setPSSYSREFDENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREFDENAME, strValue);
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

    public final boolean isPSSYSREFIDNull() {
        return this.IsParamNull(TAG_PSSYSREFID);
    }

    public final String getPSSYSREFID() {
        return this.GetParamStringValue(TAG_PSSYSREFID, "");
    }

    public final void setPSSYSREFID(String strValue) {
        this.SetParamValue(TAG_PSSYSREFID, strValue);
    }

    public final boolean isPSSYSREFNAMENull() {
        return this.IsParamNull(TAG_PSSYSREFNAME);
    }

    public final String getPSSYSREFNAME() {
        return this.GetParamStringValue(TAG_PSSYSREFNAME, "");
    }

    public final void setPSSYSREFNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREFNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isORIPSDEIDNull() {
        return this.IsParamNull(TAG_ORIPSDEID);
    }

    public final String getORIPSDEID() {
        return this.GetParamStringValue(TAG_ORIPSDEID, "");
    }

    public final void setORIPSDEID(String strValue) {
        this.SetParamValue(TAG_ORIPSDEID, strValue);
    }

    public final boolean isSERVICECLSNull() {
        return this.IsParamNull(TAG_SERVICECLS);
    }

    public final String getSERVICECLS() {
        return this.GetParamStringValue(TAG_SERVICECLS, "");
    }

    public final void setSERVICECLS(String strValue) {
        this.SetParamValue(TAG_SERVICECLS, strValue);
    }
}

