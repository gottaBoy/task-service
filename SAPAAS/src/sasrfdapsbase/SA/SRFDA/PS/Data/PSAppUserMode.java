/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppUserMode
extends BaseDataEntity {
    public static final String TAG_PSAPPUSERMODEID = "PSAPPUSERMODEID";
    public static final String TAG_PSAPPUSERMODENAME = "PSAPPUSERMODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSUSERMODEID = "PSSYSUSERMODEID";
    public static final String TAG_PSSYSUSERMODENAME = "PSSYSUSERMODENAME";
    public static final String TAG_PSAPPMENUID = "PSAPPMENUID";
    public static final String TAG_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";

    public final boolean isPSAPPUSERMODEIDNull() {
        return this.IsParamNull(TAG_PSAPPUSERMODEID);
    }

    public final String getPSAPPUSERMODEID() {
        return this.GetParamStringValue(TAG_PSAPPUSERMODEID, "");
    }

    public final void setPSAPPUSERMODEID(String strValue) {
        this.SetParamValue(TAG_PSAPPUSERMODEID, strValue);
    }

    public final boolean isPSAPPUSERMODENAMENull() {
        return this.IsParamNull(TAG_PSAPPUSERMODENAME);
    }

    public final String getPSAPPUSERMODENAME() {
        return this.GetParamStringValue(TAG_PSAPPUSERMODENAME, "");
    }

    public final void setPSAPPUSERMODENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPUSERMODENAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPSSYSUSERMODEIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERMODEID);
    }

    public final String getPSSYSUSERMODEID() {
        return this.GetParamStringValue(TAG_PSSYSUSERMODEID, "");
    }

    public final void setPSSYSUSERMODEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERMODEID, strValue);
    }

    public final boolean isPSSYSUSERMODENAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERMODENAME);
    }

    public final String getPSSYSUSERMODENAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERMODENAME, "");
    }

    public final void setPSSYSUSERMODENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERMODENAME, strValue);
    }

    public final boolean isPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.GetParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUNAME, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }
}

