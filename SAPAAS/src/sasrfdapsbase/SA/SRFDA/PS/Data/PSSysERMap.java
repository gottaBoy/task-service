/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysERMap
extends BaseDataEntity {
    public static final String TAG_PSSYSERMAPID = "PSSYSERMAPID";
    public static final String TAG_PSSYSERMAPNAME = "PSSYSERMAPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ALLENTITYFLAG = "ALLENTITYFLAG";
    public static final String TAG_INCSUBSYSFLAG = "INCSUBSYSFLAG";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";

    public final boolean isPSSYSERMAPIDNull() {
        return this.IsParamNull(TAG_PSSYSERMAPID);
    }

    public final String getPSSYSERMAPID() {
        return this.GetParamStringValue(TAG_PSSYSERMAPID, "");
    }

    public final void setPSSYSERMAPID(String strValue) {
        this.SetParamValue(TAG_PSSYSERMAPID, strValue);
    }

    public final boolean isPSSYSERMAPNAMENull() {
        return this.IsParamNull(TAG_PSSYSERMAPNAME);
    }

    public final String getPSSYSERMAPNAME() {
        return this.GetParamStringValue(TAG_PSSYSERMAPNAME, "");
    }

    public final void setPSSYSERMAPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSERMAPNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isALLENTITYFLAGNull() {
        return this.IsParamNull(TAG_ALLENTITYFLAG);
    }

    public final boolean getALLENTITYFLAG() {
        return this.GetParamIntValue(TAG_ALLENTITYFLAG, 0) == 1;
    }

    public final void setALLENTITYFLAG(boolean bValue) {
        this.SetParamValue(TAG_ALLENTITYFLAG, bValue ? 1 : 0);
    }

    public final boolean isINCSUBSYSFLAGNull() {
        return this.IsParamNull(TAG_INCSUBSYSFLAG);
    }

    public final boolean getINCSUBSYSFLAG() {
        return this.GetParamIntValue(TAG_INCSUBSYSFLAG, 0) == 1;
    }

    public final void setINCSUBSYSFLAG(boolean bValue) {
        this.SetParamValue(TAG_INCSUBSYSFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }
}

