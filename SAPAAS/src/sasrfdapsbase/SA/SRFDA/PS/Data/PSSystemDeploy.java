/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSystemDeploy
extends BaseDataEntity {
    public static final String TAG_PSSYSDEPLOYID = "PSSYSDEPLOYID";
    public static final String TAG_PSSYSDEPLOYNAME = "PSSYSDEPLOYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEFAULTDEPLOY = "DEFAULTDEPLOY";

    public final boolean isPSSYSDEPLOYIDNull() {
        return this.IsParamNull(TAG_PSSYSDEPLOYID);
    }

    public final String getPSSYSDEPLOYID() {
        return this.GetParamStringValue(TAG_PSSYSDEPLOYID, "");
    }

    public final void setPSSYSDEPLOYID(String strValue) {
        this.SetParamValue(TAG_PSSYSDEPLOYID, strValue);
    }

    public final boolean isPSSYSDEPLOYNAMENull() {
        return this.IsParamNull(TAG_PSSYSDEPLOYNAME);
    }

    public final String getPSSYSDEPLOYNAME() {
        return this.GetParamStringValue(TAG_PSSYSDEPLOYNAME, "");
    }

    public final void setPSSYSDEPLOYNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDEPLOYNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDEFAULTDEPLOYNull() {
        return this.IsParamNull(TAG_DEFAULTDEPLOY);
    }

    public final boolean getDEFAULTDEPLOY() {
        return this.GetParamIntValue(TAG_DEFAULTDEPLOY, 0) == 1;
    }

    public final void setDEFAULTDEPLOY(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTDEPLOY, bValue ? 1 : 0);
    }
}

